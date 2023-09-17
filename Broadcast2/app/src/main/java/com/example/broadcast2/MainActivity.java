package com.example.broadcast2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text);
        MyBroadcastReceiver receiver = new MyBroadcastReceiver(textView);
        IntentFilter intentFilter = new IntentFilter("com.example.ACTION_MY_EVENT");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter);

        Intent intent = new Intent("com.example.ACTION_MY_EVENT");
        intent.putExtra("message", "Hello, this is a broadcast event!");
      LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

        textView.setText(receiver.getTextView());
    }
}