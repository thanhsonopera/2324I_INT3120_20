package com.example.week2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorStateList myColorStateList = new ColorStateList(
                new int[][]{
                        new int[]{getResources().getColor(R.color.colorAccent)}
                },
                new int[]{getResources().getColor(R.color.colorAccent)}
        );
        radioButton = findViewById(R.id.Pepperoni);
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