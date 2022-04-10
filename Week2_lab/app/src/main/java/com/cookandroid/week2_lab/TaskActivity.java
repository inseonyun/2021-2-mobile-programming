package com.cookandroid.week2_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {
    //각 위젯 변수 선언
    Button btn_dog1, btn_dog2, btn_radio;
    CheckBox chk_cat;
    RadioGroup rgp_italy;
    Switch swc_rabbit;
    TextView tv_name;
    ImageView img_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //각 위젯 변수와 위젯들 연결
        btn_dog1 = (Button) findViewById(R.id.btn_dog1);
        btn_dog2 = (Button) findViewById(R.id.btn_dog2);
        btn_radio = (Button) findViewById(R.id.btn_radio);
        chk_cat = (CheckBox) findViewById(R.id.chk_cat);
        rgp_italy = (RadioGroup) findViewById(R.id.rgp_italy);
        swc_rabbit = (Switch) findViewById(R.id.swc_rabbit);
        tv_name = (TextView) findViewById(R.id.tv_name);
        img_main = (ImageView) findViewById(R.id.img_main);

        // dog1 버튼이 눌렸을 때의 이벤트 작성
        btn_dog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText("강아지(dog1)");
                img_main.setImageResource(R.drawable.dog1);
            }
        });

        // dog2 버튼이 눌렸을 때의 이벤트 작성
        btn_dog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText("강아지(dog2)");
                img_main.setImageResource(R.drawable.dog2);
            }
        });

        // CheckBox가 체크 됐을 떄의 이벤트 작성
        chk_cat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chk_cat.isChecked() == true) {
                    tv_name.setText("고양이(cat1)");
                    img_main.setImageResource(R.drawable.cat1);
                } else {
                    tv_name.setText("고양이(cat2)");
                    img_main.setImageResource(R.drawable.cat2);
                }
            }
        });

        // RadioGroup에 있는 RadioButton이 눌렸을 때의 이벤트 작성
        btn_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rgp_italy.getCheckedRadioButtonId()) {
                    case R.id.rdb_italy1:
                        tv_name.setText("이태리(italy1)");
                        img_main.setImageResource(R.drawable.italy01);
                        break;
                    case R.id.rdb_italy2:
                        tv_name.setText("이태리(italy2)");
                        img_main.setImageResource(R.drawable.italy02);
                        break;
                    case R.id.rdb_italy3:
                        tv_name.setText("이태리(italy3)");
                        img_main.setImageResource(R.drawable.italy03);
                        break;
                    case R.id.rdb_italy4:
                        tv_name.setText("이태리(italy4)");
                        img_main.setImageResource(R.drawable.italy04);
                        break;
                    case R.id.rdb_italy5:
                        tv_name.setText("이태리(italy5)");
                        img_main.setImageResource(R.drawable.italy05);
                        break;
                }
            }
        });

        // swc_rabbit이 눌렸을 때의 이벤트 작성
        swc_rabbit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swc_rabbit.isChecked() == true) {
                    tv_name.setText("토끼(rabbit)");
                    img_main.setImageResource(R.drawable.rabbit);
                } else {
                    tv_name.setText("토끼(rabbit2)");
                    img_main.setImageResource(R.drawable.rabbit2);
                }
            }
        });
    }
}