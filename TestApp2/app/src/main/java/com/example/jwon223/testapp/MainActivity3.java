package com.example.jwon223.testapp;


import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    ActionBar.Tab testTab, profileTab;

    Fragment testFragmentTab = new ProfileFragmentTab();
    Fragment profileFragmentTab = new MainActivity2();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Asking for the default ActionBar element that our platform supports.
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        // Screen handling while hiding ActionBar icon.
        actionBar.setDisplayShowHomeEnabled(false);

        // Screen handling while hiding Actionbar title.
        actionBar.setDisplayShowTitleEnabled(false);

        // Creating ActionBar tabs.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        testTab = actionBar.newTab();
        testTab.setText("Test");

        profileTab = actionBar.newTab();
        profileTab.setText("Profile");

        // Setting tab listeners.
        testTab.setTabListener(new TabListener(testFragmentTab));
        profileTab.setTabListener(new TabListener((profileFragmentTab)));


        // Adding tabs to the ActionBar.
        actionBar.addTab(testTab);
        actionBar.addTab(profileTab);

    }
}
