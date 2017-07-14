package com.quetzalstudio.ata.smartselect;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    String name;
    String fruit = "None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        transaction = fragmentManager.beginTransaction();

        MainFragment mainFragment = new MainFragment();

        transaction.add(R.id.frame_layout, mainFragment)
                .addToBackStack("mainFragment")
                .commit();
    }
}