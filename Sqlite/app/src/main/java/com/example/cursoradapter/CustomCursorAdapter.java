package com.example.cursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {
    public CustomCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        Log.e("CustomCursorAdapter", "hhehehe" + context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Bind data to views in each row

        TextView textName = view.findViewById(R.id.text_name);
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        textName.setText(name);
        // Bind data to other columns in each row (if any)
    }
}