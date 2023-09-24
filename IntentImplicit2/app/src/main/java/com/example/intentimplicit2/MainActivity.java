package com.example.intentimplicit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent myIntent = new Intent();
//
//        myIntent.setType("image/pictures/*"); myIntent.setAction(Intent.ACTION_GET_CONTENT);
//
//        startActivity(myIntent);

//        String myData = "content://contacts/people";
//
//        Intent myActivity2 = new Intent(Intent.ACTION_VIEW,
//                Uri.parse(myData));
//
//        startActivity(myActivity2);
        //chuyển giao diện cuộc gọi người dùng thứ 8 trong danh sách nếu không có hiển thị không tồn tại
//        String myData = "content://contacts/people/4";
//
//        Intent myActivity2 = new Intent(Intent.ACTION_VIEW,
//                Uri.parse(myData));
//
//        startActivity(myActivity2);
        //->

//        Uri contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, 1);
//        Intent myActivity2 = new Intent(Intent.ACTION_EDIT, contactUri);
//        PackageManager packageManager = getPackageManager();
//        List<ResolveInfo> activities = packageManager.queryIntentActivities(myActivity2, 0);
//        if (!activities.isEmpty()) {
//            Log.d("hihi", "onCreate: ");
//        } else {
//            Log.d("haha", "onCreate: ");
//        }

//        startActivity(myActivity2);


//        String geoCode =
//                "geo:0,0?q=1860+east+18th+street+cleveland+oh";
//
//        Intent intent = new Intent(Intent.ACTION_VIEW,
//                Uri.parse(geoCode));
//
//        startActivity(intent);

//        String geoCode =
//                "geo:41.5020952,-81.6789717";
//
//        Intent intent = new Intent(Intent.ACTION_VIEW,
//                Uri.parse(geoCode));
//
//        startActivity(intent);
//
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setPackage("com.google.android.apps.youtube.music");
        startActivity(intent);

    }
}