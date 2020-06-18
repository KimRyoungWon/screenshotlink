package com.ryoungwon.screenshotlink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends Activity {

    public void MyClick1 (View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
    public void MyClick2 (View v)
    {
        Intent i2 = new Intent(this, SecondActivity.class);
        startActivity(i2);

    }
    public void MyClick3 (View v)
    {
        Intent i3 = new Intent(this, ThirdActivity.class);
        startActivity(i3);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdpage);
    }
}
