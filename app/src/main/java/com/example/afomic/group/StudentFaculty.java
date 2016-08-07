package com.example.afomic.group;

import android.content.res.Resources;

import java.util.ArrayList;

/**
 * Created by afomic on 18-May-16.
 */
public class StudentFaculty {

    String[][] department={{"Technology","Computer Engineering","Computer Science with Economics","Computer Science with Mathematics","Mechanical Engineering","Civil Engineering","Material Science","Food Science","Food Technology","Electrical and Electronics Engineering","Chemical Engineering"}
            ,{"Science","Chemistry","Physics","Mathematics","Geology","Microbiology"},
            {"Social Science","Sociology","Psychology","Economics","Philosophy"}
            ,{"Admin","Accounting","Public Administration"}
            ,{"Art","English Major","English with Literature"}};
   static String[] allDepartment;
    String[][] subgroup={{"Computer","Computer Science with Economics","Computer Science with Mathematics"},
            {"pure","Chemistry","Physics","Mathematics",},{"biological","Microbiology"},
            {"Engineering","Mechanical Engineering","Civil Engineering","Material Science","Electrical and Electronics Engineering","Chemical Engineering","Computer Engineering"},
            {"unsorted","Sociology","Psychology","Economics","Philosophy","English Major","English with Literature","Geology","Microbiology","Accounting","Botany","Zoology"}
    };

   private static StudentFaculty instance;

    private  StudentFaculty() {
    }
    public static StudentFaculty getInstance(){

        if(instance==null){
            instance=new StudentFaculty();
        }
        return instance;
    }
    public void setAllDepartment(String[] array){
        allDepartment=array;
    }



    public int getFaculty(int departmentIndex){
        String departmentName=allDepartment[departmentIndex];
        for(int i=0;i<department.length;i++) {
            if (isContained(department[i],departmentName)) {
                return i;
            }
        }
        return -1;
    }
    public int getFaculty(String FacultyName){

        for(int i=0;i<department.length;i++) {
            if (isContained(department[i],FacultyName)) {
                return i;
            }
        }
        return -1;
    }
    public int getDepartment(String department){
        for(int i=0;i<allDepartment.length;i++){
            if(department.equals(allDepartment[i])){
                return i;
            }
        }
        return -1;
    }
    public int getSubgroup(int departmentIndex){
        String departmentName=allDepartment[departmentIndex];
        for(int i=0;i<subgroup.length;i++) {
            if (isContained(subgroup[i], departmentName)) {
                return i;
            }
        }
        return -1;
    }
    public int getSubgroup(String subgroupName){
        for(int i=0;i<subgroup.length;i++) {
            if (isContained(subgroup[i], subgroupName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isContained(String[] array,String name){
        for (String anArray : array) {
            if (anArray.equals(name)) {
                return true;
            }
        }
        return false;
    }

}
