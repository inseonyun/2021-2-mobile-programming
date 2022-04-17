package com.example.week10_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Task4 extends AppCompatActivity {
    // 위젯 변수 선언
    LinearLayout layout;
    Button btn_color, btn_scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        setTitle("과제4");

        // 위젯 변수 id 연결

        layout = (LinearLayout) findViewById(R.id.layout);
        btn_color = (Button) findViewById(R.id.btn_color);
        btn_scale = (Button) findViewById(R.id.btn_scale);

        // contextmenu에 각 버튼 등록
        registerForContextMenu(btn_color);
        registerForContextMenu(btn_scale);
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();

        if(v == btn_color) {
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu, menu);
        }
        if(v == btn_scale) {
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                layout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                layout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                btn_scale.setRotation(45);
                return true;
            case 5:
                btn_scale.setScaleX(2);
                btn_scale.setScaleY(2);
                return true;
        }
        return false;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                layout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                layout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemRotation:
                btn_scale.setRotation(45);
                return true;
            case R.id.itemScale:
                btn_scale.setScaleX(2);
                btn_scale.setScaleY(2);
                return true;
        }

        return false;
    }
}