package com.example.week7_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class Task4 extends AppCompatActivity {
    // 각 위젯 변수 생성
    AutoCompleteTextView auto;
    MultiAutoCompleteTextView mauto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        // 자동 완성 아이템 변수 생성
        String [] items = {"서울", "부산", "춘천", "원주", "횡성", "어묵", "떡볶이", "치킨", "피자",
                            "족발", "마라탕", "게임", "운동-축구", "운동-야구", "운동-배드민턴", "한림대학교", "휴일",
                            "공강", "인강", "휴강", "운동", "3분할", "운동-벤치프레스", "운동-데드리프트"};

        // 각 위젯 변수 id 연결
        auto = (AutoCompleteTextView) findViewById(R.id.actv1);
        mauto = (MultiAutoCompleteTextView) findViewById(R.id.mactv1);

        // 어댑터에 아이템 넣어 생성, 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);
        
        // 멀티 자동완성을 위한 토큰 생성 및 어댑터 연결
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        mauto.setTokenizer(token);
        mauto.setAdapter(adapter);
        
        
    }
}