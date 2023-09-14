package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    private boolean isContextMenuUpdated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        registerForContextMenu(button);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_item0);
        SpannableString spannableString = new SpannableString(menuItem.getTitle());

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(getResources().getColor(R.color.custom_title_color));

        spannableString.setSpan(colorSpan, 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        menuItem.setTitle(spannableString);
    }

    private void handleMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.menu_item6) {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.menu_item7) {
            Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show();
            // Handle menu_item2 selection
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item1) {
            Toast.makeText(this, "Upload", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_item2) {
            Toast.makeText(this, "Bookmark", Toast.LENGTH_SHORT).show();

            return true;
        } else if (item.getItemId() == R.id.menu_item3) {
//            isContextMenuUpdated = true;

            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();

            PopupMenu popupMenu = new PopupMenu(this, button);
            popupMenu.getMenuInflater().inflate(R.menu.child_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    handleMenuItemClick(menuItem);
                    return true;
                }
            });
            MenuItem menuItem = popupMenu.getMenu().findItem(R.id.menu_item5);
            SpannableString spannableString = new SpannableString(menuItem.getTitle());


            ForegroundColorSpan colorSpan = new ForegroundColorSpan(getResources().getColor(R.color.custom_title_color));

            spannableString.setSpan(colorSpan, 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            menuItem.setTitle(spannableString);

            
            popupMenu.show();

            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}