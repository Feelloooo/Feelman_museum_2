package com.example.feelman_museum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_intro_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("조직 및 업무");
    }
}