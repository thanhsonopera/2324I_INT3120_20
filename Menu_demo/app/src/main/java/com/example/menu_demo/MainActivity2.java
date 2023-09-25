package com.example.menu_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    NumberPicker numberPicker;
    ImageView imageView;
    Drawable drawable;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        numberPicker = findViewById(R.id.NumberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(999);
        textView = findViewById(R.id.textDonate);
        textView.setText(String.format("Total so Far: %s", numberPicker.getValue()));
        button = findViewById(R.id.button);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText(String.format("Total so Far: %s", i1));
            }
        });
        imageView = findViewById(R.id.emailIcon);
        drawable = getResources().getDrawable(R.drawable.email);
        imageView.setImageDrawable(drawable);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}