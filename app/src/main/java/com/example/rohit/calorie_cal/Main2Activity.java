package com.example.rohit.calorie_cal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(TextView) findViewById(R.id.textView7);
        Intent i=getIntent();
        String bm=i.getStringExtra("BMR");
        t1.setText(bm);
    }

}
