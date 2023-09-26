package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class About extends AppCompatActivity {

    Button upload, change, update;
    AppCompatEditText edit_form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.about_title));

        upload = findViewById(R.id.upload);
        change = findViewById(R.id.change);
        update = findViewById(R.id.update);

        edit_form = findViewById(R.id.edit_form);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    StringBuilder stringBuilder = Upload();
                    if (stringBuilder != null) {
                        edit_form.setText(stringBuilder.toString());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEditable = edit_form.isEnabled();
                edit_form.setEnabled(!isEditable);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Save(edit_form.getText().toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void Save(String string) throws IOException {
        String fileName = "hello.txt";

        FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);//Ghi tệp
        fileOutputStream.write(string.getBytes());
        fileOutputStream.close();
        String filePath = getFilesDir().toString();

        String message = String.format("Stored data into %s", filePath);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private StringBuilder Upload() throws IOException {

        String fileName = "hello.txt";
        File file = new File(getFilesDir(), fileName);

        if (file.exists()) {
            FileInputStream fileInputStream = this.openFileInput("hello.txt"); //Đọc tệp
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream); //Đọc theo byte  theo (encoding)
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //Nhanh hơn
            StringBuilder stringBuilder = new StringBuilder(); //Đọc string
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }
            fileInputStream.close();
            return stringBuilder;
        }
        else return null;
    }

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
}