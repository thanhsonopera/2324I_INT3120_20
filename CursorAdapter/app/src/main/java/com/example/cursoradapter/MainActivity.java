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
    private SQLiteDatabase database;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo DatabaseHelper và SQLiteDatabase
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getReadableDatabase();
        dbHelper.insertData("Mai Hanh");
        dbHelper.insertData("Thanh Son");
        dbHelper.insertData("Mai Linh");
        dbHelper.insertData("Mai Thuy");

        // Thực hiện truy vấn SQLite
        Cursor cursor = dbHelper.getAllData();
        if (cursor.moveToFirst()) {
            do {
                // Lấy giá trị từ cột "name"
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));

                // In giá trị
                System.out.println(name);
            } while (cursor.moveToNext());
        }


        String[] columns = {"name"};

        // ID của các view trong layout item_list.xml
//        int[] to = {R.id.text_name, R.id.text_name1, R.id.text_name2};

        // Tạo Adapter và gán cho ListView
        if (cursor != null) {
            Log.i("MainActivity", "hehhehe " + MainActivity.this);
            CustomCursorAdapter adapter = new CustomCursorAdapter(MainActivity.this, cursor);
            ListView listView = findViewById(R.id.list_view);
//            listView.setVerticalScrollBarEnabled(true);
//            listView.setScrollbarStyle(style);
            listView.setAdapter(adapter);
//            int itemCount = adapter.getCount();
//            for (int i = 0; i < itemCount; i++) {
//                Object item = adapter.getItem(i);
//                String itemString = item.toString();
//                System.out.println("Item " + i + ": " + itemString);
//            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Đóng cursor và database khi không cần thiết nữa
        if (adapter != null) {
            adapter.changeCursor(null);
        }
        if (database != null) {
            database.close();
        }
    }
}