package com.example.grishany.yandex_mobilization2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class FullScreenActivity extends AppCompatActivity implements View.OnClickListener {
 public static final String EXTRA_MESSAGE="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen);
        Intent intent =getIntent();
        String str= intent.getStringExtra(EXTRA_MESSAGE);
      TextView txt = (TextView) findViewById(R.id.text23);
        txt.setText(str);
        ImageView image1 = (ImageView) findViewById(R.id.image1);
        image1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
       startActivity(intent);

    }
}
