package com.example.jwon223.testapp3;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String[] fields) {
        super(context, R.layout.activity_custom_adapter, fields);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.activity_custom_adapter, parent, false);

        TextView drawerEntry = (TextView) view.findViewById(R.id.drawerEntry);
        drawerEntry.setText(getItem(position));
        drawerEntry.setTextColor(Color.WHITE);

        return view;
    }
}
