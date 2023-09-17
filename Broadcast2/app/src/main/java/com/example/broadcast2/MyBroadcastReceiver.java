package com.example.broadcast2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private TextView textView;

    public MyBroadcastReceiver(TextView textView) {
        this.textView = textView;
    }
    public void setTextView(String message) {
        this.textView.setText(message);
    }
    public String getTextView() {
        Log.d("hoho", "getTextView: " + textView.getText().toString());
        return this.textView.toString();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        Log.d("hhhh", "onReceive: " + message);
        setTextView(message);
    }
}
