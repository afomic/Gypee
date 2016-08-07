package com.example.afomic.group;

/**
 * Created by afomic on 27-Apr-16.
 */
public class ModelCourse {
    public String name;
    private int resourceID;
    private int grade;
    int unit,semester,level,faculty,department,subgroup;

    public ModelCourse(int unit,String name) {
        this.name=name;
        this.unit = unit;
    }

    public ModelCourse(String name,int department, int faculty,int subgroup, int unit, int level, int semester) {
        this.name = name;
        this.department = department;
        this.faculty = faculty;
        this.unit = unit;
        this.level = level;
        this.semester = semester;
        this.subgroup=subgroup;
    }

    public ModelCourse() {
    }
    public ModelCourse(String name,int unit,int level,int semester){
        this.name = name;
        this.unit = unit;
        this.level = level;
        this.semester = semester;

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }
}
