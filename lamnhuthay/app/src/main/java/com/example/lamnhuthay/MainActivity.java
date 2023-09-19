package com.example.lamnhuthay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
//        MenuItem menuItem = menu.findItem(R.id.);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item2) {
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();

        }
        else if (id == R.id.item3) {
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.item4)  {
            Toast.makeText(MainActivity.this, "an cai lon", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "an cai lon2", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}