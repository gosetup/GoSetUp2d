package com.example.adoni.gosetup2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondPage2 extends AppCompatActivity {

    Button student ,teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page2);

        student = (Button)findViewById(R.id.stuLog);
        teacher = (Button)findViewById(R.id.teaLog);
    }

    public void stdlog(View view){
        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);

    }

    public void teclog(View view){
        Intent intent1 = new Intent(this,TeacherLogin.class);
        startActivity(intent1);

    }
}
