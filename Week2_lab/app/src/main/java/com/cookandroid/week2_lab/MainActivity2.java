package com.cookandroid.week2_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    CheckBox chk;
    TextView txt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        chk = (CheckBox) findViewById(R.id.chk);
        txt = (TextView) findViewById(R.id.textView);
        img = (ImageView) findViewById(R.id.img);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chk.isChecked() == true) {
                    txt.setText("강아지");
                    img.setImageResource(R.drawable.dog);
                }
                else {
                    txt.setText("고양이");
                    img.setImageResource(R.drawable.cat);
                }
            }
        });
    }
}