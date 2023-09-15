package com.example.intent_explicit;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 1;
    Button buttonSendMessage;
    EditText exitTextFullName;
    TextView textFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonSendMessage = findViewById(R.id.button_sendMessage);
        exitTextFullName =  findViewById(R.id.editText_fullName);
        textFeedback = findViewById(R.id.textView_feedback);

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }
    public void sendMessage() {
        String fullName = exitTextFullName.getText().toString();
        String message = "Hello, Please say hello me!";
        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("fullname", fullName);
        intent.putExtra("message", message);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode Phân biệt các Activity con
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE) {
            String feedback = data.getStringExtra("feedback");
            textFeedback.setText(feedback);
        }
        else {
            textFeedback.setText("!?");
        }
    }
}