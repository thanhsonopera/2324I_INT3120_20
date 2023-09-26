package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class Setting extends AppCompatActivity {

    AppCompatSpinner spinner;
    List<String> languageList = Arrays.asList("en", "vn", "fr");
    String defaultLanguage;
    String selectedLanguage;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.setting_title));
        spinner = findViewById(R.id.spinner_language);
        save = findViewById(R.id.Save);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languageList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // Ngôn ngữ mặc định
        SharedPreferences sharedPreferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
        defaultLanguage = sharedPreferences.getString("Language", "");
        //
        int defaultLanguageIndex = languageList.indexOf(defaultLanguage);
        spinner.setSelection(defaultLanguageIndex);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLanguage = languageList.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (defaultLanguage != selectedLanguage) {
                    putLanguage(selectedLanguage);
                    restartApp();
                }
            }
        });
    }
    //Xử lý sự kiện của ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void putLanguage(String language) {
        SharedPreferences sharedPreferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Language", language);
        editor.apply();

    }
    private void restartApp() {
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("ChangeLanguage", "L1");
            startActivity(intent);
            finish();
        }

    }
}