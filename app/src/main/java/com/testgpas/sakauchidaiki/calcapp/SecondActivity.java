package com.testgpas.sakauchidaiki.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        String operator = intent.getStringExtra("OPERATOR");

        TextView textView = (TextView) findViewById(R.id.textView);
        double result = -999.99;    // default

        // ビッグデシマル で計算するのが厳密

        if(operator.equals("+")){
            result = value1 + value2;
        }
        else if(operator.equals("-")) {
            result = value1 - value2;
        }
        else if(operator.equals("*")) {
            result = value1 * value2;
        }
        else if(operator.equals("/")) {
            result = value1 / value2;
        }

        textView.setText(String.valueOf(result));


    }
}
