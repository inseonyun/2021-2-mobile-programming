package com.example.week3_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Task2 extends AppCompatActivity {
    // 버튼과 에디트 텍스트, 텍스트뷰, 이미지뷰 변수 선언
    Button btn_ifelse, btn_switch;
    EditText et_score;
    ImageView img_ifelse, img_switch;

    // 점수를 저장할 변수와 받아온 점수를 형변환하여 저장할 변수
    String sscore="";
    int iscore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        // 위젯 변수의 위젯 id 연결
        btn_ifelse = (Button) findViewById(R.id.btn_ifelse);
        btn_switch = (Button) findViewById(R.id.btn_switch);

        et_score = (EditText) findViewById(R.id.et_score);


        img_ifelse = (ImageView) findViewById(R.id.img_ifelse);
        img_switch = (ImageView) findViewById(R.id.img_switch);

        // btn_ifelse 버튼이 눌리면 실행할 이벤트 처리
        btn_ifelse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 입력받은 점수를 변수에 저장
                sscore = et_score.getText().toString();

               // 저장한 변수를 정수 변수에 저장
                iscore = Integer.parseInt(sscore);

                // 계속해서 입력을 받아주기 위해 et_score를 비워줌
                et_score.setText("");

                // 점수에 해당하는 텍스트와 이미지 출력
                if(iscore >= 90) {
                    img_ifelse.setImageResource(R.drawable.img1);
                } else if(iscore >= 60) {
                    img_ifelse.setImageResource(R.drawable.img2);
                } else if(iscore == -99) {
                    finish();
                }
                else {
                    img_ifelse.setImageResource(R.drawable.img3);
                }
            }
        });

        // btn_switch 버튼이 눌리면 실행할 이벤트 처리
        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 입력 받은 점수를 변수에 저장
                sscore = et_score.getText().toString();
                // 저장한 변수를 정수 변수에 저장
                iscore = Integer.parseInt(sscore);

                // 계속해서 입력을 받아주기 위해 et_score를 비워줌
                et_score.setText("");
                // switch문에서 쉽게 조건 탐색을 하기 위해 일의 자리를 버려줌
                // 이 때 -99이면 종료를 하기 위해 ifelse로 -99만 그대로 둠
                if(iscore == -99) {
                } else {
                    iscore = (iscore / 10) * 10;
                }

                // 점수에 해당하는 텍스트와 이미지 출력
                switch (iscore) {
                    case 100:
                    case 90:
                        img_switch.setImageResource(R.drawable.img1);
                        break;
                    case 80:
                    case 70:
                    case 60:
                        img_switch.setImageResource(R.drawable.img2);
                        break;
                    case -99:
                        finish();
                        break;
                    default:
                        img_switch.setImageResource(R.drawable.img3);
                }
            }
        });
    }
}