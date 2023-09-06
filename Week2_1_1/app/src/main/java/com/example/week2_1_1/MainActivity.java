package com.example.week2_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton = findViewById(R.id.Pepperoni);


        ColorStateList myColorStateList = new ColorStateList(
                new int[][]{
                        new int[]{getResources().getColor(R.color.colorAccent)}
                },
                new int[]{getResources().getColor(R.color.colorAccent)}
        );

        radioButton.setButtonTintList(myColorStateList);
        radioButton = findViewById(R.id.Mushroom);
        radioButton.setButtonTintList(myColorStateList);
        radioButton = findViewById(R.id.Veggies);
        radioButton.setButtonTintList(myColorStateList);
        radioButton = findViewById(R.id.Square);
        radioButton.setButtonTintList(myColorStateList);
        radioButton = findViewById(R.id.Round);
        radioButton.setButtonTintList(myColorStateList);
        radioButton = findViewById(R.id.Cheese);
        radioButton.setButtonTintList(myColorStateList);
        radioButton = findViewById(R.id.Cheese_2);
        radioButton.setButtonTintList(myColorStateList);
        radioButton = findViewById(R.id.None);
        radioButton.setButtonTintList(myColorStateList);

    }
}