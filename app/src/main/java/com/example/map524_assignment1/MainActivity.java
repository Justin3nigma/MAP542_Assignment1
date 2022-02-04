package com.example.map524_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaring Number Buttons
    private Button but_zero;
    private Button but_one;
    private Button but_two;
    private Button but_three;
    private Button but_four;
    private Button but_five;
    private Button but_six;
    private Button but_seven;
    private Button but_eight;
    private Button but_nine;

    //Declaring Operator Buttons
    private Button but_add;
    private Button but_sub;
    private Button but_mul;
    private Button but_div;
    private Button but_equ;
    private Button but_clr;

    //Declaring Text Views
    private TextView tv_input;
    private TextView tv_result;

    //1st and 2nd inputs
    private double input1 = Double.NaN;
    private double input2;

    //Operator state
    private char op_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIsetUp();
        ButtonSetUp();
    }

    private void UIsetUp() {
        //Matching buttons with IDs
        //Number Buttons
        but_zero = (Button) findViewById(R.id.zero_num);
        but_one = (Button) findViewById(R.id.one_num);
        but_two = (Button) findViewById(R.id.two_num);
        but_three = (Button) findViewById(R.id.three_num);
        but_four = (Button) findViewById(R.id.four_num);
        but_five = (Button) findViewById(R.id.five_num);
        but_six = (Button) findViewById(R.id.six_num);
        but_seven = (Button) findViewById(R.id.seven_num);
        but_eight = (Button) findViewById(R.id.eight_num);
        but_nine = (Button) findViewById(R.id.nine_num);

        //Operator Buttons
        but_add = (Button) findViewById(R.id.add_op);
        but_sub = (Button) findViewById(R.id.sub_op);
        but_mul = (Button) findViewById(R.id.mul_op);
        but_div = (Button) findViewById(R.id.div_op);
        but_equ = (Button) findViewById(R.id.equal_op);
        but_clr = (Button) findViewById(R.id.clear);

        //Text Views
        tv_input = (TextView) findViewById(R.id.info);
        tv_result = (TextView) findViewById(R.id.result);

    }

    //Declaring button action
    //Number Buttons
    private void ButtonSetUp(){
        but_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "0");
                // that letter is added to info textview
            }
        });
        but_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "1");
            }
        });
        but_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "2");
            }
        });
        but_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "3");
            }
        });
        but_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "4");
            }
        });
        but_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "5");
            }
        });
        but_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "6");
            }
        });
        but_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "7");
            }
        });
        but_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "8");
            }
        });
        but_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "9");
            }
        });

        //Operator Buttons
        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                op_mode = '+';
                tv_result.setText(String.valueOf(input1) + " + ");
                tv_input.setText(null);
            }
        });
        but_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                op_mode = '-';
                tv_result.setText(String.valueOf(input1) + " - ");
                tv_input.setText(null);
            }
        });
        but_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                op_mode = '*';
                tv_result.setText(String.valueOf(input1) + " * ");
                tv_input.setText(null);
            }
        });
        but_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ;
                calculate();
                op_mode = '/';
                tv_result.setText(String.valueOf(input1) + " / ");
                tv_input.setText(null);
            }
        });
        but_equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                op_mode = '=';
                tv_result.setText(tv_result.getText().toString() + String.valueOf(input2) + " = " + String.valueOf(input1));
                tv_input.setText(null);
            }
        });

        but_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear_func();
            }
        });
    }

    private void calculate() {
        //Calculation
        if (!Double.isNaN(input1)) { //First input should be a number
            input2 = Double.parseDouble(tv_input.getText().toString());
            //input 2 received from tv_input

            switch (op_mode) {
                case '+':
                    input1 = input1 + input2;
                    break;
                case '-':
                    input1 = input1 - input2;
                    break;
                case '*':
                    input1 = input1 * input2;
                    break;
                case '/':
                    input1 = input1 / input2;
                    break;
                case '=':
                    break;
            }
        }
        else{
            input1 = Double.parseDouble(tv_input.getText().toString());
        }
    }

    private void clear_func(){
        input1 = Double.NaN;
        input2 = Double.NaN;
        tv_input.setText(null);
        tv_result.setText(null);
    }

}