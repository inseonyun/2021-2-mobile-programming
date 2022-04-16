package com.example.week9_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

public class Task1_first extends AppCompatActivity {
    // 위젯 변수 생성
    Button btn_second, btn_third, btn_self, btn_close, btn_site1, btn_site2, btn_site3;
    SlidingDrawer drawer;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1_first);

        setTitle("메인 액티비티");

        // 위젯 id 연결
        btn_self = (Button) findViewById(R.id.btn_self);
        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);
        btn_close = (Button) findViewById(R.id.btn_close);
        btn_site1 = (Button) findViewById(R.id.btn_site1);
        btn_site2 = (Button) findViewById(R.id.btn_site2);
        btn_site3 = (Button) findViewById(R.id.btn_site3);

        tv_result = (TextView) findViewById(R.id.tv_result);

        drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);

        // btn_second 눌렀을 때의 이벤트 처리
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // second(자동차 클래스)로 화면 전환
                Intent intent = new Intent(getApplicationContext(), Task1_second.class);
                startActivity(intent);
            }
        });

        // btn_third 눌렀을 때의 이벤트 처리
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // third(계산기 클래스)로 화면 전환
                Intent intent = new Intent(getApplicationContext(), Task1_third.class);
                startActivity(intent);
            }
        });

        // btn_close 눌렀을 때의 이벤트 처리
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서랍이 닫히게 됨
                drawer.animateClose();
            }
        });

        // btn_self 눌렀을 때의 이벤트 처리
        btn_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_result.setText("20175154 빅데이터 전공 윤인선");
            }
        });

        // btn_site1 눌렀을 때의 이벤트 처리
        btn_site1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_result.setText("네이버");
                Toast.makeText(getApplicationContext(), "즐겨찾는 사이트1 : 네이버", Toast.LENGTH_SHORT).show();
            }
        });

        // btn_site2 눌렀을 때의 이벤트 처리
        btn_site2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_result.setText("유튜브");
                Toast.makeText(getApplicationContext(), "즐겨찾는 사이트2 : 유튜브", Toast.LENGTH_SHORT).show();
            }
        });

        // btn_site3 눌렀을 때의 이벤트 처리
        btn_site3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_result.setText("페이스북");
                Toast.makeText(getApplicationContext(), "즐겨찾는 사이트3 : 페이스북", Toast.LENGTH_SHORT).show();
            }
        });
    }
}