package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button b_equal;
    private Button b_multi;
    private Button b_divide;
    private Button b_add;
    private Button b_sub;
    private Button b_clear;
    private Button b_dot;
    private Button b_para;
    private TextView t;
    private double val1 = Double.NaN;
    private double val2;
    private final char SUM = '+';
    private final char SUB = '-';
    private final char MUL = '*';
    private final char DIV = '/';
    private char operator;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();

        b1.setOnClickListener(view -> t.setText(t.getText().toString() + "1"));
        b2.setOnClickListener(view -> t.setText(t.getText().toString() + "2"));
        b3.setOnClickListener(view -> t.setText(t.getText().toString() + "3"));
        b4.setOnClickListener(view -> t.setText(t.getText().toString() + "4"));
        b5.setOnClickListener(view -> t.setText(t.getText().toString() + "5"));
        b6.setOnClickListener(view -> t.setText(t.getText().toString() + "6"));
        b7.setOnClickListener(view -> t.setText(t.getText().toString() + "7"));
        b8.setOnClickListener(view -> t.setText(t.getText().toString() + "8"));
        b9.setOnClickListener(view -> t.setText(t.getText().toString() + "9"));
        b0.setOnClickListener(view -> t.setText(t.getText().toString() + "0"));
        b_dot.setOnClickListener(view -> t.setText(t.getText().toString() + "."));

        b_add.setOnClickListener(view -> {
            val2 = Double.parseDouble(t.getText().toString());
            if (!Double.isNaN(val1)) val1 += val2;
            else val1 = val2;
            t.setText("");
            operator = SUM;
        });

        b_sub.setOnClickListener(view -> {
            val2 = Double.parseDouble(t.getText().toString());
            if (!Double.isNaN(val1)) val1 -= val2;
            else val1 = val2;
            t.setText("");
            operator = SUB;
        });

        b_multi.setOnClickListener(view -> {
            val2 = Double.parseDouble(t.getText().toString());
            if (!Double.isNaN(val1)) val1 *= val2;
            else val1 = val2;
            t.setText("");
            operator = MUL;
        });

        b_divide.setOnClickListener(view -> {
            val2 = Double.parseDouble(t.getText().toString());
            if (!Double.isNaN(val1)) val1 /= val2;
            else val1 = val2;
            t.setText("");
            operator = DIV;
        });

        b_equal.setOnClickListener(view -> {
            if (!Double.isNaN(val1)) {
                val2 = Double.parseDouble(t.getText().toString());
                switch (operator) {
                    case SUM: val1 += val2;
                    case SUB: val1 -= val2;
                    case MUL: val1 *= val2;
                    case DIV: val1 /= val2;
                }
                t.setText(Double.toString(val1));
            }
        });
    }

    private void viewSetup() {
        b1 = findViewById(R.id.button_1);
        b2 = findViewById(R.id.button_2);
        b3 = findViewById(R.id.button_3);
        b4 = findViewById(R.id.button_4);
        b5 = findViewById(R.id.button_5);
        b6 = findViewById(R.id.button_6);
        b7 = findViewById(R.id.button_7);
        b8 = findViewById(R.id.button_8);
        b9 = findViewById(R.id.button_9);
        b0 = findViewById(R.id.button_0);
        b_equal = findViewById(R.id.button_equal);
        b_multi = findViewById(R.id.button_mul);
        b_divide = findViewById(R.id.button_div);
        b_add = findViewById(R.id.button_plus);
        b_sub = findViewById(R.id.button_minus);
        b_clear = findViewById(R.id.button_clear);
        b_dot = findViewById(R.id.button_dot);
        b_para = findViewById(R.id.button_sign);
        t = findViewById(R.id.textview_input);
    }
}