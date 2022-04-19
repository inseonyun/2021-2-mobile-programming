package com.example.week12_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Task2 extends AppCompatActivity {
    // 변수 생성
    public static BlurMaskFilter bMask;
    public MyGraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        graphicView = new MyGraphicView(this);

        setContentView(graphicView);
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            Paint paint = new Paint();


            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle(); // 비트맵 리소스 해제
        }
    }
    // 옵션 메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "NORMAL");
        menu.add(0, 2, 0, "INNER");
        menu.add(0, 3, 0, "OUTER");
        menu.add(0, 4, 0, "SOLID");

        return true;
    }
    // 옵션 이벤트 처리
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case 1:
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                graphicView.invalidate();
                break;
            case 2:
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
                graphicView.invalidate();
                break;
            case 3:
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
                graphicView.invalidate();
                break;
            case 4:
                bMask = new BlurMaskFilter (30, BlurMaskFilter.Blur.SOLID);
                graphicView.invalidate();
                break;
        }

        return false;
    }
}