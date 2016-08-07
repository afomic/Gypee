package com.example.afomic.group;

import java.util.ArrayList;

/**
 * Created by afomic on 03-May l6.
 *
 */
public class InputData {
 StudentFaculty sort=StudentFaculty.getInstance();
    public ArrayList<ModelCourse> getData(){
        ArrayList<ModelCourse> courses=new ArrayList<>();
        int nothing=-1;
        /*
        * Technology courses*/
        //final year project
        courses.add(new ModelCourse("FYP001",nothing,sort.getFaculty("Technology"),nothing,3,5,1));
        courses.add(new ModelCourse("FYP002",nothing,sort.getFaculty("Technology"),nothing,3,5,2));
        //chemistry courses
        courses.add(new ModelCourse("CHM101",nothing,sort.getFaculty("Technology"),nothing,4,1,1));
        courses.add(new ModelCourse("CHM102",nothing,sort.getFaculty("Technology"),nothing,4,1,2));
        courses.add(new ModelCourse("CHM106",nothing,sort.getFaculty("Technology"),nothing,1,1,1));
        courses.add(new ModelCourse("CHM107",nothing,sort.getFaculty("Technology"),nothing,1,1,2));
        //tpd courses
        courses.add(new ModelCourse("TPD101",nothing,sort.getFaculty("Technology"),nothing,1,1,1));
        courses.add(new ModelCourse("TPD501",nothing,sort.getFaculty("Technology"),nothing,2,4,1));
        courses.add(new ModelCourse("TPD503",nothing,sort.getFaculty("Technology"),nothing,2,5,1));
        courses.add(new ModelCourse("TPD502",nothing,sort.getFaculty("Technology"),nothing,2,5,2));
        //mathematics
        courses.add(new ModelCourse("MTH101",nothing,sort.getFaculty("Technology"),nothing,5,1,1));
        courses.add(new ModelCourse("MTH102",nothing,sort.getFaculty("Technology"),nothing,5,1,2));
        courses.add(new ModelCourse("MTH104",sort.getDepartment("Mathematics"),sort.getFaculty("Technology"),nothing,2,1,2));
        courses.add(new ModelCourse("MTH201",nothing,sort.getFaculty("Technology"),nothing,4,2,1));
        courses.add(new ModelCourse("MTH202",nothing,sort.getFaculty("Technology"),nothing,4,2,2));
        //physics
        courses.add(new ModelCourse("PHY101",nothing,sort.getFaculty("Technology"),nothing,4,1,1));
        courses.add(new ModelCourse("PHY102",nothing,sort.getFaculty("Technology"),nothing,4,1,2));
        courses.add(new ModelCourse("PHY107",nothing,sort.getFaculty("Technology"),nothing,1,1,1));
        courses.add(new ModelCourse("PHY108",nothing,sort.getFaculty("Technology"),nothing,1,1,2));
        //Swies
        courses.add(new ModelCourse("CVE401",nothing,sort.getFaculty("Technology"),nothing,3,4,1));
        courses.add(new ModelCourse("SWS200",nothing,sort.getFaculty("Technology"),nothing,3,4,2));
        courses.add(new ModelCourse("SWS300",nothing,sort.getFaculty("Technology"),nothing,3,4,2));
        courses.add(new ModelCourse("SWS400",nothing,sort.getFaculty("Technology"),nothing,6,4,2));
        courses.add(new ModelCourse("MEE203",nothing,sort.getFaculty("Technology"),nothing,2,2,1));
        courses.add(new ModelCourse("MEE204",nothing,sort.getFaculty("Technology"),nothing,2,2,2));
        //computer course
        courses.add(new ModelCourse("CSC201",nothing,sort.getFaculty("Technology"),nothing,3,2,1));
        courses.add(new ModelCourse("CSC202",nothing,sort.getFaculty("Technology"),nothing,2,2,2));
        
        //Engineering course
        courses.add(new ModelCourse("CHE201",nothing,nothing,sort.getSubgroup("Engineering"),3,2,1));
        courses.add(new ModelCourse("MSE201",nothing,nothing,sort.getSubgroup("Engineering"),3,2,1));
        courses.add(new ModelCourse("MEE205",nothing,nothing,sort.getSubgroup("Engineering"),3,2,1));
        courses.add(new ModelCourse("EEE201",nothing,nothing,sort.getSubgroup("Engineering"),2,2,1));
        courses.add(new ModelCourse("EEE291",nothing,nothing,sort.getSubgroup("Engineering"),1,2,1));
        courses.add(new ModelCourse("AGE202",nothing,nothing,sort.getSubgroup("Engineering"),2,2,2));
        courses.add(new ModelCourse("CVE202",nothing,nothing,sort.getSubgroup("Engineering"),3,2,2));
        courses.add(new ModelCourse("MEE206",nothing,nothing,sort.getSubgroup("Engineering"),3,2,2));
        courses.add(new ModelCourse("EEE202",nothing,nothing,sort.getSubgroup("Engineering"),2,2,2));
        courses.add(new ModelCourse("EEE292",nothing,nothing,sort.getSubgroup("Engineering"),1,2,2));
        courses.add(new ModelCourse("CHE305",nothing,nothing,sort.getSubgroup("Engineering"),3,3,1));
        courses.add(new ModelCourse("CHE306",nothing,nothing,sort.getSubgroup("Engineering"),3,3,2));
        courses.add(new ModelCourse("AGE302",nothing,nothing,sort.getSubgroup("Engineering"),2,3,2));
        
        /*
        Science courses
         */
        //final year project
        courses.add(new ModelCourse("FYP001",nothing,sort.getFaculty("Science"),nothing,3,5,1));
        courses.add(new ModelCourse("FYP002",nothing,sort.getFaculty("Science"),nothing,3,5,2));
        
        courses.add(new ModelCourse("MTH101",nothing,sort.getFaculty("Science"),nothing,5,1,1));
        courses.add(new ModelCourse("MTH102",nothing,sort.getFaculty("Science"),nothing,5,1,2));
        courses.add(new ModelCourse("MTH201",nothing,sort.getFaculty("Science"),nothing,4,2,1));
        courses.add(new ModelCourse("MTH202",nothing,sort.getFaculty("Science"),nothing,4,2,2));
        //physics
        courses.add(new ModelCourse("PHY101",nothing,sort.getFaculty("Science"),nothing,4,1,1));
        courses.add(new ModelCourse("PHY102",nothing,sort.getFaculty("Science"),nothing,4,1,2));
        courses.add(new ModelCourse("PHY107",nothing,sort.getFaculty("Science"),nothing,1,1,1));
        courses.add(new ModelCourse("PHY108",nothing,sort.getFaculty("Science"),nothing,1,1,2));

        //chemistry courses
        courses.add(new ModelCourse("CHM101",nothing,sort.getFaculty("Science"),nothing,4,1,1));
        courses.add(new ModelCourse("CHM102",nothing,sort.getFaculty("Science"),nothing,4,1,2));
        courses.add(new ModelCourse("CHM106",nothing,sort.getFaculty("Science"),nothing,1,1,1));
        courses.add(new ModelCourse("CHM107",nothing,sort.getFaculty("Science"),nothing,1,1,2));
        /*
        Computer sciences and engineering courses
         */
        courses.add(new ModelCourse("CSC101",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,1,1));
        courses.add(new ModelCourse("CSC102",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,1,2));
        courses.add(new ModelCourse("CPE203",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,2,1));
        courses.add(new ModelCourse("CPE204",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,2,2));
        courses.add(new ModelCourse("CPE301",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,3,1));
        courses.add(new ModelCourse("CSC307",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,3,1));
        courses.add(new ModelCourse("CSC302",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,3,2));
        courses.add(new ModelCourse("CSC306",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,3,2));
        courses.add(new ModelCourse("CSC308",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,3,2));
        courses.add(new ModelCourse("CPE310",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,3,2));
        courses.add(new ModelCourse("CPE316",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,3,2));
        courses.add(new ModelCourse("CPE401",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,4,1));
        courses.add(new ModelCourse("CPE405",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,4,1));
        courses.add(new ModelCourse("CSC403",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,4,1));
        courses.add(new ModelCourse("CSC415",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,4,1));
        courses.add(new ModelCourse("CSC505",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,5,1));
        courses.add(new ModelCourse("CPE517",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,5,1));
        courses.add(new ModelCourse("CPE502",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,5,2));
        courses.add(new ModelCourse("CPE506",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),2,5,2));
        courses.add(new ModelCourse("CPE508",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,5,2));
        courses.add(new ModelCourse("CPE510",sort.getDepartment("Computer Engineering"),nothing,sort.getSubgroup("Computer"),3,5,2));
        //computer sciences
        courses.add(new ModelCourse("CPE206",nothing,nothing,sort.getSubgroup("Computer"),2,2,2));
        courses.add(new ModelCourse("CSC305",nothing,nothing,sort.getSubgroup("Computer"),3,3,1));
        courses.add(new ModelCourse("CSC311",nothing,nothing,sort.getSubgroup("Computer"),2,3,1));
        courses.add(new ModelCourse("CSC315",nothing,nothing,sort.getSubgroup("Computer"),3,3,1));
        courses.add(new ModelCourse("CSC317",nothing,nothing,sort.getSubgroup("Computer"),2,3,1));
        courses.add(new ModelCourse("CSC304",nothing,nothing,sort.getSubgroup("Computer"),2,3,2));
        courses.add(new ModelCourse("CSC312",nothing,nothing,sort.getSubgroup("Computer"),2,3,2));
        courses.add(new ModelCourse("CSC403",nothing,nothing,sort.getSubgroup("Computer"),3,4,1));
        courses.add(new ModelCourse("CSC407",nothing,nothing,sort.getSubgroup("Computer"),2,4,1));
        courses.add(new ModelCourse("CSC501",nothing,nothing,sort.getSubgroup("Computer"),2,5,1));
        courses.add(new ModelCourse("CSC515",nothing,nothing,sort.getSubgroup("Computer"),2,5,1));
        courses.add(new ModelCourse("CSC523",nothing,nothing,sort.getSubgroup("Computer"),2,5,2));


        
        //with economics
        courses.add(new ModelCourse("ECN203",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,2,1));
        courses.add(new ModelCourse("ECN201",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,2,1));
        courses.add(new ModelCourse("ECN204",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,2,2));
        courses.add(new ModelCourse("ECN202",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,2,2));
        courses.add(new ModelCourse("ECN301",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("ECN313",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("ECN302",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,3,2));
        courses.add(new ModelCourse("ECN314",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,3,2));
        courses.add(new ModelCourse("ECN401",sort.getDepartment("Computer Science with Economics"),nothing,nothing,3,4,1));

        //with mathematics
        courses.add(new ModelCourse("MTH205",sort.getDepartment("Computer Science with Mathematics"),nothing,nothing,3,2,1));
        courses.add(new ModelCourse("STT201",sort.getDepartment("Computer Science with Mathematics"),nothing,nothing,3,2,1));
        courses.add(new ModelCourse("MTH306",sort.getDepartment("Computer Science with Mathematics"),nothing,nothing,3,2,2));
        courses.add(new ModelCourse("STT202",sort.getDepartment("Computer Science with Mathematics"),nothing,nothing,4,2,2));
        courses.add(new ModelCourse("MTH301",sort.getDepartment("Computer Science with Mathematics"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("MTH302",sort.getDepartment("Computer Science with Mathematics"),nothing,nothing,3,3,2));
        //engineering
        courses.add(new ModelCourse("CPE303",sort.getDepartment("Computer Engineering"),nothing,nothing,2,3,1));
        courses.add(new ModelCourse("EEE301",sort.getDepartment("Computer Engineering"),nothing,nothing,2,3,1));
        courses.add(new ModelCourse("EEE305",sort.getDepartment("Computer Engineering"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("MEE303",sort.getDepartment("Computer Engineering"),nothing,nothing,3,3,1));//UNCERTAIN
        courses.add(new ModelCourse("MSE201",sort.getDepartment("Computer Engineering"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("CPE314",sort.getDepartment("Computer Engineering"),nothing,nothing,1,3,2));
        courses.add(new ModelCourse("EEE302",sort.getDepartment("Computer Engineering"),nothing,nothing,3,3,2));
        courses.add(new ModelCourse("CSC315",sort.getDepartment("Computer Engineering"),nothing,nothing,3,4,1));
        courses.add(new ModelCourse("CPE409",sort.getDepartment("Computer Engineering"),nothing,nothing,2,4,1));
        courses.add(new ModelCourse("CPE509",sort.getDepartment("Computer Engineering"),nothing,nothing,2,5,1));
        courses.add(new ModelCourse("CPE511",sort.getDepartment("Computer Engineering"),nothing,nothing,3,5,1));
        courses.add(new ModelCourse("CPE521",sort.getDepartment("Computer Engineering"),nothing,nothing,2,5,1));



        /*
        mechanical engineering
         */
        courses.add(new ModelCourse("EEE305",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("MSE303",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("MEE301",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,3,1));
        courses.add(new ModelCourse("MEE303",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,3,1));
        courses.add(new ModelCourse("MEE305",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,3,1));
        courses.add(new ModelCourse("MEE395",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,3,1));
        courses.add(new ModelCourse("MEE307",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,3,1));
        courses.add(new ModelCourse("MEE309",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,3,1));
        courses.add(new ModelCourse("MEE302",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,3,2));
        courses.add(new ModelCourse("MEE304",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,3,2));
        courses.add(new ModelCourse("MEE394",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,3,2));
        courses.add(new ModelCourse("MEE306",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,3,2));
        courses.add(new ModelCourse("MEE396",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,3,2));
        courses.add(new ModelCourse("MEE308",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,3,2));
        courses.add(new ModelCourse("MEE312",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,3,2));
        courses.add(new ModelCourse("MEE401",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,4,1));
        courses.add(new ModelCourse("MEE403",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,4,1));
        courses.add(new ModelCourse("MEE405",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,4,1));
        courses.add(new ModelCourse("MEE407",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,4,1));
        courses.add(new ModelCourse("MEE409",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,4,1));
        courses.add(new ModelCourse("MEE493",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,4,1));
        courses.add(new ModelCourse("MEE499",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,4,1));
        courses.add(new ModelCourse("MEE411",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,4,1));
        courses.add(new ModelCourse("MEE501",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,5,1));
        courses.add(new ModelCourse("MEE503",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,5,1));
        courses.add(new ModelCourse("MEE505",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,5,1));
        courses.add(new ModelCourse("MEE507",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,5,1));
        courses.add(new ModelCourse("MEE515",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,5,1));
        courses.add(new ModelCourse("MEE591",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,5,1));
        courses.add(new ModelCourse("MEE593",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,5,1));
        courses.add(new ModelCourse("MEE595",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,5,1));
        courses.add(new ModelCourse("MEE502",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,5,2));
        courses.add(new ModelCourse("MEE504",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,5,2));
        courses.add(new ModelCourse("MEE506",sort.getDepartment("Mechanical Engineering"),nothing,nothing,2,5,2));
        courses.add(new ModelCourse("MEE508",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,5,2));
        courses.add(new ModelCourse("MEE530",sort.getDepartment("Mechanical Engineering"),nothing,nothing,3,5,2));
        courses.add(new ModelCourse("MEE592",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,5,2));
        courses.add(new ModelCourse("MEE596",sort.getDepartment("Mechanical Engineering"),nothing,nothing,1,5,2));
        return courses;
    }
}
