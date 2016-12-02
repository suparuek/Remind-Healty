package com.example.stripz.remind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PlanActivity extends AppCompatActivity {

    private TableFood objFoodTABLE;
    private String[] strListFood, strListCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        objFoodTABLE = new TableFood(this);

        //Set All Array
        setAllArray();

        //Create ListView
        createListView();
    }

    private void createListView() {
        int [] myTaget = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5,
                R.drawable.food6, R.drawable.food7, R.drawable.food8, R.drawable.food9, R.drawable.food10};

        MyAdapter objMyAdapter = new MyAdapter(PlanActivity.this, strListFood, strListCal, myTaget);
        ListView objListView = (ListView) findViewById(R.id.listFoodView);
        objListView.setAdapter(objMyAdapter);
    }

    private void setAllArray() {
        strListFood = objFoodTABLE.listFood();
        strListCal = objFoodTABLE.listCal();
    }
}
