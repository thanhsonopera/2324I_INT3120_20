package com.example.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    TextView selection;
//    String[] items = {"Android", "IPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"};
    ArrayList<String> items = new ArrayList<>();

    ArrayAdapter<String> aa;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        items.add("Android");
        items.add("IPhone");
        items.add("WindowsMobile");
        items.add("Blackberry");
        items.add("WebOS");
        items.add("Ubuntu");
        items.add("Windows7");
        items.add("Max OS X");


        selection = (TextView) findViewById(R.id.selection);
        GridView gv = (GridView) findViewById(R.id.grid);
        EditText editText = findViewById(R.id.editTextText);
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
//        aa.add("inputText");
        gv.setAdapter(aa);
        gv.setOnItemClickListener(this);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    String inputText = textView.getText().toString();
                    if (!TextUtils.isEmpty(inputText)) {
                        aa.add(inputText);
                        aa.notifyDataSetChanged();
                        editText.setText("");
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        selection.setText(items.get(position));
    }
}