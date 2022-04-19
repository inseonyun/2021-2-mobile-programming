package com.example.week12_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class test5 extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;
    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test5);

        setTitle("미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcon();
    }
    public void clickIcon() {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);


        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;  // 확대
                scaleY = scaleY + 0.2f;
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);

        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;   // 축소
                scaleY = scaleY - 0.2f;
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);

        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle + 20;      // 회전
                graphicView.invalidate();  // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);

        ibBright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color + 0.2f;    // 밝게
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);

        ibDark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color - 0.2f;   // 어둡게
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibGray = (ImageButton) findViewById(R.id.ibGray);

        ibGray.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (satur == 0)
                    satur = 1;     // 기본 값 = 1, 1이상이면 채도가 높음
                else
                    satur = 0;     // 회색 이미지로 변경하기 위한 값, 0이면 회색, 0~1이면 채도가 낮음
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;

            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();

            float array[] = {color, 0, 0, 0, 0,
                                0, color, 0, 0, 0,
                                0, 0, color, 0, 0,
                                0, 0, 0, 1, 0};

            ColorMatrix cm = new ColorMatrix(array);

            if(satur == 0)
                cm.setSaturation(satur);

            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            canvas.drawBitmap(picture, picX, picY, paint);


        }
    }
}