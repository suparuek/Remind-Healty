package com.example.stripz.remind;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class FromRegisterActivity extends AppCompatActivity {

    private EditText etUser, etPass, etName, etAge, etWeight, etHeight;
    private RadioButton rMale, rFemale;
    private String strUser, strPass, strName;
    private int age, gender;
    private double weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_register);
        //bind Widget
        bindWidget();
    }

    private void bindWidget() {
        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        rMale = (RadioButton) findViewById(R.id.rMale);
        rFemale = (RadioButton) findViewById(R.id.rFemale);
    }

    public void clickRegister(View view) {
        confirmData();
    }

    private void confirmData() {
        AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
        objAlert.setTitle("Are you sure ?");
        objAlert.setCancelable(false);
        objAlert.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                upDatatoSQLite();
                Toast.makeText(FromRegisterActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                Intent objIntent = new Intent(FromRegisterActivity.this, MainActivity.class);
                startActivity(objIntent);
                finish();
            }
        });
        objAlert.show();
    }

    private void upDatatoSQLite() {
        TableLogin objTableLogin = new TableLogin(this);
        strUser = etUser.getText().toString().trim();
        strPass = etPass.getText().toString().trim();
        strName = etName.getText().toString().trim();
        age = Integer.parseInt(etAge.getText().toString());
        if (rMale.isChecked()) {
            gender = 1;
        } else if (rFemale.isChecked()) {
            gender = 2;
        }
        weight = Double.parseDouble(etWeight.getText().toString());
        height = Double.parseDouble(etHeight.getText().toString());
        long insertData = objTableLogin.addNewValueToSQLite(strUser,strPass,strName,age,gender,weight,height);
    }
}
