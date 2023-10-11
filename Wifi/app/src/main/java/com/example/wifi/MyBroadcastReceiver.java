package com.example.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action != null && action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED:
                    Toast.makeText(context.getApplicationContext(), "WIFI_STATE_DISABLED", Toast.LENGTH_SHORT).show();
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    Toast.makeText(context.getApplicationContext(), "WIFI_STATE_ENABLED", Toast.LENGTH_SHORT).show();
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                default:
                    Toast.makeText(context.getApplicationContext(), "WIFI_STATE_UNKNOWN", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
