package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonLinearLayout, buttonRelativeLayout, buttonAbsoluteLayouts, buttonTableLayouts, buttonConstraintLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLinearLayout = findViewById(R.id.LinearLayouts);
        buttonRelativeLayout = findViewById(R.id.RelativeLayouts);
        buttonAbsoluteLayouts = findViewById(R.id.AbsoluteLayouts);
        buttonTableLayouts = findViewById(R.id.TableLayouts);
        buttonConstraintLayout = findViewById(R.id.ConstraintLayout);
        buttonLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, LinearLayouts.class);
                startActivity(myintent);
            }
        });

        buttonRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent1 = new Intent(MainActivity.this, RelativeLayouts.class);
                startActivity(myintent1);
            }
        });
        buttonAbsoluteLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent1 = new Intent(MainActivity.this, AbsoluteLayouts.class);
                startActivity(myintent1);
            }
        });
        buttonTableLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent1 = new Intent(MainActivity.this, TableLayouts.class);
                startActivity(myintent1);
            }
        });
        buttonConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent1 = new Intent(MainActivity.this, ConstraintLayout.class);
                startActivity(myintent1);
            }
        });
    }


}