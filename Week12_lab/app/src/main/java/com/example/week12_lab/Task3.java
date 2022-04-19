package com.example.week12_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Task3 extends AppCompatActivity {
    // 변수 생성
    public static MyGraphicView myGraphicView;
    public static int x = 3,y = 3,z = 3;
    public static float amb = 0.3f;
    public static int specul = 3;
    public static int blurRadi = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myGraphicView = (MyGraphicView) new MyGraphicView(this);

        setContentView(myGraphicView);
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

            Paint paint = new Paint();
            paint.setColor(Color.GRAY);

            EmbossMaskFilter eMask = new EmbossMaskFilter(new float[] { x, y, z}, amb, specul, blurRadi);

            paint.setMaskFilter(eMask);
            canvas.drawCircle(cenX, cenY, 150, paint);

        }
    }

    // 옵션 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "빛 방향 변경");
        menu.add(0, 2, 0, "빛 밝기 변경");
        menu.add(0, 3, 0, "빛 반사 계수 변경");
        menu.add(0, 4, 0, "가장자리 크기 변경");

        return true;
    }

    // 옵션 이벤트 처리

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                x += 2;
                myGraphicView.invalidate();
                break;
            case 2:
                amb += 0.2f;
                myGraphicView.invalidate();
                break;
            case 3:
                specul += 1;
                myGraphicView.invalidate();
                break;
            case 4:
                blurRadi += 1;
                myGraphicView.invalidate();
                break;
        }

        return false;
    }
}