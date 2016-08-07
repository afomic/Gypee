package com.example.afomic.group;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class signUp extends AppCompatActivity {
    EditText username,password,passwordAgain;
    Spinner signDepartment;
    RadioButton hundred,twoHundred,threeHundred,fourHundred;
    Button signButton;
    int department,level;
    TextView loginButton;

    ModelData data;
    TextInputLayout passLayout,userLayout,passAgainLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        hundred=(RadioButton)findViewById(R.id.sign_level_hundred);
        twoHundred=(RadioButton) findViewById(R.id.sign_level_two_hundred);
        threeHundred=(RadioButton) findViewById(R.id.sign_level_three_hundred);
        fourHundred=(RadioButton) findViewById(R.id.sign_level_four_hundred);

        hundred.setOnCheckedChangeListener(new RbListner());
        threeHundred.setOnCheckedChangeListener(new RbListner());
        twoHundred.setOnCheckedChangeListener(new RbListner());
        fourHundred.setOnCheckedChangeListener(new RbListner());

        toolbar=(Toolbar)findViewById(R.id.sign_toolbar);
        setSupportActionBar(toolbar);
        username=(EditText)findViewById(R.id.sign_username);
        password=(EditText) findViewById(R.id.sign_password);
        passwordAgain=(EditText)findViewById(R.id.sign_password_again);
        signDepartment=(Spinner) findViewById(R.id.sign_department);
        signButton=(Button) findViewById(R.id.sign_button);
        userLayout=(TextInputLayout) findViewById(R.id.sign_username_layout);
        passLayout=(TextInputLayout) findViewById(R.id.sign_pass_layout);
        passAgainLayout=(TextInputLayout) findViewById(R.id.sign_passagain_layout);


        data=new ModelData(this);

        final StudentFaculty order=StudentFaculty.getInstance();

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.departments, android.R.layout.simple_selectable_list_item);
        signDepartment.setAdapter(spinnerAdapter);
        signDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView myView = (TextView) view;
                String dep = myView.getText().toString();
                department=order.getDepartment(dep);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        username.addTextChangedListener(new MyTextWatcher(username));
        password.addTextChangedListener(new MyTextWatcher(password));
        passwordAgain.addTextChangedListener(new MyTextWatcher(passwordAgain));
        //button reference
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();

            }
        });


    }


    private boolean validatePassword() {
        if (password.getText().toString().trim().isEmpty()) {
            passLayout.setError("Password cannot be empty");

            return false;

        }
        else if (password.getText().toString().length()<3) {
            passLayout.setError("Password too short");

            return false;

        } else {
            passLayout.setErrorEnabled(false);
        }

        return true;

    }



    private boolean validatePassword2() {
        String firstPassword= password.getText().toString();
        String secondPassword= passwordAgain.getText().toString().trim();
        if (secondPassword.isEmpty()) {
            passAgainLayout.setError("Password cannot be empty");
            return false;
        }
        else if (!firstPassword.equals(secondPassword)) {
            passAgainLayout.setError("The password does not match");
            return false;
        } else {
            passAgainLayout.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateName() {
        if (username.getText().toString().trim().isEmpty()) {
            userLayout.setError("First Name cannot be empty");

            return false;
        }
        if (username.getText().toString().length()<3) {
            userLayout.setError("Username is too short");

            return false;
        } else {
            userLayout.setErrorEnabled(false);
        }

        return true;
    }


    private void submitForm() {
        if (!validateName()) {
            return;
        }
        if(level==0){
            Toast.makeText(signUp.this, "not working", Toast.LENGTH_SHORT).show();
             return;
        }

        if (!validatePassword()) {
            return;
        }

        if(!validatePassword2()){
            return;
        }
        else {
            String user=username.getText().toString();
            String pass=password.getText().toString();
            User MyUser=new User(pass,user,department,level);
            data.addAccount(MyUser);
            Intent intent =new Intent(signUp.this,calculate.class);
            intent.putExtra("username",user);
            startActivity(intent);
            finish();
        }

    }
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.sign_password:
                    validatePassword();
                    break;
                case R.id.sign_password_again:
                    validatePassword2();
                    break;

                case R.id.sign_username:
                    validateName();
                    break;

            }
        }
    }

    public class RbListner implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.sign_level_hundred:
                    if(isChecked){
                        level=1;
                    }
                    break;
                case R.id.sign_level_two_hundred:
                    if(isChecked){
                        level=2;
                    }
                    break;
                case R.id.sign_level_three_hundred:
                    if(isChecked){
                        level=3;
                    }
                    break;
                case R.id.sign_level_four_hundred:
                    if(isChecked){
                        level=4;
                    }
                    break;

            }
        }
    }
}
