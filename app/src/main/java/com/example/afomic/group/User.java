package com.example.afomic.group;

/**
 *
 *
 * Created by afomic on 02-May-16.
 */
public class User {
    String password, username;
    int level,semester,totalPoint,totalUnit,department;

    public User() {
    }

    public User(String pass,String user,int depart,int lvl){
        password=pass;
        level=lvl;
        semester=1;
        totalPoint=0;
        totalUnit=0;
        username=user;
        department=depart;
    }

    public User(String password, String username, int department, int level, int semester, int totalPoint, int totalUnit) {
        this.password = password;
        this.username = username;
        this.department = department;
        this.level = level;
        this.semester = semester;
        this.totalPoint = totalPoint;
        this.totalUnit = totalUnit;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public void setTotalUnit(int totalUnit) {
        this.totalUnit = totalUnit;
    }
}
