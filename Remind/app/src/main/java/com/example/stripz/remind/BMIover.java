package com.example.stripz.remind;

import android.content.Intent;
import android.icu.util.VersionInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIover extends AppCompatActivity {

    private TextView txtBMIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_bmi);
        //bind Widget
        bindWidget();
        //set BMI
        setTextBMI();
    }

    public void clickPlan(View view) {
        Intent objIntent = new Intent(BMIover.this, PlanActivity.class);
        startActivity(objIntent);
        finish();
    }

    private void setTextBMI() {
        String BMI = getIntent().getExtras().getString("BMI");
        txtBMIO.setText(BMI);
    }

    private void bindWidget() {
        txtBMIO = (TextView) findViewById(R.id.txtBMIO);
    }
}
