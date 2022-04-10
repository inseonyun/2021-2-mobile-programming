package com.cookandroid.week2_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity3 extends AppCompatActivity {
    RadioGroup rgp;
    RadioButton rb1, rb2, rb3;
    Button btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rgp = (RadioGroup) findViewById(R.id.rgp);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        btn = (Button) findViewById(R.id.btn);
        img = (ImageView) findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rgp.getCheckedRadioButtonId()) {
                    case R.id.rb1:
                        img.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rb2:
                        img.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rb3:
                        img.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        img.setImageResource(R.drawable.dog);
                }
            }
        });
    }
}