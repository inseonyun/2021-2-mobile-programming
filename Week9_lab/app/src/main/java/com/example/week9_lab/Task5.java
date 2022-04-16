package com.example.week9_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Task5 extends AppCompatActivity {
    // 위젯 변수 선언
    EditText et_url;
    Button btn_go, btn_back, btn_http, btn_hallym, btn_naver, btn_fav;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.web);

        // 위젯 id 연결
        et_url = (EditText) findViewById(R.id.et_url);

        btn_go = (Button) findViewById(R.id.btn_go);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_http = (Button) findViewById(R.id.btn_http);
        btn_hallym = (Button) findViewById(R.id.btn_hallym);
        btn_naver = (Button) findViewById(R.id.btn_naver);
        btn_fav = (Button) findViewById(R.id.btn_fav);

        web = (WebView) findViewById(R.id.webView);

        // CookWebViewClient()를 생성하여 웹뷰에 대입
        web.setWebViewClient(new CookWebViewClient());

        // WebSettings 클래스를 이용하여
        WebSettings webSet = web.getSettings();

        // 줌 버튼 컨트롤 화면이 보이게 함
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);

        // btn_go 눌렀을 때의 이벤트 처리
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl(et_url.getText().toString());
            }
        });

        // btn_back 눌렀을 때의 이벤트 처리
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });

        // btn_http 눌렀을 때의 이벤트 처리
        btn_http.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_url.setText("https://");
            }
        });

        // btn_hallym 눌렀을 때의 이벤트 처리
        btn_hallym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl("https://www.hallym.ac.kr");
            }
        });

        // btn_naver 눌렀을 때의 이벤트 처리
        btn_naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl("https://m.naver.com");
            }
        });

        // btn_fav 눌렀을 때의 이벤트 처리
        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl("https://m.youtube.com");
            }
        });

    }
    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}