package com.example.afomic.group;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView welcomeImage;
    TextView myName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeImage = (ImageView) findViewById(R.id.welcome_image);
        myName = (TextView) findViewById(R.id.my_name);
        String[] allDepartment = getResources().getStringArray(R.array.departments);
        StudentFaculty.getInstance().setAllDepartment(allDepartment);
        final ModelData newData=new ModelData(MainActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, welcome.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
