package com.example.adoni.gosetup2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondPage extends AppCompatActivity {
    Button student ,teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        student = (Button)findViewById(R.id.button2);
        teacher = (Button)findViewById(R.id.button);
    }

    public void stdreg(View view){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);

    }

    public void tecreg(View view){
        Intent intent1 = new Intent(this,TeacherReg.class);
        startActivity(intent1);

    }
}
