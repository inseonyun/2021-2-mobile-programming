package com.example.week9_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Task2_first extends AppCompatActivity {
    // 위젯 변수 생성
    Button btn_second, btn_third, btn_scale, btn_self, btn_name, btn_major, btn_site;
    TextView tv_out;
    SlidingDrawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2_first);

        setTitle("메인 액티비티");

        // 위젯 id 연결
        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);
        btn_scale = (Button) findViewById(R.id.btn_scale);
        btn_self = (Button) findViewById(R.id.btn_self);
        btn_name = (Button) findViewById(R.id.btn_name);
        btn_major = (Button) findViewById(R.id.btn_major);
        btn_site = (Button) findViewById(R.id.btn_site);
        tv_out = (TextView) findViewById(R.id.tv_out);
        drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);

        // btn_self 눌렀을 때의 이벤트 처리
        btn_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_name.setVisibility(View.VISIBLE);
                btn_major.setVisibility(View.VISIBLE);
                btn_site.setVisibility(View.VISIBLE);
                tv_out.setVisibility(View.VISIBLE);
                tv_out.setText("서랍 밖입니다.");
            }
        });

        // btn_second 눌렀을 때의 이벤트 처리
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // second(자동차 클래스)로 화면 전환
                Intent intent = new Intent(getApplicationContext(), Task2_second.class);
                startActivity(intent);
            }
        });

        // btn_third 눌렀을 때의 이벤트 처리
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // third(계산기 클래스)로 화면 전환
                Intent intent = new Intent(getApplicationContext(), Task2_third.class);
                startActivity(intent);
            }
        });

        // btn_scale 눌렀을 때의 이벤트 처리
        btn_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서랍이 확장됨
                btn_name.setVisibility(View.GONE);
                btn_major.setVisibility(View.GONE);
                btn_site.setVisibility(View.GONE);
                tv_out.setVisibility(View.GONE);
            }
        });

        // btn_name 눌렀을 때의 이벤트 처리
        btn_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_out.setText("윤인선");
                tv_out.setTextSize(24);
                Toast.makeText(getApplicationContext(), "윤인선", Toast.LENGTH_SHORT).show();
            }
        });

        // btn_major 눌렀을 때의 이벤트 처리
        btn_major.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_out.setText("빅데이터 전공");
                tv_out.setTextSize(24);
                Toast.makeText(getApplicationContext(), "빅데이터 전공", Toast.LENGTH_SHORT).show();
            }
        });

        // btn_site 눌렀을 때의 이벤트 처리
        btn_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_out.setText("즐겨찾는 사이트 유튜브");
                tv_out.setTextSize(24);
                Toast.makeText(getApplicationContext(), "유튜브", Toast.LENGTH_SHORT).show();
            }
        });
    }
}