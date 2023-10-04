package com.example.backgroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.bound_start);
        btnStop = findViewById(R.id.bound_stop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStart();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStop();
            }
        });
    }
    public void onClickStart() {
        Intent intent = new Intent(this, BackgroundService.class);
        startService(intent);
    }
    public void onClickStop() {
        Intent intent = new Intent(this, BackgroundService.class);
        stopService(intent);
    }
}