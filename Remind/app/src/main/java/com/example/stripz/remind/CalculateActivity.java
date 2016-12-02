package com.example.stripz.remind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    private TextView getName, getAge, getGender, getWeight, getHeight;
    private String strUser, strWeight, strHeight, txtBMI;
    private double weight, height, BMI = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        //bind Widget
        bindWidget();
        //setShowText
        setShowText();
    }

    public void clickCalculate(View view) {
        weight = Double.parseDouble(strWeight);
        height = Double.parseDouble(strHeight) / 100;
        BMI = weight / (height * height);
        txtBMI = String.format("%.2f", BMI);
        Log.d("BMI", String.valueOf(BMI));
        if (BMI > 23.4) {
            Intent overIntent = new Intent(CalculateActivity.this, BMIover.class);
            overIntent.putExtra("BMI", txtBMI);
            startActivity(overIntent);
            finish();
        } else if (BMI < 18.5) {
            Intent underIntent = new Intent(CalculateActivity.this, BMIunder.class);
            underIntent.putExtra("BMI", txtBMI);
            startActivity(underIntent);
            finish();
        } else {
            Intent normalIntent = new Intent(CalculateActivity.this, BMInormal.class);
            normalIntent.putExtra("BMI", txtBMI);
            startActivity(normalIntent);
            finish();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setShowText();
    }

    public void clickUpdate(View view) {
        Intent objIntent = new Intent(CalculateActivity.this, UpdateActivity.class);
        objIntent.putExtra("Username", strUser);
        startActivity(objIntent);
    }

    private void setShowText() {
        strUser = getIntent().getExtras().getString("Username");
        String name = getIntent().getExtras().getString("Name");
        String age = getIntent().getExtras().getString("Age");
        String gender = getIntent().getExtras().getString("Gender");
        strWeight = getIntent().getExtras().getString("Weight");
        strHeight = getIntent().getExtras().getString("Height");
        getName.setText(name);
        getAge.setText(age);
        getGender.setText(gender);
        getWeight.setText(strWeight + " kg");
        getHeight.setText(strHeight + " cm");
    }

    private void bindWidget() {
        getName = (TextView) findViewById(R.id.getName);
        getAge = (TextView) findViewById(R.id.getAge);
        getGender = (TextView) findViewById(R.id.getGender);
        getWeight = (TextView) findViewById(R.id.getWeight);
        getHeight = (TextView) findViewById(R.id.getHeight);
    }
}
