package com.example.afomic.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class result extends AppCompatActivity {
    TextView mySemester,myLevel,myGpa,myCgpa;
    String username,cgpa,gpa;
    int level,semester,department;
    double totalPoint,totalUnit, previousPoint,previousUnit;
    ModelData data;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        toolbar=(Toolbar)findViewById(R.id.result_toolbar);
        setSupportActionBar(toolbar);

        myCgpa=(TextView)findViewById(R.id.result_cgpa);
        myGpa=(TextView)findViewById(R.id.result_gpa);
        mySemester=(TextView)findViewById(R.id.result_semester);
        myLevel=(TextView)findViewById(R.id.result_level);


        //get data from previous activity
        data=new ModelData(this);

        final Bundle myData=getIntent().getExtras();
        if(myData!=null){
            username=myData.getString("username");
            level=myData.getInt("level");
            semester=myData.getInt("semester");
            department=myData.getInt("department");
            cgpa=myData.getString("cgpa");
            totalPoint=myData.getDouble("totalPoint");
            totalUnit=myData.getDouble("totalUnit");
            previousPoint=myData.getDouble("previousPoint");
            previousUnit=myData.getDouble("previousUnit");
            gpa=myData.getString("gpa");
        }
        //setting the value for each textView on the result activity

        myCgpa.setText(cgpa);
        myLevel.setText(""+level);
        mySemester.setText(""+semester);
        myGpa.setText(gpa);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.result_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.result_next){
            Intent intent=new Intent(result.this,calculate.class);
            intent.putExtra("username",username);
            intent.putExtra("department",department);
            if(semester==1){
                semester= semester+1;
                intent.putExtra("semester",semester);
                intent.putExtra("level",level);
            }
            else{
                semester= semester-1;
                level=level+1;
                intent.putExtra("semester", semester);
                intent.putExtra("level",level);
            }

            data.editAccount(username,totalPoint,totalUnit,level,semester);
            intent.putExtra("totalUnit",totalUnit);
            intent.putExtra("totalPoint",totalPoint);
            startActivity(intent);
            finish();

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        // going back to calculate activity without storing the previous data
        Intent intent=new Intent(result.this,calculate.class);
        intent.putExtra("username",username);
        intent.putExtra("department", department);
        intent.putExtra("semester", semester);
        intent.putExtra("level",level);
        intent.putExtra("totalUnit", previousUnit);
        intent.putExtra("totalPoint",previousPoint);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
