package com.example.week9_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Task2_second extends AppCompatActivity {
    // 위젯 변수 선언
    EditText et_color, et_speed;
    Button btn_create, btn_acc, btn_retar, btn_back;
    TextView tv_result, tv_result2;

    // editText에서 받아온 값 저장할 변수 선언
    int speed;
    String color;

    // 각 객체의 인덱스 값을 저장할 i변수 선언
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2_second);

        // 내부 클래스 선언
        class Car {
            String color;
            int speed;
            Car(String color, int speed) {
                this.color = color;
                this.speed = speed;
            }
            void upSpeed(int value) {
                if (speed >= 200)
                    speed = 200;
                else
                    speed = speed + value;
            }
            void downSpeed(int value) {
                if (speed <= 0)
                    speed = 0;
                else
                    speed = speed - value;
            }
            int getSpeed() {
                return speed;
            }
            String getColor() {
                return color;
            }
        }

        // 위젯 변수 id 연결
        et_color = (EditText) findViewById(R.id.et_color);
        et_speed = (EditText) findViewById(R.id.et_speed);
        btn_create = (Button) findViewById(R.id.btn_create);
        btn_acc = (Button) findViewById(R.id.btn_acceleration);
        btn_retar = (Button) findViewById(R.id.btn_retardation);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_result2 = (TextView) findViewById(R.id.tv_result2);
        btn_back = (Button) findViewById(R.id.btn_back);

        // 객체 틀을 미리 만들어둠
        Car car[] = new Car[3];

        // 객체 만들기 버튼 클릭시 객체 생성
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // editText에 있는 값을 가져옴
                color = et_color.getText().toString();
                speed = Integer.parseInt(et_speed.getText().toString());

                // 객체를 생성함
                car[i] = new Car(color, speed);

                // 객체를 만든 결과가 tv_result1에 출력되도록 함
                tv_result.setText(car[i].getSpeed() + " -- " + "자동차" + (i + 1) + "의 색상은 " + car[i].getColor());

                // 만든 후 tv_result2에 출력되있는 내용을 초기 내용으로 바꿔줌
                tv_result2.setText("결과2");
            }
        });

        // 가속 버튼 클릭시 수행할 이벤트 처리
        btn_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // editText에 있는 값을 가져옴
                speed = Integer.parseInt(et_speed.getText().toString());
                car[i].upSpeed(speed);

                // 스피드업 한 결과를 tv_result2에 출력되도록 함
                tv_result2.setText("가속 결과 현재 자동차" + (i + 1) + "의 속도 " + car[i].getSpeed());
            }
        });

        //감속 버튼 클릭시 수행할 이벤트 처리
        btn_retar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // editText에 있는 값을 가져옴
                speed = Integer.parseInt(et_speed.getText().toString());
                car[i].downSpeed(speed);

                // 스피드업 한 결과를 tv_result2에 출력되도록 함
                tv_result2.setText("감속 결과 현재 자동차" + (i + 1) + "의 속도 " + car[i].getSpeed());

                // 버튼 순서를 객체 생성 -> 가속 -> 감속 순으로 누른다 가정하에 코딩함.
                // 다음 객체를 담기 위해 i값 증가
                if(i < 2)
                    i++;
            }
        });

        // btn_back 클릭시 메인 액티비티로 이동
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Task2_second.this, Task2_first.class);
                startActivity(intent);
            }
        });

    }
}