package com.example.feelman_museum;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.examples.classification.tflite.Classifier;

public class Description4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("간돌검");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        setResult(RESULT_OK, new Intent(this, Classifier.class));
    }
}