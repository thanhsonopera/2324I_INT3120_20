package com.example.intent_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    Button buttonBack;
    TextView textViewMessage;

    String fullName, message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        buttonBack = findViewById(R.id.button_back);
        textViewMessage = findViewById(R.id.textView_message);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
        Intent intent = getIntent();
        fullName = intent.getStringExtra("fullname");
        message = intent.getStringExtra("message");
        textViewMessage.setText(message);
    }
    public void goBack() {
        onBackPressed();
    }
    @Override
    public void finish() {
        Intent data = new Intent();
        String feedback = "OK, Hello " + fullName + ". How are you?";
        data.putExtra("feedback", feedback);

        setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}