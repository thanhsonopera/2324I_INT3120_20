package com.example.menu_demo;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity3 extends AppCompatActivity {
    RadioButton radioButton;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
        button = findViewById(R.id.Exit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}