package com.muhammadrehan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context cntxt;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cntxt=this;
        tv=findViewById(R.id.main);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intnt=new Intent(cntxt,newActivity.class);
                intnt.putExtra("msg","This is grom Main");
                startActivity(intnt);
                finish();
            }
        });

    }
}
