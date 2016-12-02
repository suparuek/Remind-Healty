package com.example.stripz.remind;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private EditText edtName, edtAge, edtGender, edtWeight, edtHeight;
    private RadioButton rdMale, rdFemale;
    private TableLogin objTableLogin;
    private String strUser, currentName;
    private int currentAge, currentGender;
    private double currentWeight, currentHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        objTableLogin = new TableLogin(this);
        strUser = getIntent().getExtras().getString("Username");
        //bind Widget
        bindWidget();
    }

    private void bindWidget() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        rdMale = (RadioButton) findViewById(R.id.rdMale);
        rdFemale = (RadioButton) findViewById(R.id.rdFemale);
        edtWeight = (EditText) findViewById(R.id.edtWeight);
        edtHeight = (EditText) findViewById(R.id.edtHeight);
    }

    public void clickEdit(View view) {
        confirmEdit();
    }

    private void confirmEdit() {
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
                //deleteValue();
                //updateSQLite();
                Toast.makeText(UpdateActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
                Intent objIntent = new Intent(UpdateActivity.this, CalculateActivity.class);
                startActivity(objIntent);
                finish();
            }
        });
        objAlert.show();
    }

    //Error Can't Update
    /*private void updateSQLite() {
        currentName = edtName.getText().toString().trim();
        currentAge = Integer.parseInt(edtAge.getText().toString());
        if (rdMale.isChecked()) {
            currentGender = 1;
        } else {
            currentGender = 2;
        }
        currentWeight = Double.parseDouble(edtWeight.getText().toString());
        currentHeight = Double.parseDouble(edtHeight.getText().toString());
    }*/

    //Error Can't Delete
    /*private void deleteValue() {
        SQLiteDatabase deleteSQLite = openOrCreateDatabase("remind.db", MODE_PRIVATE, null);
        Cursor objCursor = deleteSQLite.rawQuery("SELECT * FROM loginTABLE", null);
        objCursor.moveToLast();
        int id = objCursor.getInt(objCursor.getColumnIndex("_id"));
        deleteSQLite.delete("loginTABLE", "_id" + "=" + id, null);
    }*/

}
