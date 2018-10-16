package com.muhammadrehan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class newActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        tv=findViewById(R.id.newActivity);
        Intent intnt=getIntent();
        if(intnt!=null)
        {
            String msg=intnt.getStringExtra("msg");
            tv.setText(msg);
        }
    }
}
