package com.example.week12_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Task1 extends AppCompatActivity {
    // 변수 생성
    public static int rotate = 0;
    public static int transX = 0, transY = 0;
    public static int scaleX = 1, scaleY = 1;
    public static float skewX = 0.0f, skewY = 0.0f;

    MyGraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_task1);

        graphicView = (MyGraphicView) new MyGraphicView(this);

        setContentView(graphicView);
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.small);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            canvas.rotate(rotate, cenX, cenY);

            canvas.translate(transX, transY);

            canvas.scale(scaleX, scaleY, cenX, cenY);

            canvas.skew (skewX, skewY);

            canvas.drawBitmap(picture, picX, picY, null);

            picture.recycle(); // 비트맵 리소스 해제
        }
    }

    // 옵션 메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "그림 회전");
        menu.add(0, 2, 0, "그림 반대 회전");
        menu.add(0, 3, 0, "그림 이동");
        menu.add(0, 4, 0, "그림 확대");
        menu.add(0, 5, 0, "그림 기울이기");
        menu.add(0, 6, 0, "그림 원상복구");
        return true;
    }
    // 옵션 메뉴 이벤트 처리
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case 1:
                rotate += 25;
                graphicView.invalidate();
                break;
            case 2:
                rotate -= 25;
                graphicView.invalidate();
                break;
            case 3:
                transX += 50;
                transY += 50;
                graphicView.invalidate();
                break;
            case 4:
                scaleX += 1;
                scaleY += 1;
                graphicView.invalidate();
                break;
            case 5:
                skewX += 0.1f;
                skewY += 0.1f;
                graphicView.invalidate();
                break;
            case 6:
                rotate = 0;
                transX = 0;
                transY = 0;
                scaleX = 1;
                scaleY = 1;
                skewX = 0.0f;
                skewY = 0.0f;
                graphicView.invalidate();
                break;
        }

        return false;
    }
}