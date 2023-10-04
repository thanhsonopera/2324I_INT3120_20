package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    MusicBound musicBound;
    boolean isServiceConnected;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicBound.MyBinder myBinder = (MusicBound.MyBinder) service;
            Log.e("3", "onServiceConnected: " );
            musicBound = myBinder.getMusicBound();
            musicBound.startMusic();
            isServiceConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceConnected = false;
        }
    };
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
        Intent intent = new Intent(this, MusicBound.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        Log.e("4", "" + isServiceConnected );
    }
    public void onClickStop() {
        if (isServiceConnected) {
            unbindService(serviceConnection);
            isServiceConnected = false;
        }
    }
}