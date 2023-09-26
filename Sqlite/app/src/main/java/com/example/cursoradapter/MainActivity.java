package com.example.cursoradapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo DatabaseHelper và SQLiteDatabase
        dbHelper = new DatabaseHelper(this);

        dbHelper.Insert("ddd", "ddd");
        dbHelper.Insert("ddd", "ded");
        dbHelper.Insert("hih", "dd");
//        dbHelper.Delete();
        // Thực hiện truy vấn SQLite

        Cursor cursor = dbHelper.getCursor();

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("title"));
                Log.d("1", "onCreate: " + name);

            } while (cursor.moveToNext());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}