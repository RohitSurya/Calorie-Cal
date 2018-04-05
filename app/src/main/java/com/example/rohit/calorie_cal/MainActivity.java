package com.example.rohit.calorie_cal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
EditText e1,e2,e3;
TextView t1,t2,t3,t4,t5;
Button b;
RadioButton r1,r2;
Spinner sp;
Intent i;

    String s,s1,s2;
    float bmr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e1.setInputType(InputType.TYPE_CLASS_NUMBER);
        e2.setInputType(InputType.TYPE_CLASS_NUMBER);
        e3.setInputType(InputType.TYPE_CLASS_NUMBER);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        b=(Button)findViewById(R.id.button);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r1.setOnCheckedChangeListener(this);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r2.setOnCheckedChangeListener(this);
        sp=(Spinner)findViewById(R.id.spinner);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s=e1.getText().toString();
                s1=e2.getText().toString();
                s2=e3.getText().toString();
                if(TextUtils.isEmpty(s))
                {
                    e1.setError("Enter your height");
                    e1.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(s1)){
                    e2.setError("Enter your weight");
                    e2.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(s2))
                {
                    e3.setError("Enter your age");
                    e3.requestFocus();
                    return;
                }
                if(!r1.isChecked()&&!r2.isChecked())
                {
                    t4.requestFocus();
                    return;
                }

                final float H=Float.parseFloat(s);
                final float W=Float.parseFloat(s1);
                final float A=Float.parseFloat(s2);

                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> w, View view, int i, long l) {
                        switch (i){
                            case 0:
                                if (r1.isChecked()) {
                                    bmr=cal(H,W,A);
                                    }
                                if(r2.isChecked()) {
                                    bmr=cal1(H,W,A);
                                }
                                break;
                            case 1:if(r1.isChecked()){
                                bmr=cal2(H,W,A);
                                }
                                if(r2.isChecked()) {
                                    bmr=cal3(H,W,A);
                                }
                                break;
                            case 2:if(r1.isChecked()){
                                bmr=cal4(H,W,A);
                                }
                                if(r2.isChecked()) {
                                    bmr=cal5(H,W,A);
                                }
                                break;
                            case 3:if(r1.isChecked()){
                                bmr=cal6(H,W,A);
                                }
                                if(r2.isChecked()) {
                                    bmr=cal7(H,W,A);
                                }
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                String bmr1=Float.toString(bmr);
                i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("BMR",bmr1);
                startActivity(i);
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Spin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

    }
    @Override
    public void onCheckedChanged(CompoundButton bv, boolean isChecked) {
        if (isChecked) {
            if (bv.getId() == R.id.radioButton) {
                r2.setChecked(false);
                r1.setChecked(true);
            }
            if (bv.getId() == R.id.radioButton2) {
                r1.setChecked(false);
                r2.setChecked(true);
            }
        }
    }
    public float cal(float H,float W,float A)
    {
        return(float)((10*W)+(6.25*H)-(5*A)+5);
    }
    public float cal1 (float H,float W,float A)
    {
        return(float)((10*W)+(6.25*H)-(5*A)-161);
    }
    public float cal2(float H,float W,float A)
    {
        return(float)(((10*W)+(6.25*H)-(5*A)+5)*1.2);
    }
    public float cal3 (float H,float W,float A)
    {
        return(float)(((10*W)+(6.25*H)-(5*A)-161)*1.2);
    }
    public float cal4(float H,float W,float A)
    {
        return(float)(((10*W)+(6.25*H)-(5*A)+5)*1.3);
    }
    public float cal5 (float H,float W,float A)
    {
        return(float)(((10*W)+(6.25*H)-(5*A)-161)*1.3);
    }
    public float cal6(float H,float W,float A)
    {
        return(float)(((10*W)+(6.25*H)-(5*A)+5)*1.4);
    }
    public float cal7 (float H,float W,float A)
    {
        return(float)(((10*W)+(6.25*H)-(5*A)-161)*1.4);
    }
}