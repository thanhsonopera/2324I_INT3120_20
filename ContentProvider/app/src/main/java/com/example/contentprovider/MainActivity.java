package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACT_PERMISSION = 1001;
    AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }
    public void solveContact() {
        Intent intent = new Intent(MainActivity.this, Contact.class);
        intent.setClassName("com.example.contentprovider", "com.example.contentprovider.Contact");
        startActivity(intent);
    }
    public void addEvent() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solveContact();
            }
        });
    }
    public void addControl() {
        btn = findViewById(R.id.btn);
    }
}