package com.example.adityasuwandi.bankhutan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.adityasuwandi.bankhutan.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {
    //deklarasi semua komponen View yang akan digunakan
    private MainFragment mainFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        if (savedInstanceState == null) {
            // withholding the previously created fragment from being created again
            // On orientation change, it will prevent fragment recreation
            // its necessary to reserving the fragment stack inside each tab
            initScreen();

        } else {
            // restoring the previously created fragment
            // and getting the reference
            mainFragment = (MainFragment) getSupportFragmentManager().getFragments().get(0);
        }
    }

    private void initScreen() {
        // Creating the ViewPager container fragment once
        mainFragment = new MainFragment();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {

        if (!mainFragment.onBackPressed()) {
            // container Fragment or its associates couldn't handle the back pressed task
            // delegating the task to super class
            super.onBackPressed();

        } else {
            // carousel handled the back pressed task
            // do not call super
        }
    }
}
