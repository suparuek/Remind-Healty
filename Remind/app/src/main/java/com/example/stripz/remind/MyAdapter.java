package com.example.stripz.remind;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

    private Context myContext;
    private String[] strNameFood, strCalFood;
    private int[] myTarget;

    public MyAdapter(Context context, String[] strName, String[] strCal, int[] targetID) {
        this.myContext = context;
        this.strNameFood = strName;
        this.strCalFood = strCal;
        myTarget = targetID;
    }

    @Override
    public int getCount() {
        return strNameFood.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater objLayoutInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = objLayoutInflater.inflate(R.layout.list_view_row, parent, false);

        //Set Text Food
        TextView listViewFood = (TextView) view.findViewById(R.id.txtShowFood);
        listViewFood.setText(strNameFood[position]);

        //Set Text Cal
        TextView listViewCal = (TextView) view.findViewById(R.id.txtShowCal);
        listViewCal.setText(strCalFood[position]);

        //Set Image
        ImageView listImageFood = (ImageView) view.findViewById(R.id.imgFood);
        listImageFood.setBackgroundResource(myTarget[position]);

        return view;
    }
}
