package com.example.week11_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task1 extends AppCompatActivity {
    // 위젯 변수 선언
    Button btn_write, btn_read;
    EditText et_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        setTitle("Task1_에디트텍스트 내용 파일입출력");

        // 위젯 id 연결
        btn_read = (Button) findViewById(R.id.btn_read);
        btn_write = (Button) findViewById(R.id.btn_write);
        et_text = (EditText) findViewById(R.id.et_text);

        // btn_read에 대한 이벤트 처리
        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream infs = openFileInput("file.txt");
                    byte[] txt = new byte[infs.available()];
                    infs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    infs.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // btn_write에 대한 이벤트 처리
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outfs = openFileOutput("file.txt", MODE_PRIVATE);
                    String str = et_text.getText().toString();
                    outfs.write(str.getBytes());
                    Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
                    outfs.close();
                } catch(IOException e) {

                }
            }
        });
    }
}