package com.example.stripz.remind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BMInormal extends AppCompatActivity {

    private TextView txtBMIn;
    private Button btnGoPlanN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_bmi);
        //bind Widget
        bindWidget();
        //set BMI
        setTextBMI();
    }

    public void clickPlan(View view) {
        Intent objIntent = new Intent(BMInormal.this, PlanActivity.class);
        startActivity(objIntent);
        finish();
    }

    private void setTextBMI() {
        String BMI = getIntent().getExtras().getString("BMI");
        txtBMIn.setText(BMI);
    }

    private void bindWidget() {
        txtBMIn = (TextView) findViewById(R.id.txtBMIO);
        btnGoPlanN = (Button) findViewById(R.id.btnPlanNormal);
    }
}
