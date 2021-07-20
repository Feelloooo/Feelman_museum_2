package com.example.feelman_museum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_detail extends AppCompatActivity {

    TextView mTitleTv, mEraTv,mPlaceTv, mDescTv,mDetailTv;
    ImageView mImageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitleTv = findViewById(R.id.title);
        mEraTv = findViewById(R.id.era);
        mPlaceTv = findViewById(R.id.place);
        mDescTv = findViewById(R.id.description);
        mDetailTv = findViewById(R.id.detail);
        mImageIv = findViewById(R.id.imageView);

        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mEra = intent.getStringExtra("iEra");
        String mPlace = intent.getStringExtra("iPlace");
        String mDescription = intent.getStringExtra("iDesc");
        String mDetail = intent.getStringExtra("iDetail");

        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);

        mTitleTv.setText(mTitle);
        mEraTv.setText(mEra);
        mPlaceTv.setText(mPlace);
        mDescTv.setText(mDescription);
        mDetailTv.setText(mDetail);
        mImageIv.setImageBitmap(bitmap);
    }
}