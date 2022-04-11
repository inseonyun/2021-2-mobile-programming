package com.example.week3_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Task4 extends AppCompatActivity {
    // 버튼과 텍스트뷰 위젯 변수 선언
    Button btn_for, btn_while;
    TextView tv_for, tv_while;

    // 곱을 구할 one 배열과 문자열 변수 선언
    int one[] = new int [3];
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        // 버튼과 텍스트뷰 변수의 위젯 id 연결
        btn_for = (Button) findViewById(R.id.btn_for);
        btn_while = (Button) findViewById(R.id.btn_while);

        tv_for = (TextView) findViewById(R.id.tv_for);
        tv_while = (TextView) findViewById(R.id.tv_while);

        // btn_for 버튼이 눌리면 실행할 이벤트 처리
        btn_for.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // result 변수 초기화
                result = "";
                for( int i = 0; i < one.length; i++) {
                    // one 배열에 값을 넣어줌
                    one[i] = 10 * i;

                    // 결과를 문자열로 형변환 하여 저장함
                    result += one[i] + "\n";
                }
                // 나온 결과를 tv_for에 넣어줌
                tv_for.setText(result);
            }
        });

        //btn_while 버튼이 눌리면 실행할 이벤트 처리
        btn_while.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // while문에서 반복을 위해 필요한 변수 선언
                int j = 0;
                // result 변수 초기화
                result = "";
                while( j < one.length) {
                    // 결과를 문자열로 형변환 하여 저장함
                    result += one[j] + "\n";
                    j++;
                }
                // 나온 결과를 tv_while에 넣어줌
                tv_while.setText(result);
            }
        });
    }
}