package com.example.week7_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class Task3_FirstActivity extends AppCompatActivity {
    //각 위젯 변수 선언
    Button btn_ck1, btn_ck2, btn_radio, btn_back;
    CheckBox chk_me;
    RadioGroup rgp_ddeok;
    Switch swc_noodle;
    TextView tv_name;
    ImageView img_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_first);

        //각 위젯 변수와 위젯들 연결
        btn_ck1 = (Button) findViewById(R.id.btn_ck1);
        btn_ck2 = (Button) findViewById(R.id.btn_ck2);
        btn_radio = (Button) findViewById(R.id.btn_radio);
        chk_me = (CheckBox) findViewById(R.id.chk_me);
        rgp_ddeok = (RadioGroup) findViewById(R.id.rgp_ddeok);
        swc_noodle = (Switch) findViewById(R.id.swc_noodle);
        tv_name = (TextView) findViewById(R.id.tv_name);
        img_main = (ImageView) findViewById(R.id.img_main);

        btn_back = (Button) findViewById(R.id.btn_back);

        // ck1 버튼이 눌렸을 때의 이벤트 작성
        btn_ck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText("후라이드치킨");
                img_main.setImageResource(R.drawable.ck1);
            }
        });

        // ck2 버튼이 눌렸을 때의 이벤트 작성
        btn_ck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText("양념치킨");
                img_main.setImageResource(R.drawable.ck2);
            }
        });

        // CheckBox가 체크 됐을 때의 이벤트 작성
        chk_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chk_me.isChecked() == true) {
                    tv_name.setText("윤인선(증명사진)");
                    img_main.setImageResource(R.drawable.photo);
                } else {
                    tv_name.setText("사진 감추기");
                    img_main.setImageResource(0);
                }
            }
        });

        // RadioGroup에 있는 RadioButton이 눌렸을 때의 이벤트 작성
        btn_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rgp_ddeok.getCheckedRadioButtonId()) {
                    case R.id.rdb_yeop:
                        tv_name.setText("엽기떡볶이");
                        img_main.setImageResource(R.drawable.yeop);
                        break;
                    case R.id.rdb_sinjeon:
                        tv_name.setText("신전떡볶이");
                        img_main.setImageResource(R.drawable.sinjeon);
                        break;
                    case R.id.rdb_gobddeok:
                        tv_name.setText("곱창떡볶이");
                        img_main.setImageResource(R.drawable.gobddeok);
                        break;
                    case R.id.rdb_italyddeok:
                        tv_name.setText("이타리아떡볶이");
                        img_main.setImageResource(R.drawable.italyddeok);
                        break;
                    case R.id.rdb_cheong:
                        tv_name.setText("청년다방");
                        img_main.setImageResource(R.drawable.cheong);
                        break;
                }
            }
        });

        // swc_noodle이 눌렸을 때의 이벤트 작성
        swc_noodle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swc_noodle.isChecked() == true) {
                    tv_name.setText("라면");
                    img_main.setImageResource(R.drawable.ramen);
                } else {
                    tv_name.setText("우동");
                    img_main.setImageResource(R.drawable.jn);
                }
            }
        });

        // btn_back이 눌렸을 때 Task3_FourthActivity로 액티비티 이동
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Task3_FirstActivity.this, Task3_FourthActivity.class);
                startActivity(intent);
            }
        });
    }
}