package com.example.telephony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.Manifest;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    private PhoneStateChangedReceiver phoneStateChangedReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        phoneStateChangedReceiver = new PhoneStateChangedReceiver();

        IntentFilter intentFilter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);

        // Đăng ký BroadcastReceiver với IntentFilter
        registerReceiver(phoneStateChangedReceiver, intentFilter);

        //Get the instance of TelephonyManager
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        //Calling the methods of TelephonyManager the returns the information
        String IMEINumber = "";
        String subscriberID = "";
        String networkCountryISO = tm.getNetworkCountryIso();
        String SIMCountryISO = tm.getSimCountryIso();
        String softwareVersion = "";
        String voiceMailNumber = "";
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//
//            try {
//                softwareVersion = tm.getDeviceSoftwareVersion();
//            } catch (SecurityException e) {
//                // Handle SecurityException
//                e.printStackTrace();
//                // Optionally, show an error message to the user
//            }

            // Get voice mail number

//            try {
//                voiceMailNumber = tm.getVoiceMailNumber();
//            } catch (SecurityException e) {
//                // Handle SecurityException
//                e.printStackTrace();
//                // Optionally, show an error message to the user
//            }
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 0);
            //Get the phone type
            String strphoneType = "";

            int phoneType = tm.getPhoneType();

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                IMEINumber = tm.getImei();
//            } else {
//                // For older devices (pre-Android 8.0), handle the IMEI retrieval accordingly
//                IMEINumber = tm.getDeviceId();
//            }
            switch (phoneType) {
                case (TelephonyManager.PHONE_TYPE_CDMA):
                    strphoneType = "CDMA";
                    break;
                case (TelephonyManager.PHONE_TYPE_GSM):
                    strphoneType = "GSM";
                    break;
                case (TelephonyManager.PHONE_TYPE_NONE):
                    strphoneType = "NONE";
                    break;
            }

            //getting information if phone is in roaming
            boolean isRoaming = tm.isNetworkRoaming();

            String info = "Phone Details:\n";
            info += "\n IMEI Number:" + IMEINumber;
            info += "\n SubscriberID:" + subscriberID;

            info += "\n Network Country ISO:" + networkCountryISO;
            info += "\n SIM Country ISO:" + SIMCountryISO;
            info += "\n Software Version:" + softwareVersion;
            info += "\n Voice Mail Number:" + voiceMailNumber;
            info += "\n Phone Network Type:" + strphoneType;
            info += "\n In Roaming :" + isRoaming;

            textView1.setText(info);//displaying the information in the textView
        }
    }
}