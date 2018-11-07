package com.muhammadrehan.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Context cnt;
    EditText ed;
    String opr = "",val="",btnVal="",txt="";
    double result = 0;
    boolean flg = false;
    boolean perform=false;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt=this;
    }

    @Override
    public void onClick(View view)
    {
        ed=findViewById(R.id.reslutBar);
        //Number Click
        if(view.getId()== R.id.dot || view.getId()== R.id.zero || view.getId()== R.id.one || view.getId()== R.id.two || view.getId()== R.id.three || view.getId()== R.id.four || view.getId()== R.id.five || view.getId()== R.id.six || view.getId()== R.id.seven || view.getId()== R.id.eight || view.getId()== R.id.nine )
        {
            val=ed.getText().toString();
            if(val.equals("0") || flg==true)
                ed.getText().clear();


            flg=false;
            val=ed.getText().toString();
            int id=getClickedButtonID(view);
            btn=findViewById(id);
            btnVal=btn.getText().toString();
            if(btnVal.equals("."))
            {
                if(!val.contains("."))
                {
                    txt=val+btnVal;
                    ed.setText(txt);
                }
            }
            else
            {
                txt=val+btnVal;
                ed.setText(txt);
            }
        }
        //OperatorClick
        else if(view.getId()== R.id.plus || view.getId()== R.id.minus || view.getId()== R.id.mul || view.getId()== R.id.div )
        {
            int id=getClickedButtonID(view);
            btn=findViewById(id);
            val=ed.getText().toString();
            if(result!=0 && opr!="" && flg==false)
            {
                Toast.makeText(cnt,val,Toast.LENGTH_SHORT).show();
                calc();
                opr=btn.getText().toString();
                flg = true;
                val=ed.getText().toString();
                result = Double.parseDouble(val);
            }
            else
            {
                opr=btn.getText().toString();
                flg = true;
                result = Double.parseDouble(val);
            }
        }
        //EqualClick
        else if(view.getId()== R.id.equal)
        {
            if (!flg)
            {
                calc();
                opr = "";
                flg = true;
            }
            else
            {
                Toast.makeText(cnt,"Invalid Operation !",Toast.LENGTH_SHORT).show();
                ed.setText("0");
                result = 0;
                opr = "";
                flg = false;
            }
        }
        //C or CE click
        else if(view.getId()== R.id.C)
        {
            ed.setText("0");
            result = 0;
            opr = "";
            flg = false;
        }
        else if(view.getId()== R.id.CE)
        {
            ed.setText("0");
        }
    }

    void calc()
    {
        val=ed.getText().toString();
        if (opr.equals("+"))
        {
            result = result + Double.parseDouble(val);
            ed.setText(Double.toString(result));
        }
        else if (opr.equals("-"))
        {
            result = result - Double.parseDouble(val);
            ed.setText(Double.toString(result));
        }
        else if (opr.equals("*"))
        {
            result = result * Double.parseDouble(val);
            ed.setText(Double.toString(result));
        }
        else if (opr.equals("/"))
        {
            result = result / Double.parseDouble(val);
            ed.setText(Double.toString(result));
        }
    }

    private int getClickedButtonID(View view)
    {
        switch (view.getId())
        {
            case R.id.zero:
                return R.id.zero;
            case R.id.one:
                return R.id.one;
            case R.id.two:
                return R.id.two;
            case R.id.three:
                return R.id.three;
            case R.id.four:
                return R.id.four;
            case R.id.five:
                return R.id.five;
            case R.id.six:
                return R.id.six;
            case R.id.seven:
                return R.id.seven;
            case R.id.eight:
                return R.id.eight;
            case R.id.nine:
                return R.id.nine;
            case R.id.dot:
                return R.id.dot;
            case R.id.plus:
                return R.id.plus;
            case R.id.minus:
                return R.id.minus;
            case R.id.mul:
                return R.id.mul;
            case R.id.div:
                return R.id.div;
            case R.id.equal:
                return R.id.equal;
            case R.id.C:
                return R.id.C;
            case R.id.CE:
                return R.id.CE;
        }
        return -1;
    }
}
