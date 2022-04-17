package com.example.week10_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class Task1 extends AppCompatActivity {
    // 위젯 변수 생성
    LinearLayout layout;
    Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        // 위젯 변수 id 연결
        layout = (LinearLayout) findViewById(R.id.layout);
        btn_result = (Button) findViewById(R.id.btn_result);

        setTitle("과제 1");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "배경색 (빨강)");
        menu.add(0, 2, 0, "배경색 (초록)");
        menu.add(0, 3, 0, "배경색 (파랑)");

        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
        sMenu.add(0, 4, 0, "버튼 45도 회전");
        sMenu.add(0, 5, 0, "버튼 2배 확대");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case 1 :
                layout.setBackgroundColor(Color.RED);
                return true;
            case 2 :
                layout.setBackgroundColor(Color.GREEN);
                return true;
            case 3 :
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case 4 :
                btn_result.setRotation(45);
                return true;
            case 5 :
                btn_result.setScaleX(2);
                btn_result.setScaleY(2);
                return true;
        }
        return false;
    }
}