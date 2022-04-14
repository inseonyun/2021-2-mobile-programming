package com.example.week6_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Task2 extends AppCompatActivity {
    // 각 버튼과 이미지뷰 변수 생성
    Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six;
    ImageView imv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        // 각 변수들의 위젯 id 연결
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_five = (Button) findViewById(R.id.btn_five);
        btn_six = (Button) findViewById(R.id.btn_six);

        imv_main = (ImageView) findViewById(R.id.imv_main);

        // btn_one이 눌렸을 때의 이벤트 처리
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지뷰에 짜장면을 출력
                imv_main.setImageResource(R.drawable.bn);
            }
        });

        // btn_two이 눌렸을 때의 이벤트 처리
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지뷰에 곱창떡볶이을 출력
                imv_main.setImageResource(R.drawable.gobddeok);
            }
        });

        // btn_three이 눌렸을 때의 이벤트 처리
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지뷰에 라면면을 출력
               imv_main.setImageResource(R.drawable.ramen);
            }
        });

        // btn_four이 눌렸을 때의 이벤트 처리
        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지뷰에 야구를 출력
                imv_main.setImageResource(R.drawable.baseball);
            }
        });

        // btn_five이 눌렸을 때의 이벤트 처리
        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지뷰에 오징어게임을 출력
                imv_main.setImageResource(R.drawable.netflix);
            }
        });

        // btn_six이 눌렸을 때의 이벤트 처리
        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지뷰에 게임을 출력
                imv_main.setImageResource(R.drawable.lol);
            }
        });
    }
}