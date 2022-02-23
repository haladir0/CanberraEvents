package com.example.listviewactionbarmenuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        int imageRes = extras.getInt("imageResource");
        String dates = extras.getString("dates");

        TextView tv = (TextView) findViewById(R.id.textViewLarge);
        tv.setText(title);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(imageRes);
        tv = (TextView) findViewById(R.id.textViewSmall);
        tv.setText(dates);

    }
}