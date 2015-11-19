package com.example.jwon223.testapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView dbLabel = (TextView) findViewById(R.id.dbLabel);
        String db = getIntent().getStringExtra("db");
        dbLabel.setText(db);
    }
}
