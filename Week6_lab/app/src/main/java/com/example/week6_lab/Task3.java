package com.example.week6_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Task3 extends AppCompatActivity {
    // 각 위젯 변수 선언
    EditText et_num1, et_num2;
    Button btn_add, btn_sub, btn_mul, btn_dvi;
    TextView tv_result;
    Integer num1, num2, result;

    // 10개 숫자 버튼 배열
    Button[] btn_num = new Button[10];

    // 10개 숫자 버튼의 id값 배열
    Integer[] btn_numID = { R.id.btn_zero, R.id.btn_one, R.id.btn_two,
            R.id.btn_three, R.id.btn_four, R.id.btn_five, R.id.btn_six,
            R.id.btn_seven, R.id.btn_eight, R.id.btn_nine
    };
    // 인덱스 증가값
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        setTitle("그리드레이아웃 게산기");

        // 각 변수 위젯 id 연결
        et_num1 = (EditText) findViewById(R.id.et_num1);
        et_num2 = (EditText) findViewById(R.id.et_num2);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_dvi = (Button) findViewById(R.id.btn_dvi);

        tv_result = (TextView) findViewById(R.id.tv_result);

        // 더하기 버튼이 눌렸을 때의 이벤트 처리
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());
                result = num1 + num2;
                tv_result.setText("계산 결과 : " + result.toString());
            }
        });

        // 빼기 버튼이 눌렸을 때의 이벤트 처리
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());
                result = num1 - num2;
                tv_result.setText("계산 결과 : " + result.toString());
            }
        });

        // 곱하기 버튼이 눌렸을 때의 이벤트 처리
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());
                result = num1 * num2;
                tv_result.setText("계산 결과 : " + result.toString());
            }
        });

        // 나누기 버튼이 눌렸을 때의 이벤트 처리
        btn_dvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());
                if(num1 == 0 || num2 == 0) {
                    tv_result.setText("divide 0 오류!!!!");
                    Toast.makeText(getApplicationContext(),"EditText의 내용에 0이 입력되었습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result = num1 / num2;
                    tv_result.setText("계산 결과 : " + result.toString());
                }
            }
        });

        // 숫자 버튼 10개 대입
        for(i = 0; i < btn_numID.length; i++) {
            btn_num[i] = (Button) findViewById(btn_numID[i]);
        }

        // 숫자 버튼 10개에 대해서 이벤트 처리
        for(i = 0; i < btn_numID.length; i++) {
            final int index;
            index = i;

            btn_num[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 포커스가 되어 있는 에디트텍스트에 숫자 추가
                    if (et_num1.isFocused() == true) {
                        num1 = Integer.parseInt(et_num1.getText().toString())
                                + Integer.parseInt(btn_num[index].getText().toString());
                        et_num1.setText(num1 + "");
                    } else if (et_num2.isFocused() == true) {
                        num2 = Integer.parseInt(et_num2.getText().toString())
                                + Integer.parseInt(btn_num[index].getText().toString());
                        et_num2.setText(num2 + "");
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}