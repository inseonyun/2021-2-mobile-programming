package com.example.week3_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Task1 extends AppCompatActivity {
    // 버튼과 텍스트뷰 위젯 변수 선언
    Button btn_var1, btn_var2, btn_var3, btn_var4, btn_var5;
    TextView tv_var1, tv_var2, tv_var3, tv_var4, tv_var5;

    // 버튼 클릭시 출력할 변수 선언
    int var1 = 10;
    float var2 = 10.1f;
    double var3 = 10.2;
    char var4 = '안';
    String var5 = "안드로이드";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        
        // 버튼과 텍스트뷰 위젯 id 연결
        btn_var1 = (Button) findViewById(R.id.btn_var1);
        btn_var2 = (Button) findViewById(R.id.btn_var2);
        btn_var3 = (Button) findViewById(R.id.btn_var3);
        btn_var4 = (Button) findViewById(R.id.btn_var4);
        btn_var5 = (Button) findViewById(R.id.btn_var5);

        tv_var1 = (TextView) findViewById(R.id.tv_var1);
        tv_var2 = (TextView) findViewById(R.id.tv_var2);
        tv_var3 = (TextView) findViewById(R.id.tv_var3);
        tv_var4 = (TextView) findViewById(R.id.tv_var4);
        tv_var5 = (TextView) findViewById(R.id.tv_var5);

        // btn_var1에 대한 이벤트 처리
        btn_var1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ""를 더해서 자료형을 문자열로 형변환 시킴
                tv_var1.setText(var1+"");
            }
        });

        // btn_var2에 대한 이벤트 처리
        btn_var2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ""를 더해서 자료형을 문자열로 형변환 시킴
                tv_var2.setText(var2+"");
            }
        });

        // btn_var3에 대한 이벤트 처리
        btn_var3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ""를 더해서 자료형을 문자열로 형변환 시킴
                tv_var3.setText(var3+"");
            }
        });

        // btn_var4에 대한 이벤트 처리
        btn_var4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ""를 더해서 자료형을 문자열로 형변환 시킴
                tv_var4.setText(var4+"");
            }
        });

        // btn_var5에 대한 이벤트 처리
        btn_var5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_var5.setText(var5);
            }
        });

    }
}