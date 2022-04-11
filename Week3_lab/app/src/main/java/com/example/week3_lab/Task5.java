package com.example.week3_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Task5 extends AppCompatActivity {
    // 버튼과 텍스트뷰 위젯 변수 선언
    Button btn_sum, btn_sub;
    TextView tv_sum, tv_sub;

    // 전역변수 선언
    static int var = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        // 버튼과 텍스트뷰 변수의 위젯 id 연결
        btn_sum = (Button) findViewById(R.id.btn_sum);
        btn_sub = (Button) findViewById(R.id.btn_sub);

        tv_sum = (TextView) findViewById(R.id.tv_sum);
        tv_sub = (TextView) findViewById(R.id.tv_sub);

        // 함수들의 결과를 저장할 변수 선언
        int sum = addFoo(10, 20);
        int sub = subFoo(10, 20);

        // btn_sum을 누르면 실행할 이벤트 처리
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 함수의 결과를 textview에 형변환하여 출력함
                tv_sum.setText(sum + "");
            }
        });

        // btn_sub을 누르면 실행할 이벤트 처리
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 함수의 결과를 textview에 형변환하여 출력함
                tv_sub.setText(sub + "");
            }
        });
    }
    // 전역 변수의 합을 계산하는 함수 선언
    static int addFoo(int num1, int num2) {
        int sum;
        sum = num1 + num2 + var;
        return sum;
    }

    // 전역 변수의 차를 계산하는 함수 선언
    static int subFoo(int num1, int num2) {
        int sub;
        sub = num1 - num2 + var;
        return sub;
    }
}