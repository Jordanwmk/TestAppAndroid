package com.example.jwon223.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validateDetails(View view){
        TextView usernameInput = (TextView) findViewById(R.id.usernameInput);
        TextView passwordInput = (TextView) findViewById(R.id.passwordInput);

        if (passwordInput.getText().toString().equals("123")){
            Intent i = new Intent(this, MainActivity2.class);

            i.putExtra("username", usernameInput.getText().toString());
            startActivity(i);
        } else {
            Toast.makeText(this, "Wrong Details!", Toast.LENGTH_SHORT).show();
        }
    }
}
