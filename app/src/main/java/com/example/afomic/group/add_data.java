package com.example.afomic.group;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class add_data extends DialogFragment {
    EditText courseName,courseSemester,courseLevel,courseUnit;
    Spinner courseDepartment;
    String name,department;
    int level,semester,unit;
    private static final String BUNDLE_COURSE_NAME="name";
    private static final String BUNDLE_COURSE_UNIT="unit";
    private static final String BUNDLE_COURSE_LEVEL="level";
    private static final String BUNDLE_COURSE_SEMESTER="semester";
    ModelCourse course;

    public static add_data getInstance(String name,int level,int semester,int unit){
        Bundle bundle=new Bundle();
        bundle.putString(BUNDLE_COURSE_NAME, name);
        bundle.putInt(BUNDLE_COURSE_SEMESTER, semester);
        bundle.putInt(BUNDLE_COURSE_LEVEL, level);
        bundle.putInt(BUNDLE_COURSE_UNIT, unit);
        add_data fragment=new add_data();
        fragment.setArguments(bundle);
        return fragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        View view= getActivity().getLayoutInflater().inflate(R.layout.activity_add_data, null);



        courseDepartment=(Spinner) view.findViewById(R.id.add_course_department);
        courseUnit=(EditText) view.findViewById(R.id.add_course_unit);
        courseLevel=(EditText) view.findViewById(R.id.add_course_level);
        courseName=(EditText) view.findViewById(R.id.add_course_name);
        courseSemester=(EditText) view.findViewById(R.id.add_course_semester);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.departments, android.R.layout.simple_selectable_list_item);
        courseDepartment.setAdapter(spinnerAdapter);

        final StudentFaculty order=StudentFaculty.getInstance();
        final ModelData data=new ModelData(getActivity());
        Bundle myBundle=getArguments();
        if(myBundle!=null){
            builder.setTitle("Course Details");
            unit =myBundle.getInt(BUNDLE_COURSE_UNIT);
            semester=myBundle.getInt(BUNDLE_COURSE_SEMESTER);
            level=myBundle.getInt(BUNDLE_COURSE_LEVEL);
            name=myBundle.getString(BUNDLE_COURSE_NAME);
            courseDepartment.setEnabled(false);

            courseSemester.setText("" + semester);
            courseSemester.setEnabled(false);

            courseUnit.setText("" + unit);
            courseUnit.setEnabled(false);

            courseLevel.setText("" + level);
            courseLevel.setEnabled(false);

            courseName.setText(name);
            courseName.setEnabled(false);

            builder.setPositiveButton(android.R.string.ok,null);

        }
        else{
            builder.setTitle("Add Course");
            builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    level = Integer.parseInt(courseLevel.getText().toString());
                    name = courseName.getText().toString().toUpperCase();
                    semester = Integer.parseInt(courseSemester.getText().toString());
                    unit = Integer.parseInt(courseUnit.getText().toString());
                    int departmentId = order.getDepartment(department);
                    if (checkAllFields()) {
                        course = new ModelCourse(name, departmentId, -1, -1, unit, level, semester);
                        data.addEntry(course);
                        data.close();
                    }

                }
            });

            builder.setNegativeButton(android.R.string.cancel,null);
        }


        builder.setView(view);

        courseDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                department = textView.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return builder.create();
    }
    public ModelCourse getCreatedCourse(){
        return course;
    }

    public boolean checkName(){
        if(name.equals("")){
            Toast.makeText(getActivity(),"Name cannot be blank",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    public boolean checkSemester(){
        if(semester<1||semester>2){
            Toast.makeText(getActivity(),"Semester can only be 1 OR 2",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    public boolean checkLevel(){
        if(level<1||level>5){
            Toast.makeText(getActivity(),"Level can only be 1 to 5",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    public boolean checkUnit(){
        if(unit<1||unit>10){
            Toast.makeText(getActivity(),"Unit can only be 1 to 10",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    public boolean checkDepartment(){
        if(department.equals("Please Select Department")){
            Toast.makeText(getActivity(),"Department cannot be blank",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    public boolean checkAllFields(){
        return checkName() && checkUnit() && checkLevel() && checkSemester() && checkDepartment();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
