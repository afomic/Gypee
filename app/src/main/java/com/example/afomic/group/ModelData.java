package com.example.afomic.group;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *

 * Created by afomic on 02-May-16.
 */
public class ModelData  extends SQLiteOpenHelper{
    private static  final int db_version=1;
    private static final String TAG="database";
    private static final String db_name="student.db";
    private static final String COLUMN_NAME="course_name";
    private static final String COLUMN_LEVEL="course_level";
    private static final String COLUMN_SEMESTER="course_semester";
    private static final String COLUMN_FACULTY="course_faculty";
    private static final String COLUMN_SUBGROUP="course_subgroup";
    private static final String COLUMN_UNIT="course_unit";
    private static final String COLUMN_DEPARTMENT="course_department";
    private static final String COURSE_TABLE="course";
    private static final String ACCOUNT_TABLE="account";
    public ModelData(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.w(TAG, "onCreate:is called " );
       String sql="CREATE TABLE "+COURSE_TABLE+"( ";
        sql+="_id INTEGER PRIMARY KEY AUTOINCREMENT,";
        sql+=COLUMN_NAME+" VARCHAR(6), ";
        sql+=COLUMN_DEPARTMENT+" INTEGER(2), ";
        sql+=COLUMN_LEVEL+" INTEGER(1), ";
        sql+=COLUMN_SEMESTER+" INTEGER(1), ";
        sql+=COLUMN_UNIT+" INTEGER(1), ";
        sql+=COLUMN_FACULTY+" INTEGER(2), ";
        sql+=COLUMN_SUBGROUP+" INTEGER(2)";
        sql+=")";
        db.execSQL(sql);

        //create the second table

        String sql1="CREATE TABLE "+ACCOUNT_TABLE;
        sql1+="(_id INTEGER PRIMARY KEY AUTOINCREMENT,";
        sql1+="student_username VARCHAR(20),";
        sql1+="student_password VARCHAR(20),";
        sql1+="student_level INTEGER(1),";
        sql1+="student_semester INTEGER(1),";
        sql1+="student_total_unit INTEGER(3),";
        sql1+="student_total_point INTEGER(3),";
        sql1+="student_department INTEGER(2))";
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String dropTable="DROP TABLE"+COURSE_TABLE;
            db.execSQL(dropTable);
    }
    public void addAccount(User user){
        if(user==null){
            return ;
        }
        SQLiteDatabase db=null;
        try{
            db=getWritableDatabase();
            ContentValues myValues=new ContentValues();
            myValues.put("student_username",user.username);
            myValues.put("student_password",user.password);
            myValues.put("student_department",user.department);
            myValues.put("student_total_point", user.totalPoint);
            myValues.put("student_total_unit",user.totalUnit);
            myValues.put("student_level",user.level);
            myValues.put("student_semester",user.semester);
            db.insert(ACCOUNT_TABLE, null, myValues);

        }
        catch (Exception e){
            Log.e("database","account was not added");
            e.printStackTrace();
        }
        finally {
            if(db!=null){
                db.close();
            }
        }

    }


    public void editAccount(String username,double totalPoint,double totalUnit,int level,int semester){
        ContentValues values=new ContentValues();
        values.put("student_total_point",totalPoint);
        values.put("student_total_unit",totalUnit);
        values.put("student_level",level);
        values.put("student_semester",semester);
        SQLiteDatabase db=getWritableDatabase();
        String[] whereAgs={username};
        db.update(ACCOUNT_TABLE,values,"student_username=?",whereAgs);
    }


