package com.example.adoni.gosetup2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {
   private EditText email, currPass , NewPass;
    DBAdapter helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        currPass= (EditText) findViewById(R.id.etPass);
        NewPass= (EditText) findViewById(R.id.etreenter);
        email = (EditText)findViewById(R.id.etmail);

        helper = new DBAdapter(this);

    }

    public void reset(View view) {
        {
            String curr = currPass.getText().toString();
            String newpass = NewPass.getText().toString();

            if (curr.isEmpty() || newpass.isEmpty()) {
                Message.message(getApplicationContext(), "Enter Data");

            } else {
                int a = helper.updatePassword(curr,newpass);
                if (a <= 0) {
                    Message.message(getApplicationContext(), "Unsuccessful");
                    currPass.setText("");
                    NewPass.setText("");
                } else {
                    Message.message(getApplicationContext(), "Updated");
                    currPass.setText("");
                    NewPass.setText("");
                }
            }

        }
    }
}