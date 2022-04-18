package com.example.week11_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class Task3 extends AppCompatActivity {
    // 위젯 변수 선언
    Button btn_read;
    EditText et_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        setTitle("Task3_raw폴더 파일 처리");

        // 위젯 id 연결
        btn_read = (Button) findViewById(R.id.btn_read);
        et_result = (EditText) findViewById(R.id.et_result);

        // btn_read에 대한 이벤트 처리
        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputs = getResources().openRawResource(R.raw.raw_test);
                    byte[] txt = new byte[inputs.available()];
                    inputs.read(txt);
                    et_result.setText(new String(txt));
                    inputs.close();
                } catch (IOException e) {

                }
            }
        });
    }
}