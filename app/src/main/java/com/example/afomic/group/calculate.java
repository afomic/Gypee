package com.example.afomic.group;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class calculate extends AppCompatActivity {


    SearchView searchView;
    ArrayList<ModelCourse> userCourse;
    ArrayList<ModelCourse> selectedCourse;
    Gypee userGypee;
    String username;
    int semester,level,department;
    double totalPoint,totalUnit;
    int tempTotalUnit;
    ModelData myData;
    Bundle bundle;
    GridAdapter adapter;
    ListView gradingList;
    GridLayout layout;
    StudentFaculty faculty;
    Toolbar toolbar;
    SuggestionAdapter suggestionAdapter;
    ListView searchList;
    LinearLayout searchLayout,noCourseLayout;
    Button addButton,noAddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_lan);

        toolbar=(Toolbar)findViewById(R.id.calculate_toolbar);
        setSupportActionBar(toolbar);

        searchList=(ListView) findViewById(R.id.search_list);
        searchLayout=(LinearLayout) findViewById(R.id.search_layout);
        noCourseLayout=(LinearLayout) findViewById(R.id.no_courses_layout);

        addButton=(Button) findViewById(R.id.search_add_button);
        noAddButton=(Button) findViewById(R.id.no_add_button);

        int ScreenLayout=getResources().getConfiguration().screenWidthDp;

       // getting reference to each widget of the layout
        gradingList=(ListView) findViewById(R.id.my_recycle);
        layout=(GridLayout) findViewById(R.id.my_grid);
        Intent intent=getIntent();

        faculty= StudentFaculty.getInstance();

       //  create an object of database
        myData =new ModelData(this);

         //creating a Gypee object from the information provided from the previous activity
        userGypee=handleIntent(intent);

        int userFaculty=faculty.getFaculty(department);
        int userSubgroup=faculty.getSubgroup(department);

        userCourse=myData.getEntries(semester, userFaculty, userSubgroup, department, level);
        if(userCourse.size()==0){
            noCourseLayout.setVisibility(View.VISIBLE);
        }
       // display the checkbox for user to select course
        selectedCourse=new ArrayList<>();


        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelCourse course = suggestionAdapter.getItem(position);
                addCheckBox(course, layout);
                searchLayout.setVisibility(View.GONE);
                hideKeyboard();

            }
        });

        searchList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ModelCourse course = suggestionAdapter.getItem(position);
                add_data fragment = add_data.getInstance(course.name, course.level, course.semester, course.unit);
                fragment.show(getSupportFragmentManager(), null);
                return true;
            }
        });
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_data addDataFragment = new add_data();
                addDataFragment.show(getSupportFragmentManager(), null);
                ModelCourse addedCourse=addDataFragment.getCreatedCourse();
                if(addedCourse!=null){
                    addCheckBox(addedCourse,layout);
                }
                hideKeyboard();
            }
        };

        addButton.setOnClickListener(listener);
        noAddButton.setOnClickListener(listener);
        addCheckBox(userCourse, layout);

    }

    @Override
    public void onBackPressed() {
        if(searchLayout.getVisibility()==View.VISIBLE){
            searchLayout.setVisibility(View.GONE);
        }
        else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.calculate_menu, menu);
        MenuItem item=menu.findItem(R.id.search);
         searchView=(SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<ModelCourse> tempSearchArray=removeDoubleEntry(myData.search(newText));
                searchLayout.setVisibility(View.VISIBLE);
                suggestionAdapter = new SuggestionAdapter(calculate.this,R.layout.search_row,tempSearchArray);
                searchList.setAdapter(suggestionAdapter);
                return true;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchLayout.setVisibility(View.GONE);
                return true;
            }
        });
        searchView.setIconifiedByDefault(false);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_next:
                if (tempTotalUnit != 0) {
                    try {
                        Intent intent=new Intent(calculate.this,result.class);
                        intent.putExtra("username",username);
                        intent.putExtra("department",department);
                        intent.putExtra("semester",semester);
                        intent.putExtra("level", level);
                        userGypee.setTotalUnit(tempTotalUnit);
                        userGypee.setTotalPoint(getTotalPoint(selectedCourse));
                        intent.putExtra("previousPoint", userGypee.getCtotalPoint());
                        intent.putExtra("previousUnit",userGypee.getCtotalUnit());
                        userGypee.addToCgpa(getTotalPoint(selectedCourse), tempTotalUnit);
                        intent.putExtra("totalPoint", userGypee.getCtotalPoint());
                        intent.putExtra("totalUnit",userGypee.getCtotalUnit());
                        intent.putExtra("gpa",String.format("%.2f", userGypee.getGpa()));
                        intent.putExtra("cgpa", String.format("%.2f", userGypee.getCgpa()));
                        startActivity(intent);
                        finish();
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }

                }
                else {
                    Toast.makeText(this,"You must select one or two Courses",Toast.LENGTH_SHORT).show();
                }
            default:
                return false;
        }
    }
    /*
    this is use to add checkBox to the layout,it create checkBox for each of the course in the
     ArrayList passed into the function
     */

    public Gypee handleIntent(Intent intent){
        bundle=intent.getExtras();
        username=bundle.getString("username");

        if(username==null)//check if its a registered user
        {
            department=bundle.getInt("department");
            semester=bundle.getInt("semester");
            level=bundle.getInt("level");
            totalPoint=bundle.getDouble("totalPoint");
            if(totalPoint==0)
            {
                return new Gypee();
            }
            else
            {
                totalUnit=bundle.getDouble("totalUnit");
                return new Gypee(totalUnit,totalPoint);
            }


        } else
        {
            User myUser=myData.getUser(username);
            department=myUser.department;
            semester=myUser.semester;
            level=myUser.level;
            return new Gypee(myUser.totalUnit,myUser.totalPoint);
        }

    }


    public ArrayList<ModelCourse> removeDoubleEntry(ArrayList<ModelCourse> arrayList){
        ArrayList<ModelCourse> truncatedArray=new ArrayList<>();
        for(ModelCourse entry:arrayList){
            if(!isContained(truncatedArray,entry)){
                truncatedArray.add(entry);
            }
        }
        return truncatedArray;
    }
    public void addCheckBox(ArrayList<ModelCourse> courses,GridLayout gridLayout){
        for(ModelCourse course:courses){
            addCheckBox(course,gridLayout);
        }
    }
    public void addCheckBox(ModelCourse course,GridLayout layout){
        CheckBox checkBox=new CheckBox(this);
        checkBox.setText(course.name);
        checkBox.setOnCheckedChangeListener(new checkBoxListener(course.unit,course.name));
        layout.addView(checkBox);

    }
    public class checkBoxListener implements CompoundButton.OnCheckedChangeListener{

        ModelCourse tempCourse;
        public checkBoxListener(int unit,String name) {
            tempCourse =new ModelCourse(unit,name);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                selectedCourse.add(tempCourse);
                tempTotalUnit=tempTotalUnit+tempCourse.unit;
            }
            else {
                selectedCourse.remove(tempCourse);
                tempTotalUnit=tempTotalUnit-tempCourse.unit;
            }
            adapter= new GridAdapter(selectedCourse);
            gradingList.setAdapter(adapter);
        }
    }



    public void hideKeyboard(){
        InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);

    }
    public boolean isContained(ArrayList<ModelCourse> array,ModelCourse course){
        for(ModelCourse entry:array){
            if(entry.name.equals(course.name)){
                return true;
            }
        }
        return false;
    }

    public int  getTotalPoint(ArrayList<ModelCourse> array){
        int myTotalPoint=0;
        for(ModelCourse course:array){
            myTotalPoint=myTotalPoint+(course.getGrade()*course.unit);
        }
        return myTotalPoint;
    }
}
