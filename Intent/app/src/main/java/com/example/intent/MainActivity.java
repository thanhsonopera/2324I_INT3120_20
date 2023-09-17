package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//        int userId = 123;
//        String username = "John Doe";
//        boolean isActive = true;
//        intent.putExtra("userId", userId);
//        intent.putExtra("username", username);
//        intent.putExtra("isActive", isActive);
//        startActivity(intent);
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);


        Intent intent1 = new Intent();
        //các loại hành động
        intent1.setAction(Intent.ACTION_SEND);
        intent1.setType("text/plain");
        //key là string hoặc constant dưới là constant và value
        intent1.putExtra(Intent.EXTRA_TEXT, "Hello, this is the message");
        // xác định tính chất intent
        intent1.addCategory(Intent.CATEGORY_BROWSABLE);
        // xác định class intent gửi tới
        intent1.setComponent(new ComponentName("com.example.intent", "com.example.intent.MainActivity2"));
        startActivity(intent1);
    }
}