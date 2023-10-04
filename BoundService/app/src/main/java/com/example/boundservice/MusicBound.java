package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class MusicBound extends Service {
    private MyBinder mBinder = new MyBinder();
    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("1", "onCreate: ");
    }
    public class MyBinder extends Binder {
        MusicBound getMusicBound() {
            return MusicBound.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public void startMusic() {
        Log.e("2", "startMusic: " );
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lemon);
        }
        mediaPlayer.start();
    }
}
