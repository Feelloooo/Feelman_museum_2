package com.example.feelman_museum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_fllipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(R.drawable.actionbar_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getHashKey();

        int images[] = {
                R.drawable.main_img1,
                R.drawable.main_img2,
                R.drawable.main_img3,
                R.drawable.main_img4
        };
        v_fllipper = findViewById(R.id.image_slide);

        for(int image : images) {
            fllipperImages(image);
        }
        //연혁
        Button button1 = findViewById(R.id.menu1); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_intro.class);
                startActivity(intent);
            }
        });
        //테스트
        Button button2 = findViewById(R.id.menu2); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_heritage.class);
                startActivity(intent);
            }
        });
        //층별 안내 버튼
        Button button3 = findViewById(R.id.menu3); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_floor_info.class);
                startActivity(intent);
            }
        });


        Button button4 = findViewById(R.id.menu4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_program.class);
                startActivity(intent);
            }
        });
        //오시는길 버튼
        Button button5 = findViewById(R.id.menu5); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_route.class);
                startActivity(intent);
            }
        });
    }

    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(3000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        v_fllipper.setInAnimation(this,R.anim.slide_in_right);
        v_fllipper.setOutAnimation(this,R.anim.slide_out_left);
    }
//    private void getHashKey() {
//            PackageInfo packageInfo = null;
//            try {
//                packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//            if (packageInfo == null)
//                Log.e("KeyHash", "KeyHash:null");
//
//            for (Signature signature : packageInfo.signatures) {
//                try {
//                    MessageDigest md = MessageDigest.getInstance("SHA");
//                    md.update(signature.toByteArray());
//                    Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//                } catch (NoSuchAlgorithmException e) {
//                    Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
//                }
//            }
//        }

}