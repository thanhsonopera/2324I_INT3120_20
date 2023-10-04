package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean hasNotificationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.FOREGROUND_SERVICE) == PackageManager.PERMISSION_GRANTED;
        Log.d("TAG", "onCreate: " + hasNotificationPermission);
        editText = findViewById(R.id.input);
    }

    public void startService(View v) {
        String input = editText.getText().toString();
        Intent serviceIntent = new Intent(this, ExampleService.class);
        serviceIntent.putExtra("inputExtra", input);
//        startService(serviceIntent);
        ContextCompat.startForegroundService(this, serviceIntent);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "run: ");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ContextCompat.startForegroundService(getApplicationContext(), serviceIntent);
                } else {
                    startService(serviceIntent);
                }
            }
        }, 10000);
    }

    public void stopService(View v) {
        Intent serviceIntent = new Intent(this, ExampleService.class);
        stopService(serviceIntent);
    }
}