package com.example.stripz.remind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BMIunder extends AppCompatActivity {

    private TextView txtBMIu;
    private Button btnGoPlanU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_bmi);
    }

    public void clickPlan(View view) {
        Intent objIntent = new Intent(BMIunder.this, PlanActivity.class);
        startActivity(objIntent);
        finish();
    }

    private void setTextBMI() {
        String BMI = getIntent().getExtras().getString("BMI");
        txtBMIu.setText(BMI);
    }

    private void bindWidget() {
        txtBMIu = (TextView) findViewById(R.id.txtBMIO);
        btnGoPlanU = (Button) findViewById(R.id.btnPlanUnder);
    }
}
