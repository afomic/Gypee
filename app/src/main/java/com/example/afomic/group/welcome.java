package com.example.afomic.group;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
    Button login;
    TextView signUp;
    Toolbar toolbar;
    EditText username,password;
    String userPassword,user;
    TextInputLayout passwordLayout;
    TextInputLayout usernameLayout;


    Button quickAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        toolbar=(Toolbar) findViewById(R.id.welcome_toolbar);
        setSupportActionBar(toolbar);

        login=(Button) findViewById(R.id.b_login);
        signUp=(TextView) findViewById(R.id.sign_up);
        username=(EditText) findViewById(R.id.et_username);
        password=(EditText) findViewById(R.id.et_password);
        usernameLayout=(TextInputLayout)findViewById(R.id.et_username_layout);
        passwordLayout=(TextInputLayout)findViewById(R.id.et_password_layout);
        setGotoSpan(signUp,signUp.class);

        String[] allDepartment = getResources().getStringArray(R.array.departments);
        StudentFaculty.getInstance().setAllDepartment(allDepartment);

        final ModelData userData= new ModelData(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString();
                userPassword = password.getText().toString();
                if (userData.checkUserExist(user)) {

                    if (userData.checkUser(user, userPassword)) {
                        Intent intent = new Intent(welcome.this, calculate.class);
                        intent.putExtra("username", user);
                        startActivity(intent);
                        finish();
                    } else {
                        passwordLayout.setError("Wrong password");
                    }
                } else {
                    usernameLayout.setError("Username doesn't exist");

                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.skip){
            Intent intent=new Intent(welcome.this, com.example.afomic.group.quickAccess.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void setGotoSpan(TextView view,Class whereTo){
        String text=view.getText().toString();
        SpannableString spannableString=new SpannableString(text);
        spannableString.setSpan(new GotoPlaces(whereTo), 0, text.length(), 0);
        view.setMovementMethod(new LinkMovementMethod());
        view.setText(spannableString);
    }
}
