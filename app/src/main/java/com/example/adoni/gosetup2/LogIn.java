package com.example.adoni.gosetup2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LogIn extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private Button sign;
    private TextView errormsgemail;
    private TextView errormsgpassword;
    DBAdapter helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email =(EditText)findViewById(R.id.etmail);
        password=(EditText)findViewById(R.id.etPass);
        login =(Button) findViewById(R.id.btnlogin);
        sign = (Button)findViewById(R.id.btnRegister);
        errormsgemail =(TextView)findViewById(R.id.error_msg_email);
        errormsgpassword =(TextView)findViewById(R.id.error_msg_password);

        helper = new DBAdapter(this);


        }

    public void onClick(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);

    }

    public void forgot(View view){
        Intent intent1 = new Intent(this,ForgotPassword.class);
        startActivity(intent1);
    }

    public void login(View view){

            if (helper.login(email.getText().toString().trim()
                    , password.getText().toString().trim())) {


                Intent accountsIntent = new Intent(this, Home2.class);
                accountsIntent.putExtra("EMAIL", email.getText().toString().trim());
                emptyInputEditText();
                startActivity(accountsIntent);


            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Invalid Email OR Password!!!",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        }

        /**
         * This method is to empty all input edit text
         */
        private void emptyInputEditText() {
            email.setText(null);
            password.setText(null);
        }




    }

