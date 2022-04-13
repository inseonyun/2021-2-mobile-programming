package com.example.week5_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Task2 extends AppCompatActivity {
    // 위젯 변수 선언
    Button btn_openurl, btn_openfav1, btn_openfav2, btn_openfav3, btn_finish;
    EditText et_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        // 위젯 변수 id 연결
        btn_openurl = (Button) findViewById(R.id.btn_openurl);
        btn_openfav1 = (Button) findViewById(R.id.btn_openfav1);
        btn_openfav2 = (Button) findViewById(R.id.btn_openfav2);
        btn_openfav3 = (Button) findViewById(R.id.btn_openfav3);
        btn_finish = (Button) findViewById(R.id.btn_finish);

        et_url = (EditText) findViewById(R.id.et_url);

        // btn_openurl을 눌렀을 때의 이벤트 처리
        btn_openurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // et_url에 입력된 주소 오픈
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(et_url.getText().toString()));
                startActivity(intent);
            }
        });

        // btn_openfav1을 눌렀을 때의 이벤트 처리
        btn_openfav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 네이버 홈페이지 오픈
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                startActivity(intent);
            }
        });

        // btn_openfav2을 눌렀을 때의 이벤트 처리
        btn_openfav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 구글 홈페이지 오픈
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(intent);
            }
        });

        // btn_openfav3을 눌렀을 때의 이벤트 처리
        btn_openfav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 페이스북 홈페이지 오픈
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com"));
                startActivity(intent);
            }
        });

        // btn_finish를 눌렀을 때의 이벤트 처리
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 앱 종료
                finish();
            }
        });
    }
}