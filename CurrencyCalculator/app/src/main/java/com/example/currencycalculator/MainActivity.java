package com.example.currencycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    protected Spinner spinner1, spinner2;
    protected TextView input, output;
    protected List<String> currency = new ArrayList<>(Arrays.asList("USD", "EUR", "JPY", "GBP", "AUD","CAD","KRW", "SGD", "RUB", "VND"));
    protected double[] ratio = { 1, 0.95, 134.42, 0.81, 1.42, 1.28, 1279.28, 1.39, 57.62, 23182 };
    protected String working = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        List<String> list1 = new ArrayList<>(currency);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list2 = new ArrayList<>(currency);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
    }

    protected String cal(String val) {
        double inp = Double.parseDouble(val);
        int index1 = spinner1.getSelectedItemPosition();
        int index2 = spinner2.getSelectedItemPosition();
        return String.valueOf(inp / ratio[index1] * ratio[index2]);
    }

    protected void set(String value) {
        working += value;
        input.setText(working);
        output.setText((cal(working)));
    }

    public void clear(View view) {
        working = "";
        set("0");
    }

    public void backspace(View view) {
        if (working.length() > 1) {
            String s = working.substring(0, working.length() - 1);
            working = "";
            set(s);
        } else {
            working = "";
            set("0");
        }
    }

    public void zero(View view) {
        if (working.equals("0")) working = "";
        set("0");
    }

    public void one(View view) {
        if (working.equals("0")) working = "";
        set("1");
    }

    public void two(View view) {
        if (working.equals("0")) working = "";
        set("2");
    }

    public void three(View view) {
        if (working.equals("0")) working = "";
        set("3");
    }

    public void four(View view) {
        if (working.equals("0")) working = "";
        set("4");
    }

    public void five(View view) {
        if (working.equals("0")) working = "";
        set("5");
    }

    public void six(View view) {
        if (working.equals("0")) working = "";
        set("6");
    }

    public void seven(View view) {
        if (working.equals("0")) working = "";
        set("7");
    }

    public void eight(View view) {
        if (working.equals("0")) working = "";
        set("8");
    }

    public void nine(View view) {
        if (working.equals("0")) working = "";
        set("9");
    }

    public void dot(View view) {
        if (!working.contains("\\.")) set(".");
    }
}