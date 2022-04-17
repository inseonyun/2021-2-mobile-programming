package com.example.week10_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Task3 extends AppCompatActivity {
    // 위젯 변수 선언
    Button btn_animal, btn_change;
    ImageView imageView;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        setTitle("과제3");

        // 위젯 변수 id 연결
        btn_animal = (Button) findViewById(R.id.btn_animal);
        btn_change = (Button) findViewById(R.id.btn_change);
        layout = (LinearLayout) findViewById(R.id.layout);
        imageView = (ImageView) findViewById(R.id.imgView);

        // 버튼에 컨텍스트 메뉴 등록
        registerForContextMenu(btn_animal);
        registerForContextMenu(btn_change);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();

        // btn_animal이 길게 눌렸을 때 보여질 메뉴
        if(v == btn_animal) {
            menu.setHeaderTitle("동물 선택");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if(v == btn_change) {
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemDog:
                imageView.setImageResource(R.drawable.dog);
                layout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemCat:
                imageView.setImageResource(R.drawable.cat);
                layout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemRabbit:
                imageView.setImageResource(R.drawable.rabbit);
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemRotation:
                imageView.setRotation(45);
                return true;
            case R.id.itemScale:
                imageView.setScaleX(2);
                imageView.setScaleY(2);
                return true;
        }

        return false;
    }
}