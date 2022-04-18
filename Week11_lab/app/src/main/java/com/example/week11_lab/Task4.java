package com.example.week11_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class Task4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new MyGraphicView(this));

        setTitle("Task4_그래픽 처리");
    }
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // 페인트 생성
            Paint paint = new Paint();

            // 도형의 끝을 부드럽게 처리
            paint.setAntiAlias(true);
            // 컬러 지정
            paint.setColor(Color.BLACK);

            // 선 굵기 지정
            paint.setStrokeWidth(80);
            // 지정한 좌표 시작과 끝만큼 선을 그림
            // 시작x, 시작y, 끝x, 끝y
            canvas.drawLine(50, 160, 500, 160, paint);

            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50, 260, 500, 260, paint);

            // 도형 내부 색을 채움
            paint.setStyle(Paint.Style.FILL);
            RectF rectF = new RectF(50, 400, 50 + 400, 400 + 200);
            // 중심점 x,y, 반지름 r
            canvas.drawOval(rectF, paint);

            // 호 그림
            RectF rectF1 = new RectF(50, 650, 50 + 400, 650 + 200);
            canvas.drawArc(rectF1, 40, 110, true, paint);

            // 사각형 두 개 그림
            paint.setColor(Color.argb(0x88, 0x00, 0x00, 0xff));
            Rect rect1 = new Rect(  50, 900, 50 + 300, 900 + 300);
            canvas.drawRect(rect1, paint);

            paint.setColor(Color.argb(0x88, 0xff, 0x00, 0x00));
            Rect rect2 = new Rect(100, 950, 100 + 300, 950 + 300);
            canvas.drawRect(rect2, paint);

        }
    }
}