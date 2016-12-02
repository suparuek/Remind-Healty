package com.example.stripz.remind;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TableLogin tableLogin;
    private TableFood tableFood;
    private EditText liUser, liPass;
    private TextView registerLink;
    private Button btnLogin;
    private String strUser, strPass, strPassTrue;
    private String name, age, gender, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind Widget
        bindWidget();
        //Connected Database
        connectedDatabase();
        //Tester Update
        testerUpdate();
    }

    private void bindWidget() {
        liUser = (EditText) findViewById(R.id.liUser);
        liPass = (EditText) findViewById(R.id.liPass);
        registerLink = (TextView) findViewById(R.id.registerLink);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    public void clickLogin(View view) {
        strUser = liUser.getText().toString().trim();
        strPass = liPass.getText().toString().trim();
        if (strUser.equals("") || strPass.equals("")) {
            showAlert("Have Space", "Please fill in the blank");
        } else {
            checkUser();
        }
    }

    private void checkUser() {
        try {
            String data[] = tableLogin.searchUser(strUser);
            strPassTrue = data[2];
            name = data[3];
            age = data[4];
            if (data[5].equals("1")) {
                gender = "Male";
            } else if (data[5].equals("2")) {
                gender = "Female";
            }
            weight = data[6];
            height = data[7];

            checkPassword();

        } catch (Exception e) {
            showAlert("No this user", "No " +strUser+ " in Database");
        }
    }

    private void checkPassword() {
        if (strPass.equals(strPassTrue)) {
            //Intent CalculateActivity
            Intent objIntent = new Intent(MainActivity.this, CalculateActivity.class);
            objIntent.putExtra("Username", strUser);
            objIntent.putExtra("Name", name);
            objIntent.putExtra("Age", age);
            objIntent.putExtra("Gender", gender);
            objIntent.putExtra("Weight", weight);
            objIntent.putExtra("Height", height);
            startActivity(objIntent);
        } else {
            showAlert("Wrong Password", "Please try again Password false");
        }
    }

    private void showAlert(String title,String mes) {
        AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
        objAlert.setIcon(R.drawable.logo);
        objAlert.setTitle(title);
        objAlert.setMessage(mes);
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        objAlert.show();
    }

    public void clickRegister(View view) {
        Intent objIntent = new Intent(MainActivity.this, FromRegisterActivity.class);
        startActivity(objIntent);
        finish();
    }

    private void testerUpdate() {
        tableFood.addNewValueToSQLite("ข้าวกระเพราไก่+ไข่ดาว", "680");
        tableFood.addNewValueToSQLite("ข้าวผัดหมู", "557");
        tableFood.addNewValueToSQLite("สลัดผัก", "90");
        tableFood.addNewValueToSQLite("แกงส้ม", "120");
        tableFood.addNewValueToSQLite("ข้าวหมูกระเทียม+ไข่ดาว", "560");
        tableFood.addNewValueToSQLite("โยเกิร์ต", "100");
        tableFood.addNewValueToSQLite("กล้วยหอม", "77");
        tableFood.addNewValueToSQLite("ยำทูน่า", "122");
        tableFood.addNewValueToSQLite("นมจืด", "55");
        tableFood.addNewValueToSQLite("น้ำเปล่า", "0");
    }

    private void connectedDatabase() {
        tableLogin = new TableLogin(this);
        tableFood = new TableFood(this);
    }
}
