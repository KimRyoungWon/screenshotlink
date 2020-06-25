package com.ryoungwon.screenshotlink;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.ryoungwon.screenshotlink.R.id.spinner;

public class ThirdActivity extends Activity {

    ImageView SimpleView;
    Button btnPhoto;


    public void MyClick1 (View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    public void MyClick2 (View v)
    {
        Intent i2 = new Intent(this, ThirdActivity.class);
        startActivity(i2);

    }

    long now =System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String formatDate = sdfNow.format(date);

    TextView dateNow;
    EditText content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdpage);



        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //날짜표시
        dateNow = (TextView) findViewById(R.id.dateNow);
        dateNow.setText(formatDate);

        content = (EditText) findViewById(R.id.content);
        String contents = content.getText().toString();
        contents = contents.replace("'","''");

        SimpleView = (ImageView) findViewById(R.id.SimpleView);
        btnPhoto = (Button)findViewById(R.id.photobtn);
        btnPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent pi = new Intent();
                pi.setType("image/*");
                pi.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(pi,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    SimpleView.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }

    }


}












