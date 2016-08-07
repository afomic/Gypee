package com.example.afomic.group;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by afomic on 08-Jul-16.
 */
public class GridAdapter extends BaseAdapter {
    ArrayList<ModelCourse> userCourse;
    public static final String TAG="GridAdapter";

    public GridAdapter(ArrayList<ModelCourse> arrayList){
        userCourse=arrayList;

    }
    @Override
    public int getCount() {
        return userCourse.size();
    }

    @Override
    public ModelCourse getItem(int position) {
        return userCourse.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelCourse myCourse=userCourse.get(position);
        convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card,parent,false);
        TextView name=(TextView)convertView.findViewById(R.id.t_name);
        RadioButton customA=(RadioButton) convertView.findViewById(R.id.rb_custom_A);
        RadioButton customB=(RadioButton) convertView.findViewById(R.id.rb_custom_B);
        RadioButton customC=(RadioButton) convertView.findViewById(R.id.rb_custom_C);
        RadioButton customD=(RadioButton) convertView.findViewById(R.id.rb_custom_D);
        RadioButton customE=(RadioButton) convertView.findViewById(R.id.rb_custom_E);
        RadioButton customF=(RadioButton) convertView.findViewById(R.id.rb_custom_F);
        name.setText(myCourse.name);

        customA.setOnCheckedChangeListener(new MyOnclick(myCourse));
        customB.setOnCheckedChangeListener(new MyOnclick(myCourse));
        customC.setOnCheckedChangeListener(new MyOnclick(myCourse));
        customD.setOnCheckedChangeListener(new MyOnclick(myCourse));
        customE.setOnCheckedChangeListener(new MyOnclick(myCourse));
        customF.setOnCheckedChangeListener(new MyOnclick(myCourse));
        if (myCourse.getResourceID() != 0) {
            RadioButton button=(RadioButton)convertView.findViewById(myCourse.getResourceID());
            button.setChecked(true);
        }
        return convertView;
    }


    public class MyOnclick implements CompoundButton.OnCheckedChangeListener{
        ModelCourse modelCourse;

        public MyOnclick(ModelCourse course){
            modelCourse=course;
        }
        @Override

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.rb_custom_A:

                       if(isChecked){
                           Log.e(TAG,"checkBox listener A is checked");
                           modelCourse.setGrade(5);
                           modelCourse.setResourceID(buttonView.getId());
                       }


                    break;
                case R.id.rb_custom_B:
                      if(isChecked){
                          Log.e(TAG,"checkBox listener b is checked");
                          modelCourse.setGrade(4);
                          modelCourse.setResourceID(buttonView.getId());
                      }

                    break;
                case R.id.rb_custom_C:
                    if(isChecked){
                        Log.e(TAG,"checkBox listener c is checked");
                        modelCourse.setGrade(3);
                        modelCourse.setResourceID(buttonView.getId());
                    }
                    break;
                case R.id.rb_custom_D:
                        if(isChecked){
                            Log.e(TAG,"checkBox listener d is checked");
                            modelCourse.setGrade(2);
                            modelCourse.setResourceID(buttonView.getId());
                        }


                    break;
                case R.id.rb_custom_E:
                        if(isChecked){
                            Log.e(TAG,"checkBox listener E is checked");
                            modelCourse.setGrade(1);
                            modelCourse.setResourceID(buttonView.getId());
                        }


                    break;
                case R.id.rb_custom_F:
                    if(isChecked){
                        modelCourse.setGrade(0);
                        modelCourse.setResourceID(buttonView.getId());
                    }
                    break;



            }
        }
    }

}
