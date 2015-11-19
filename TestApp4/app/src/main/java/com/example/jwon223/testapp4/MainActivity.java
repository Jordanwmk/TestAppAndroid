package com.example.jwon223.testapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;
    TextView nameInput, genderInput, resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (TextView) findViewById(R.id.nameInput);
        genderInput = (TextView) findViewById(R.id.genderInput);
        resultLabel = (TextView) findViewById(R.id.resultLabel);
        dbHandler = new MyDBHandler(this, null, null , 1);


    }

    //Add a product to the database
    public void addToDB(View view){
        dbHandler.onCreate(dbHandler.getWritableDatabase());
        Product product = new Product(nameInput.getText().toString());
        product.setGender(genderInput.getText().toString());
        dbHandler.addProduct(product);
//        seeDB(view);
    }

    //Print the database
    public void seeDB(View view){
        Intent i = new Intent(this, Main2Activity.class);
        String dbString = dbHandler.databaseToString();

        i.putExtra("db", dbString);
        startActivity(i);
//        String dbString = dbHandler.databaseToString();
//        resultLabel.setText(dbString);
    }

    public void createDB(View view) {
        dbHandler.onCreate(dbHandler.getWritableDatabase());
    }

    public void deleteDB(View view){
        dbHandler.deleteDB();
        resultLabel.setText("");
    }

}
