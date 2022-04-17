package com.example.week10_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Task2 extends AppCompatActivity {
    // 위젯 변수 생성
    EditText et_angle;
    Button btn_result;
    RelativeLayout layout;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        setTitle("과제2");

        // 위젯 변수 id 연결
        et_angle = (EditText) findViewById(R.id.et_angle);
        btn_result = (Button) findViewById(R.id.btn_result);
        layout = (RelativeLayout) findViewById(R.id.layout);
        imgView = (ImageView) findViewById(R.id.imgView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "배경색 (빨강) 한라산");
        menu.add(0, 2, 0, "배경색 (초록) 추자도");
        menu.add(0, 3, 0, "배경색 (파랑) 밤섬");

        SubMenu sMenu = menu.addSubMenu("버튼 변경 >> ");
        sMenu.add(0, 4, 0, "입력된 값만큼 버튼 회전");
        sMenu.add(0, 5, 0, "버튼 2배 확대");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1 :
                layout.setBackgroundColor(Color.RED);
                imgView.setImageResource(R.drawable.halla);
                return true;
            case 2 :
                layout.setBackgroundColor(Color.GREEN);
                imgView.setImageResource(R.drawable.chujado);
                return true;
            case 3 :
                layout.setBackgroundColor(Color.BLUE);
                imgView.setImageResource(R.drawable.bamseom);
                return true;
            case 4 :
                btn_result.setRotation(Float.parseFloat(et_angle.getText().toString()));
                return true;
            case 5 :
                btn_result.setScaleX(2);
                btn_result.setScaleY(2);
                return true;
        }
        return false;
    }
}