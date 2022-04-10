package com.cookandroid.week2_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity4 extends AppCompatActivity {
    Switch swc;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        swc = (Switch) findViewById(R.id.swc1);
        img = (ImageView) findViewById(R.id.img1);

        swc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swc.isChecked() == true)
                    img.setImageResource(R.drawable.dog);
                else
                    img.setImageResource(R.drawable.cat);
            }
        });

    }
}