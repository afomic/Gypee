package com.example.afomic.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class quickAccess extends AppCompatActivity {
    RadioButton hundred,twoHundred,threeHundred,fourHundred,fiveHundred,firstSemester,secondSemester;
    int level, semester,  department;
    String departmentName;
    Spinner departmentSpinner;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_access);

        toolbar=(Toolbar)findViewById(R.id.quick_toolbar);
        setSupportActionBar(toolbar);
        
        final StudentFaculty order=StudentFaculty.getInstance();

        //getting reference to each element on the layout
        hundred=(RadioButton)findViewById(R.id.rb_level_hundred);
        twoHundred=(RadioButton) findViewById(R.id.rb_level_two_hundred);
        threeHundred=(RadioButton) findViewById(R.id.rb_level_three_hundred);
        fourHundred=(RadioButton) findViewById(R.id.rb_level_four_hundred);
        fiveHundred=(RadioButton) findViewById(R.id.rb_level_five_hundred);
        firstSemester=(RadioButton) findViewById(R.id.rb_semester_first);
        secondSemester=(RadioButton) findViewById(R.id.rb_semester_second);
        departmentSpinner=(Spinner)findViewById(R.id.sp_quick);

        //setting action listener to each of the widget
        hundred.setOnCheckedChangeListener(new RbListner());
        threeHundred.setOnCheckedChangeListener(new RbListner());
        twoHundred.setOnCheckedChangeListener(new RbListner());
        fourHundred.setOnCheckedChangeListener(new RbListner());
        fiveHundred.setOnCheckedChangeListener(new RbListner());
        firstSemester.setOnCheckedChangeListener(new RbListner());
        secondSemester.setOnCheckedChangeListener(new RbListner());

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.departments, android.R.layout.simple_selectable_list_item);
        departmentSpinner.setAdapter(spinnerAdapter);
        departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    TextView myView = (TextView) view;
                    departmentName = myView.getText().toString();
                    department=order.getDepartment(departmentName);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Log.e("quickie","application crash");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_next&&checkFields()){
            Intent intent=new Intent(quickAccess.this,calculate.class);
            intent.putExtra("department",department);
            intent.putExtra("level",level);
            intent.putExtra("semester", semester);
            startActivity(intent);

        }
        else {
            Toast.makeText(quickAccess.this,"please fill the fields appropriately",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    public boolean checkFields(){
        if(departmentName.equals("Please Select Your Course")){
            return false;
        }
        else if(semester==0){
            return false;
        }
        else if (level==0){
            return false;
        }
        return true;
    }

    public class RbListner implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.rb_level_hundred:
                    if(isChecked){
                        level=1;
                    }
                    break;
                case R.id.rb_level_two_hundred:
                    if(isChecked){
                        level=2;
                    }
                    break;
                case R.id.rb_level_three_hundred:
                    if(isChecked){
                        level=3;
                    }
                    break;
                case R.id.rb_level_four_hundred:
                    if(isChecked){
                        level=4;
                    }
                    break;
                case R.id.rb_level_five_hundred:
                    if(isChecked){
                        level=5;
                    }
                    break;
                case R.id.rb_semester_first:
                    if(isChecked){
                        semester=1;
                    }
                    break;
                case R.id.rb_semester_second:
                    if(isChecked){
                        semester=2;
                    }
                    break;

            }
        }
    }
}