    public User getUser(String student_username){
        SQLiteDatabase db;
        User myUser=new User();
        try{
            db= getReadableDatabase();
            String[] whereAgs={student_username};
            String limit="1";
            Cursor cursor= db.query(ACCOUNT_TABLE,null,"student_username=?",whereAgs,null,null,null,limit);
            if(cursor.getCount()<1){
                return null;
            }
                cursor.moveToFirst();
                myUser.totalPoint=cursor.getInt(cursor.getColumnIndex("student_total_point"));
                myUser.totalUnit=cursor.getInt(cursor.getColumnIndex("student_total_unit"));
                myUser.username=cursor.getString(cursor.getColumnIndex("student_username"));
                myUser.password=cursor.getString(cursor.getColumnIndex("student_password"));
                myUser.department=cursor.getInt(cursor.getColumnIndex("student_department"));
                myUser.semester=cursor.getInt(cursor.getColumnIndex("student_semester"));
                myUser.level=cursor.getInt(cursor.getColumnIndex("student_level"));


        }catch (Exception e){

            e.printStackTrace();
        }
        return myUser;

    }
    
    public boolean checkUser(String username,String pass){
        User user=getUser(username);
        String password=user.password;
        return password.equals(pass);
    }



    public void addEntry(ModelCourse entry) {
        SQLiteDatabase db = null;
        try {
            db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, entry.name);
            values.put(COLUMN_UNIT, entry.unit);
            values.put(COLUMN_LEVEL, entry.level);
            values.put(COLUMN_SEMESTER, entry.semester);
            values.put(COLUMN_DEPARTMENT, entry.department);
            values.put(COLUMN_FACULTY, entry.faculty);
            values.put(COLUMN_SUBGROUP, entry.subgroup);
            db.insert(COURSE_TABLE, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) db.close();
        }
    }

    public void addEntries(ArrayList<ModelCourse> courses){
        for(ModelCourse entry:courses){
            addEntry(entry);
        }
    }

    public ArrayList<ModelCourse> getEntries(int semester, int faculty, int subgroup,int department, int level) {
        SQLiteDatabase db = null;
        Cursor cu;
        try {
            db = getReadableDatabase();
            String[] projection={"course_name","course_unit"};
            String[] whereArgs = new String[]{""+faculty,""+subgroup,""+department,""+level,""+semester};
            cu = db.query(COURSE_TABLE, projection ,"(course_faculty=? OR course_subgroup=? OR course_department=?) AND course_level=? AND course_semester=?",
                    whereArgs, null, null, null);
            ArrayList<ModelCourse> entries = new ArrayList<>();
            while (cu.moveToNext()) {
                ModelCourse entry = new ModelCourse();
                entry.name = cu.getString(cu.getColumnIndex(COLUMN_NAME));
                entry.unit = cu.getInt(cu.getColumnIndex(COLUMN_UNIT));
                entries.add(entry);
            }
            cu.close();
            return entries;
        } catch (Exception e) {
            return null;
        } finally {
            if (db != null) db.close();
        }
    }
    public boolean isEmpty() {
        SQLiteDatabase db = null;
        try {
            db = getReadableDatabase();
            String[] projection={"course_name","course_unit"};
            Cursor cursor= db.query(COURSE_TABLE, projection, null, null, null, null, null);
            return cursor.moveToNext();
        } catch (Exception e) {
            return true;
        } finally {
            if (db != null) db.close();
        }
    }
    public boolean checkUserExist(String username){
       User user=null;
        try{
            user=getUser(username);

        }catch (Exception e){
            e.printStackTrace();
        }
        return user != null;

    }
    public ArrayList<ModelCourse> search(String query){
        SQLiteDatabase db=null;
        String[] projection={COLUMN_LEVEL,COLUMN_SEMESTER,COLUMN_NAME,COLUMN_UNIT};
        String[] selection={"%"+query+"%"};
        Cursor cursor =null;
        ArrayList<ModelCourse> searchResult=new ArrayList<>();
        try{
            db=getReadableDatabase();
            cursor =db.query(COURSE_TABLE,projection,COLUMN_NAME+" LIKE ?",selection,null,null,null);
            while (cursor.moveToNext()){
                int unit=cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_UNIT));
                int level=cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_LEVEL));
                int semester=cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_SEMESTER));
                String name=cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
                ModelCourse tempCourse=new ModelCourse(name,unit,level,semester);
                searchResult.add(tempCourse);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        return searchResult ;

    }


}
