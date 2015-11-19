package com.example.jwon223.testapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final String[] fields = {getString(R.string.Profile), getString(R.string.Friends), getString(R.string.LogOut)};
        ListAdapter navigationAdapter = new CustomAdapter(this, fields);
        ListView listView = (ListView) findViewById(R.id.left_drawer);
        listView.setAdapter(navigationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomePage.this, fields[position], Toast.LENGTH_SHORT);
            }
        });

    }
}
