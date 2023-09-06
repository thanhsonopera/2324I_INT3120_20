package com.example.week2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    NumberPicker numberPicker;
    ImageView imageView;
    Drawable drawable;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberPicker = findViewById(R.id.NumberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(999);
        textView = findViewById(R.id.textDonate);
        textView.setText(String.format("Total so Far: %s", numberPicker.getValue()));
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText(String.format("Total so Far: %s", i1));
            }
        });
        imageView = findViewById(R.id.emailIcon);
        drawable = getResources().getDrawable(R.drawable.email);
        imageView.setImageDrawable(drawable);
    }
}