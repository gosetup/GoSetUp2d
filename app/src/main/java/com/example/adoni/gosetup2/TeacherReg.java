package com.example.adoni.gosetup2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class TeacherReg extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText name ,username,email,pass;
    Spinner special;
    DBAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);


        name = (EditText)findViewById(R.id.etName);
        username = (EditText)findViewById(R.id.etUserName);
        email =(EditText)findViewById(R.id.etmail);
        pass =(EditText)findViewById(R.id.etPass);
        special= (Spinner)findViewById(R.id.spinner1);

        helper = new DBAdapter(this);


        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Specialization,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    public void addUser(View view){

        String tname = name.getText().toString();
        String tuser = username.getText().toString();
        String tpass = pass.getText().toString();
        String tmail = email.getText().toString();
        String tspecial= special.getSelectedItem().toString();
        if (tname.isEmpty() || tuser.isEmpty() || tpass.isEmpty() || tmail.isEmpty() || tspecial.isEmpty())
        {
            Message.message(getApplicationContext(),"Fill The Empty Field..");
        }
        else
        {
            long id =helper.addData(tname,tuser,tmail,tpass,tspecial);
            if(id <=0){
                Message.message(getApplicationContext(),"Insertion UnSuccessful");
                name.setText("");
                username.setText("");
                email.setText("");
                pass.setText("");

            }
            else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                name.setText("");
                username.setText("");
                email.setText("");
                pass.setText("");
            }

        }

        Intent intent = new Intent(this,TeacherLogin.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void viewdata(View view){

        String data = helper.showdata();
        Message.message(this,data);

    }
}
