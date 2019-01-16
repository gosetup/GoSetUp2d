package com.example.adoni.gosetup2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name ,username,email,pass;
    Spinner stream,subj1,subj2,subj3;
    DBAdapter helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.etName);
        username = (EditText)findViewById(R.id.etUserName);
        email =(EditText)findViewById(R.id.etmail);
        pass =(EditText)findViewById(R.id.etPass);
        stream = (Spinner)findViewById(R.id.spinner1);
        subj1 = (Spinner)findViewById(R.id.spinner2);
        subj2 =(Spinner)findViewById(R.id.spinner3);
        subj3 = (Spinner)findViewById(R.id.spinner4);

        helper = new DBAdapter(this);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Stream,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner1 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.Subject1,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Subject2,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.Subject3,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);



    }

    public void addUser(View view){

        String tname = name.getText().toString();
        String tuser = username.getText().toString();
        String tpass = pass.getText().toString();
        String tmail = email.getText().toString();
        String tstream= stream.getSelectedItem().toString();
        String tsubj1= subj1.getSelectedItem().toString();
        String tsubj2= subj2.getSelectedItem().toString();
        String tsubj3 = subj3.getSelectedItem().toString();
        if (tname.isEmpty() || tuser.isEmpty() || tpass.isEmpty() || tmail.isEmpty() || tstream.isEmpty() || tsubj1.isEmpty() || tsubj2.isEmpty() || tsubj3.isEmpty())
        {
            Message.message(getApplicationContext(),"Fill The Empty Field..");
        }
        else
        {
            long id =helper.insertData(tname,tuser,tmail,tpass,tstream,tsubj1,tsubj2,tsubj3 );
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

        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void show (View view){

        String data = helper.getData();
        Message.message(this,data);

    }
}
