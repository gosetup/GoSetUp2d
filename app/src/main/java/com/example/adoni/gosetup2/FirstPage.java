package com.example.adoni.gosetup2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {
    Button log , reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


        log =(Button)findViewById(R.id.button2);
        reg = (Button)findViewById(R.id.button);

    }
    public void login(View view){
        Intent intent = new Intent(this,SecondPage2.class);
        startActivity(intent);

    }

    public void register(View view){
        Intent intent1 = new Intent(this,SecondPage.class);
        startActivity(intent1);

    }
}
