package com.example.week9_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Task3_first extends AppCompatActivity {
    // 위젯 변수 생성
    Button btn_second, btn_third, btn_close, btn_self, btn_name, btn_major, btn_site;
    Switch swc_show;
    TextView tv_out, tv_info;
    ImageView imv_in, imv_out;
    SlidingDrawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_first);

        setTitle("메인 액티비티");

        // 위젯 id 연결
        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);
        btn_close = (Button) findViewById(R.id.btn_close);
        btn_self = (Button) findViewById(R.id.btn_self);
        btn_name = (Button) findViewById(R.id.btn_name);
        btn_major = (Button) findViewById(R.id.btn_major);
        btn_site = (Button) findViewById(R.id.btn_site);

        tv_out = (TextView) findViewById(R.id.tv_out);
        tv_info = (TextView) findViewById(R.id.tv_info);

        swc_show = (Switch) findViewById(R.id.swc_show);

        drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);

        imv_in = (ImageView) findViewById(R.id.imv_in);
        imv_out = (ImageView) findViewById(R.id.imv_out);

        // btn_self 눌렀을 때의 이벤트 처리
        btn_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setVisibility(View.VISIBLE);
            }
        });

        // btn_second 눌렀을 때의 이벤트 처리
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // second(자동차 클래스)로 화면 전환
                Intent intent = new Intent(getApplicationContext(), Task3_second.class);
                startActivity(intent);
            }
        });

        // btn_third 눌렀을 때의 이벤트 처리
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // third(계산기 클래스)로 화면 전환
                Intent intent = new Intent(getApplicationContext(), Task3_third.class);
                startActivity(intent);
            }
        });

        // btn_close 눌렀을 때의 이벤트 처리
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서랍이 닫힘
                drawer.animateClose();
            }
        });

        // swc_show 눌렀을 때의 이벤트 처리
        swc_show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swc_show.isChecked() == true) {
                    tv_info.setVisibility(View.GONE);
                    btn_name.setVisibility(View.VISIBLE);
                    btn_major.setVisibility(View.VISIBLE);
                    btn_site.setVisibility(View.VISIBLE);
                    tv_out.setVisibility(View.VISIBLE);
                    imv_out.setVisibility(View.VISIBLE);
                } else {
                    tv_info.setVisibility(View.GONE);
                    btn_name.setVisibility(View.GONE);
                    btn_major.setVisibility(View.GONE);
                    btn_site.setVisibility(View.GONE);
                    tv_out.setVisibility(View.GONE);
                    imv_out.setVisibility(View.GONE);
                }
            }
        });
    }
}