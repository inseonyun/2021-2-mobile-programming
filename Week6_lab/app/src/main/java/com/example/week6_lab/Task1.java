package com.example.week6_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Task1 extends AppCompatActivity {
    EditText et_num1, et_num2;
    Button btn_add, btn_sub, btn_mul, btn_dvi;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Task1의 레이아웃 xml 파일을 제거 했기 때문에 java파일에서 선언함
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        setContentView(layout, params);

        // 각 위젯 들을 레이아웃에 추가함
        et_num1 = new EditText(this);
        et_num1.setHint("여기에 입력하세요");
        et_num1.setTextSize(24);
        layout.addView(et_num1);

        et_num2 = new EditText(this);
        et_num2.setHint("여기에 입력하세요");
        et_num2.setTextSize(24);
        layout.addView(et_num2);

        btn_add = new Button(this);
        btn_add.setText("더하기 버튼입니다.");
        btn_add.setBackgroundColor(Color.YELLOW);
        layout.addView(btn_add);

        btn_sub = new Button(this);
        btn_sub.setText("빼기 버튼입니다.");
        btn_sub.setBackgroundColor(Color.RED);
        layout.addView(btn_sub);

        btn_mul = new Button(this);
        btn_mul.setText("곱하기 버튼입니다.");
        btn_mul.setBackgroundColor(Color.GREEN);
        layout.addView(btn_mul);

        btn_dvi = new Button(this);
        btn_dvi.setText("나누기 버튼입니다.");
        btn_dvi.setBackgroundColor(Color.BLUE);
        layout.addView(btn_dvi);

        tv_result = new TextView(this);
        tv_result.setText("여기에 결과가 나타납니다");
        tv_result.setTextColor(Color.MAGENTA);
        tv_result.setTextSize(24);
        layout.addView(tv_result);

        // 더하기 버튼 눌렀을 때의 이벤트 처리
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(et_num1.getText().toString());
                int num2 = Integer.parseInt(et_num2.getText().toString());
                int result = num1 + num2;

                tv_result.setText(result + "");
            }
        });

        // 빼기 버튼 눌렀을 때의 이벤트 처리
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(et_num1.getText().toString());
                int num2 = Integer.parseInt(et_num2.getText().toString());
                int result = num1 - num2;

                tv_result.setText(result + "");
            }
        });

        // 곱하기 버튼 눌렀을 때의 이벤트 처리
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(et_num1.getText().toString());
                int num2 = Integer.parseInt(et_num2.getText().toString());
                int result = num1 * num2;

                tv_result.setText(result + "");
            }
        });

        // 나누기 버튼 눌렀을 때의 이벤트 처리
        btn_dvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(et_num1.getText().toString());
                int num2 = Integer.parseInt(et_num2.getText().toString());

                // 0을 나눌 수 없기 때문에 만약 num1 혹은 num2가 0이면 오류 메시지 출력
                if(num1 == 0 || num2 == 0) {
                    tv_result.setText("divide 0 오류!!!!");
                    Toast.makeText(getApplicationContext(),"EditText의 내용에 0이 입력되었습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    int result = num1 / num2;
                    tv_result.setText(result + "");
                }
            }
        });
    }
}