package com.example.week9_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Task1_third extends AppCompatActivity {
    // 위젯 변수 선언
    Button btn_add, btn_sub, btn_mul, btn_divide, btn_back;
    EditText et_num1, et_num2;
    TextView tv_result;

    // 변수 선언
    int num1, num2, result;

    // class Cal 정의
    public class Cal {
        int result;

        public Cal() {
        }
        // 덧셈을 수행하는 메소드
        public void addCal(int num1, int num2) {
            result = num1 + num2;
        }
        // 뺄셈을 수행하는 메소드
        public void subCal(int num1, int num2) {
            result = num1 - num2;
        }
        // 곱셈을 수행하는 메소드
        public void mulCal(int num1, int num2) {
            result = num1 * num2;
        }
        //나눗셈을 수행하는 메소드
        public void divCal(int num1, int num2) {
            // 나누려는 값, 나누어주는 값이 0이면 -1을 반환
            if(num1 == 0 || num2 == 0) {
                result = -1;
            }
            else {
                result = num1 / num2;
            }
        }
        // result 값을 반환해주는 getResult 메소드
        public int getResult() {
            return result;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1_third);

        // 위젯 변수 id 연결
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_divide = (Button) findViewById(R.id.btn_divide);

        et_num1 = (EditText) findViewById(R.id.et_num1);
        et_num2 = (EditText) findViewById(R.id.et_num2);

        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_back = (Button) findViewById(R.id.btn_back);

        // 클래스 생성 및 선언
        Cal cal = new Cal();

        // btn_add 합 버튼 클릭시 이벤트 처리
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // et_num1과 et_num2에서 받은 값 변수에 저장
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());
                
                // result에 cal 클래스의 addCal메소드를 이용하여 합 결과 저장
                cal.addCal(num1, num2);
                result = cal.getResult();
                
                // tv_result에 결과를 출력함
                tv_result.setText("두 수의 합 = " + result);
            }
        });

        // btn_sub 차 버튼 클릭시 이벤트 처리
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // et_num1과 et_num2에서 받은 값 변수에 저장
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());

                // result에 cal 클래스의 subCal메소드를 이용하여 차 결과 저장
                cal.subCal(num1, num2);
                result = cal.getResult();

                // tv_result에 결과를 출력함
                tv_result.setText("두 수의 차 = " + result);
            }
        });

        // btn_mul 곱 버튼 클릭시 이벤트 처리
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // et_num1과 et_num2에서 받은 값 변수에 저장
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());

                // result에 cal 클래스의 mulCal메소드를 이용하여 곱 결과 저장
                cal.mulCal(num1, num2);
                result = cal.getResult();

                // tv_result에 결과를 출력함
                tv_result.setText("두 수의 곱 = " + result);
            }
        });

        // btn_divide 나눗셈 버튼 클릭시 이벤트 처리
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // et_num1과 et_num2에서 받은 값 변수에 저장
                num1 = Integer.parseInt(et_num1.getText().toString());
                num2 = Integer.parseInt(et_num2.getText().toString());

                // result에 cal 클래스의 divCal메소드를 이용하여 나눗셈 결과 저장
                cal.divCal(num1, num2);
                result = cal.getResult();

                // 결과값이 0이면 0으로 나누려고 했음. 예외처리 해줌
                if(result == -1) {
                    tv_result.setText("두 수의 나눗셈 = 불능(분모 = 0)");
                } else {
                    // tv_result에 결과를 출력함
                    tv_result.setText("두 수의 나눗셈 = " + result);
                }
            }
        });

        // btn_back이 눌리면 이전(main) 액티비티로 돌아감
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Task1_third.this, Task1_first.class);
                startActivity(intent);
            }
        });
    }
}