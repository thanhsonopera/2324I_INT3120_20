package com.example.telephony;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

public class PhoneStateChangedReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public void onReceive(Context context, Intent intent) {
//        String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
//        if (phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
//            String phoneNumber =
//                    intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
//            Toast.makeText(context, "Incoming Call From: " + phoneNumber,
//                    Toast.LENGTH_LONG).show();
//        }

//        TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        telephony.listen(new PhoneStateListener() {
//            @Override
//            public void onCallStateChanged(int state, String incomingNumber) {
//                super.onCallStateChanged(state, incomingNumber);
//                Toast.makeText(context, "Incoming Call From: " + incomingNumber,
//                    Toast.LENGTH_LONG).show();
//            }
//        }, PhoneStateListener.LISTEN_CALL_STATE);

//
//        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        telephonyManager.listen(new PhoneStateListener() {
//            private boolean isRinging = false;
//
//            @Override
//            public void onCallStateChanged(int state, String incomingNumber) {
//                super.onCallStateChanged(state, incomingNumber);
//
//                switch (state) {
//                    case TelephonyManager.CALL_STATE_RINGING:
//                        if (!isRinging) {
//                            Toast.makeText(context.getApplicationContext(), "Incoming Call From: " + incomingNumber,
//                                    Toast.LENGTH_SHORT).show();
//                            isRinging = true;
//                        }
//                        break;
//                    case TelephonyManager.CALL_STATE_IDLE:
//                    case TelephonyManager.CALL_STATE_OFFHOOK:
//                        isRinging = false;
//                        break;
//                }
//            }
//        }, PhoneStateListener.LISTEN_CALL_STATE);
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
        TelephonyCallback.CallStateListener callStateListener = new TelephonyCallback.CallStateListener() {
            @Override
            public void onCallStateChanged(int state) {
                switch (state) {
                    case TelephonyManager.CALL_STATE_IDLE:
                        // Handle idle state (no ongoing calls)
                        break;

                    case TelephonyManager.CALL_STATE_RINGING:
                        Toast.makeText(context.getApplicationContext(), "Incoming Call From: "  ,
                                    Toast.LENGTH_SHORT).show();
                        break;

                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        // Handle ongoing call state
                        break;
                }
            }
        };

        telephonyManager.registerTelephonyCallback(ContextCompat.getMainExecutor(context), (TelephonyCallback) callStateListener);
    }
}
