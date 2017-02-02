package com.example.yugank94.calculator;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.app.ProgressDialog.show;
import static android.widget.Toast.makeText;

public class CalciActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    Button bone, btwo, bthree, bfour, bfive, bsix, bseven, beight, bnine, badd, bsub, bmul, bdiv, bper, bdec;
    Button bsqrt, bsqr, beql1, beql2, bzero;
    StringBuffer num = new StringBuffer("");
    TextView display,display1,display2;
    Double op1,op2;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calci);

        display = (TextView) findViewById(R.id.screen1);
        display1 = (TextView) findViewById(R.id.screen2);
        display2 = (TextView) findViewById(R.id.screen3);
        bone = (Button) findViewById(R.id.one);
        bone.setOnClickListener(this);

        btwo = (Button) findViewById(R.id.two);
        btwo.setOnClickListener(this);

        bthree = (Button) findViewById(R.id.three);
        bthree.setOnClickListener(this);

        bfour = (Button) findViewById(R.id.four);
        bfour.setOnClickListener(this);

        bfive = (Button) findViewById(R.id.five);
        bfive.setOnClickListener(this);

        bsix = (Button) findViewById(R.id.six);
        bsix.setOnClickListener(this);

        bseven = (Button) findViewById(R.id.seven);
        bseven.setOnClickListener(this);

        beight = (Button) findViewById(R.id.eight);
        beight.setOnClickListener(this);

        bnine = (Button) findViewById(R.id.nine);
        bnine.setOnClickListener(this);

        badd = (Button) findViewById(R.id.add);
        badd.setOnClickListener(this);

        bsub = (Button) findViewById(R.id.subtract);
        bsub.setOnClickListener(this);

        bmul = (Button) findViewById(R.id.multiply);
        bmul.setOnClickListener(this);

        bdiv = (Button) findViewById(R.id.divide);
        bdiv.setOnClickListener(this);

        bper = (Button) findViewById(R.id.percentage);
        bper.setOnClickListener(this);

        bdec = (Button) findViewById(R.id.decimal);
        bdec.setOnClickListener(this);

        bzero = (Button) findViewById(R.id.zero);
        bzero.setOnClickListener(this);

        beql1 = (Button) findViewById(R.id.equal1);
        beql1.setOnClickListener(this);

        beql2 = (Button) findViewById(R.id.equal2);
        beql2.setOnClickListener(this);


        bsqr = (Button) findViewById(R.id.sqr);
        bsqr.setOnClickListener(this);

        bsqrt = (Button) findViewById(R.id.sqrt);
        bsqrt.setOnClickListener(this);

    }

    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case (R.id.one): {
                num.append("1");
                display.setText(num);
                break;
            }

            case (R.id.two): {
                num.append("2");
                display.setText(num);
                break;
            }

            case (R.id.three): {
                num.append("3");
                display.setText(num);
                break;
            }

            case (R.id.four): {
                num.append("4");
                display.setText(num);
                break;
            }

            case (R.id.five): {
                num.append("5");
                display.setText(num);
                break;
            }

            case (R.id.six): {
                num.append("6");
                display.setText(num);
                break;
            }

            case (R.id.seven): {
                num.append("7");
                display.setText(num);
                break;
            }

            case (R.id.eight): {
                num.append("8");
                display.setText(num);
                break;
            }
            case (R.id.nine): {
                num.append("9");
                display.setText(num);
                break;
            }

            case (R.id.zero): {
                num.append("0");
                display.setText(num);
                break;
            }

            case (R.id.decimal): {
                num.append(".");
                display.setText(num);
                break;
            }

            case (R.id.equal2 ): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op2 = Double.parseDouble(s);
                    num.setLength(0);
                    display2.setText(op1+"");
                    display1.setText(op2+"");

                    switch(flag)
                    {
                        case 1:  //for addition
                        {

                            display.setText((op1+op2)+"");
                            op1= op1+op2;
                            break;
                        }
                        case 2:  //for subtractoin
                        {

                            display.setText((op1-op2)+"");
                            op1-=op2;
                            break;
                        }
                        case (3):  //for multiply
                        {

                            display.setText((op1*op2)+"");
                            op1*=op2;
                            break;
                        }
                        case 4:  //for division
                        {

                            display.setText((op1/op2)+"");
                            op1/=op2;
                            break;
                        }
                        case 5:  //for percenatge
                        {

                            display.setText((op1*op2/100)+"");
                            op1=op1*op2/100;
                            break;
                        }

                        default:
                            Toast.makeText(this, "Not Valid",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case (R.id.equal1): {
                num.setLength(0);
                flag=0;
                op1= op2=null;
                display.setText(" ");
                display1.setText(" ");
                display2.setText(" ");
                break;
            }

            case (R.id.add): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op1 = Double.parseDouble(s);
                    display1.setText(num + "+");
                    display.setText(" ");
                    display2.setText(" ");
                    flag=1;   //flag 1 for addition
                    num.setLength(0);
                }
                else if(op1!=null)
                {
                    display2.setText(" ");
                    display1.setText(op1 + "+");
                    display.setText(" ");
                    flag=1;   //flag 1 for addition
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case (R.id.subtract): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op1 = Double.parseDouble(s);
                    display1.setText(num + "-");
                    display.setText(" ");
                    display2.setText(" ");
                    flag=2;   //flag 2 for subtraction
                    num.setLength(0);
                }
                else if(op1!=null)
                {
                    display2.setText(" ");
                    display1.setText(op1 + "-");
                    display.setText(" ");
                    flag=2;   //flag 1 for subtracton
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case (R.id.multiply): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op1 = Double.parseDouble(s);
                    display2.setText(" ");
                    display1.setText(num + "*");
                    display.setText("");
                    flag=3;   //flag 3 for multiply
                    num.setLength(0);
                }
                else if(op1!=null)
                {
                    display2.setText(" ");
                    display1.setText(op1 + "*");
                    display.setText(" ");
                    flag=3;   //flag 3- multiply
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case (R.id.divide): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op1 = Double.parseDouble(s);
                    display2.setText(" ");
                    display1.setText(num + "/");
                    display.setText(" ");
                    flag=4;   //flag 4 for division
                    num.setLength(0);
                }
                else if(op1!=null)
                {
                    display2.setText(" ");
                    display1.setText(op1 + "/");
                    display.setText(" ");
                    flag=4;   //flag 4 for divide
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case (R.id.percentage): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op1 = Double.parseDouble(s);
                    display2.setText(" ");
                    display1.setText(num + "%");
                    display.setText("");
                    flag=5;   //flag 5 for percentage
                    num.setLength(0);
                }
                else if(op1!=null)
                {
                    display2.setText(" ");
                    display1.setText(op1 + "%");
                    display.setText(" ");
                    flag=5;   //flag 5 for %
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case (R.id.sqr): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op1 = Double.parseDouble(s);
                    display2.setText(" ");
                    display1.setText(num + "²");
                    display.setText((op1*op1)+"");
                    num.setLength(0);
                    op1= op1*op1;

                }
                else if(op1!=null)
                {
                    display2.setText(" ");
                    display1.setText(num + "²");
                    display.setText((op1*op1)+"");

                    op1= op1*op1;
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case (R.id.sqrt): {
                if(num.length()!=0) {
                    String s= num.toString();
                    op1 = Double.parseDouble(s);
                    display2.setText(" ");
                    display1.setText(num + "√");
                    display.setText(Math.sqrt(op1)+"");
                    op1=Math.sqrt(op1);
                    num.setLength(0);
                }
                else if(op1!=null)
                {
                    display2.setText(" ");
                    display1.setText(num + "√");
                    display.setText(Math.sqrt(op1)+"");
                    op1=Math.sqrt(op1);
                }
                else{
                    Toast.makeText(this, "Field is empty",Toast.LENGTH_SHORT).show();
                }
                break;
            }


        }

    }


}

