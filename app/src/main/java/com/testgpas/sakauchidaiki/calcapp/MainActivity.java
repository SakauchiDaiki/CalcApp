package com.testgpas.sakauchidaiki.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditNum1, mEditNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditNum1 = (EditText) findViewById(R.id.editNum1);
        mEditNum2 = (EditText) findViewById(R.id.editNum2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("+");
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("-");
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("*");
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText("/");

        // リスナーが登録されていない
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

//        double number1 = Double.parseDouble(mEditNum1.getText().toString());
//        double number2 = Double.parseDouble(mEditNum2.getText().toString());

        // 判定うまくできず。
        try {
            double number1 = Double.parseDouble(mEditNum1.getText().toString());
            double number2 = Double.parseDouble(mEditNum2.getText().toString());

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", number1);
            intent.putExtra("VALUE2", number2);

            // インテントにとんでいいかチェック
            // +
            if (v.getId() == R.id.button1) {
                intent.putExtra("OPERATOR", "+");
            }

            // -
            else if (v.getId() == R.id.button2) {
                intent.putExtra("OPERATOR", "-");
            }

            // *
            else if (v.getId() == R.id.button3) {
                intent.putExtra("OPERATOR", "*");
            }

            // /
            else if (v.getId() == R.id.button4) {
                if (number2 != 0) {
                    intent.putExtra("OPERATOR", "/");
                } else {
                    Toast.makeText(this, "0で割ることはできません", Toast.LENGTH_LONG).show();
                }
            }

            startActivity(intent);
        }

        catch (NumberFormatException e) {
            Toast.makeText(this, "数値を入れてください", Toast.LENGTH_LONG).show();
        }
    }
}

