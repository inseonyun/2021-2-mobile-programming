package com.example.week11_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Task2 extends AppCompatActivity {
    // 위젯 변수 선언
    DatePicker datePicker;
    EditText et_text;
    Button btn_write;

    // 다이어리 파일명 변수 선언
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        
        setTitle("Task2_간단 일기장");

        // 위젯 id 연결
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        btn_write = (Button) findViewById(R.id.btn_write);
        et_text = (EditText) findViewById(R.id.et_text);

        // 현재 날짜를 받을 변수 생성
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        // 파일명을 년도_월_일.txt가 되게 함
        fileName = Integer.toString(cYear) + "_"
                + Integer.toString(cMonth+1) + "_"
                + Integer.toString(cDay) + ".txt";
        // 사용자 함수 readDiary 호출
        String str = readDiary(fileName);
        et_text.setText(str);
        btn_write.setEnabled(true);
        // 데이트피커에 현재 날짜를 보이게 하고, 날짜가 변경 됐을 때의 이벤트 처리
        datePicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 파일명을 년도_월_일.txt가 되게 함
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                // 사용자 함수 readDiary 호출
                String str = readDiary(fileName);
                et_text.setText(str);
                btn_write.setEnabled(true);
            }
        });

        // btn_write 눌렀을 때의 이벤트 처리
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outfs = openFileOutput(fileName, MODE_PRIVATE);
                    String str = et_text.getText().toString();
                    outfs.write(str.getBytes());
                    outfs.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장됨", Toast.LENGTH_SHORT).show();
                } catch(IOException e) {

                }
            }
        });
    }

    // 사용자 함수 readDiary
    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream infs;
        try {
            infs = openFileInput(fName);
            byte [] txt = new byte[infs.available()];
            infs.read(txt);
            infs.close();
            diaryStr = (new String(txt)).trim();
            btn_write.setText("수정 하기");
        }catch (IOException e) {
            et_text.setHint("일기 없음");
            btn_write.setText("새로 저장");
        }
        return diaryStr;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "배경색 (빨강)");
        menu.add(0, 2, 0, "배경색 (초록)");
        menu.add(0, 3, 0, "배경색 (파랑)");

        SubMenu subMenu = menu.addSubMenu("버튼 변경 >>");
        subMenu.add(0, 4, 0, "버튼 45도 회전");
        subMenu.add(0, 5, 0, "버튼 2배 확대");

       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case 1:
                et_text.setBackgroundColor(Color.RED);
                return true;
            case 2:
                et_text.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                et_text.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                btn_write.setRotation(45);
                return true;
            case 5:
                btn_write.setScaleX(2);
                btn_write.setScaleY(2);
                return true;
        }

        return false;
    }
}