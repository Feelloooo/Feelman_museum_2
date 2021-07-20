package com.example.feelman_museum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("박물관 소개");

        //연혁
        Button button1 = findViewById(R.id.button1); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_intro_1.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.button2); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_intro_2.class);
                startActivity(intent);
            }
        });
        //조직및 업무
        Button button3 = findViewById(R.id.button3); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_intro_3.class);
                startActivity(intent);
            }
        });
        //관람안내
        Button button4 = findViewById(R.id.button4); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_intro_4.class);
                startActivity(intent);
            }
        });
        Button button5 = findViewById(R.id.button5); //다른 버튼 사용할 때 변수명 바꿔서 사용
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_intro_5.class);
                startActivity(intent);
            }
        });

    }
}