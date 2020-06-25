package com.ryoungwon.screenshotlink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {

    public void MyClick1 (View v) //home 버튼
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    public void MyClick2 (View v) //link 버튼
    {
        Intent i2 = new Intent(this, ThirdActivity.class);
        startActivity(i2);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView1);


        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {


                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);

                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}
