package com.example.navjot.calcul;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button nine,eig,sev,six,fiv,four,thr,two,one,zero,dot,plus,mins,div,mul,eq,cl,cl12;
    @BindView(R.id.Etext)EditText et;
   // @BindViews({R.id.b0,R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.bcl,R.id.bd,R.id.bpl,R.id.bmin,R.id.bmul,R.id.bdiv,R.id.beq,R.id.cl1})List<Button>DIGITS ;
    String s = "0";
    float result = 0;
    char lO = ' ';
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        ButterKnife.bind(this);
        String value = new SharedPrefrences(this).getLastValue();
        Toast.makeText(this,"Vlaue is "+value,Toast.LENGTH_LONG).show();
        et.setText(value);
        s=value;
        et.setInputType(InputType.TYPE_NULL);
        nine=findViewById(R.id.b9);cl12=findViewById(R.id.cl1);eig=findViewById(R.id.b8); sev=findViewById(R.id.b7);
        six=findViewById(R.id.b6); fiv=findViewById(R.id.b5);four=findViewById(R.id.b4);thr=findViewById(R.id.b3);
        two=findViewById(R.id.b2);one=findViewById(R.id.b1);zero=findViewById(R.id.b0);dot=findViewById(R.id.bd);
        plus=findViewById(R.id.bpl);mins=findViewById(R.id.bmin);div=findViewById(R.id.bdiv);mul=findViewById(R.id.bmul);
        eq=findViewById(R.id.beq);cl=findViewById(R.id.bcl);
       // SetClick();
    }
    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        // String inDigit;
        switch(v.getId()) {
            case R.id.b0:
            case R.id.b1:
            case R.id.b2:
            case R.id.b3:
            case R.id.b4:
            case R.id.b5:
            case R.id.b6:
            case R.id.b7:
            case R.id.b8:
            case R.id.b9:
            case R.id.bd:
            String inDigit = ((Button) v).getText().toString();
            if (s.equals("0")) {
                if (inDigit.equals("0")) return;
                    s = inDigit;
                new SharedPrefrences(this).lastCalulatedValue(s);
                }
                else {
                    if (inDigit.equals(".")) {
                        if (s.contains(".") == true) {
                            if (inDigit.equals(".")) {
                            }
                            // s=s;
                            //if(inDigit.equals("."))return;
                        } else {
                            //  s+=inDigit;
                            s += inDigit;

                        }
                    } else {
                        //  s+=inDigit;
                        s += inDigit;

                    }
                new SharedPrefrences(this).lastCalulatedValue(s);
                }
                et.setText(s);
                new SharedPrefrences(this).lastCalulatedValue(s);
                if(lO == '=')
                {
                    result=0;
                    lO =' ';
                }
                break;
            case R.id.bpl:
                compute();
                lO = '+';
                break;
            case R.id.bmin:
                compute();
                lO = '-';
                break;
            case R.id.bdiv:
                compute();
                lO = '/';
                break;
            case R.id.bmul:
                compute();
                lO = '*';
                break;
            case R.id.beq:
                compute();
                lO = '=';
                break;
            case R.id.bcl:
                result = 0;
                s = "0";
                lO = ' ';
                et.setText("0");
                new SharedPrefrences(this).lastCalulatedValue(s);
                break;
            case R.id.cl1:
                char array[];
                String a1= et.getText().toString();
                Log.d(getLocalClassName(),a1.length()+"value from edittext"+a1);
                array=a1.toCharArray();
                if(et.getText().toString().length()==0)
                {
                    s="0";
                    et.setText(s);
                }
                else {
                    et.setText(array, 0, array.length - 1);
                    s = et.getText().toString();
                    Log.d(getLocalClassName(), "Value is " + s);
                    et.setText(s);
                }
                new SharedPrefrences(this).lastCalulatedValue(s);
                break;

            //inDigit = ((Button) v).getText().toString();
            default:
              new SharedPrefrences(this).lastCalulatedValue(s);
        }
    }

    private void compute()
    {
        // TODO Auto-generated method stub
        float inNum = Float.parseFloat(s);
        s = "0";
        if (lO == ' ')
        {
            result = inNum;
        }
        else if (lO == '+')
        {
            result += inNum;
        }
        else if (lO == '-')
        {
            result -= inNum;
        }
        else if (lO == '*')
        {
            result *= inNum;
        }
        else if (lO == '/')
        {
            result /= inNum;
        }
        else if (lO == '=')
        {
            // Keep the result for the next operation
        }
        et.setText(String.valueOf(result));
        new SharedPrefrences(this).lastCalulatedValue(result+"");
    }
      }

