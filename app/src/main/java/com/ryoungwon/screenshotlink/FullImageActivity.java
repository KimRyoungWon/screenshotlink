package com.ryoungwon.screenshotlink;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FullImageActivity extends Activity implements android.view.View.OnClickListener{

    EditText et_url;
    String sfname ="link";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);


        Button viewButton=(Button) findViewById(R.id.click);
        viewButton.setOnClickListener(this);
        Intent i = getIntent();

        et_url = (EditText) findViewById(R.id.linktext);
        SharedPreferences sf = getSharedPreferences(sfname,0);
        String str = sf.getString("link","");
        et_url.setText(str);


        //이미지 크게
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }


    @Override  //웹 이동
    public void onClick(View v) {
        EditText et_url = (EditText) findViewById(R.id.linktext);
        String str_url = et_url.getText().toString();
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(str_url);
        webView.loadUrl(str_url);

    }
    @Override //링크 저장
    protected void onStop() {
        super.onStop();
        SharedPreferences sf = getSharedPreferences(sfname, 0);
        SharedPreferences.Editor editor = sf.edit();
        String str = et_url.getText().toString(); // 사용자가 입력한 값
        editor.putString("link", str);
        editor.putString("xx", "xx");
        editor.commit();
    }



}
