package com.example.feelman_museum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_detail extends AppCompatActivity {

    TextView mTitleTv, mEraTv,mPlaceTv, mDescTv,mDetailTv;
    ImageView mImageIv;
    // MediaPlayer 객체생성
    MediaPlayer mediaPlayer;

    // 시작버튼
    Button startButton,stopButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        startButton = (Button)findViewById(R.id.s);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 플레이 중이라면

                if(mediaPlayer != null &&  mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;

                    // reset() 함수만으로도 동작한다.
                    //mediaPlayer.reset();
                    startButton.setText("재생 하기");
                }
                else // 미디어 리소스를 생성하고 플레이 시킨다.
                {
                    mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.asd);
                    mediaPlayer.start();

                    // 반복재생하기
                    mediaPlayer.setLooping(true);
                    startButton.setText("종료 하기");
                }
            }
        });

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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}