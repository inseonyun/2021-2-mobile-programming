package com.example.week7_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class Task2 extends AppCompatActivity {
    // 위젯 변수 선언
    EditText et_rev;
    Chronometer chrono;
    Button btn_start, btn_end;
    CalendarView calview;
    RadioButton rdb_cal, rdb_time;
    TimePicker timepicker;
    TextView tv_year, tv_month, tv_day, tv_hour, tv_min, tv_result;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        setTitle("스케쥴 예약");

        // 각 위젯 변수 id 연결
        et_rev = (EditText) findViewById(R.id.et_rev);

        chrono = (Chronometer) findViewById(R.id.chrono);

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_end = (Button) findViewById(R.id.btn_end);

        calview = (CalendarView) findViewById(R.id.calendarView);

        rdb_cal = (RadioButton) findViewById(R.id.rdb_cal);
        rdb_time = (RadioButton) findViewById(R.id.rdb_time);

        timepicker = (TimePicker) findViewById(R.id.timePicker);

        tv_year = (TextView) findViewById(R.id.tv_year);
        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_day = (TextView) findViewById(R.id.tv_day);
        tv_hour = (TextView) findViewById(R.id.tv_hour);
        tv_min = (TextView) findViewById(R.id.tv_min);
        tv_result = (TextView) findViewById(R.id.tv_result);

        // 초기 화면에는 timePicker와 CalanderView가 안 보이게 함
        timepicker.setVisibility(View.INVISIBLE);
        calview.setVisibility(View.INVISIBLE);

        // 캘린더 라디오 버튼 이벤트 처리
        rdb_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // timepicker는 안 보이게 하고, 캘린더뷰는 보이게 함
                timepicker.setVisibility(View.INVISIBLE);
                calview.setVisibility(View.VISIBLE);
            }
        });

        // 타임피커 라디오 버튼 이벤트 처리
        rdb_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // timepicker는 보이게 하고, 캘린더뷰는 안 보이게 함
                timepicker.setVisibility(View.VISIBLE);
                calview.setVisibility(View.INVISIBLE);
            }
        });

        // 예약 시작 버튼 이벤트 처리
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 타이머(크로노미터) 작동
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        // 예약 종료 버튼 이벤트 처리
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 타이머 작동 멈춤
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                // TextView에 예약 시간 출력
                tv_year.setText(Integer.toString(selectYear));
                tv_month.setText(Integer.toString(selectMonth));
                tv_day.setText(Integer.toString(selectDay));
                tv_hour.setText(Integer.toString(timepicker.getCurrentHour()));
                tv_min.setText(Integer.toString(timepicker.getCurrentMinute()));

                // 예약 내용에는 EditText에 입력한 내용이 나오게 됨
                tv_result.setText("내용 : " + et_rev.getText().toString());
            }
        });

        // 캘린더뷰 이벤트 처리
        calview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // 선택된 년도, 월, 일 데이터를 가져옴 Month는 0부터 시작하므로 +1을 해줌
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });
    }
}