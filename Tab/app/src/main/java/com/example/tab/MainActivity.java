package com.example.tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AlignmentSpan;
import android.text.style.ImageSpan;
import android.text.style.MetricAffectingSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec;
        spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("1-Clock");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("2-Login");
        tabs.addTab(spec);
//        tabs.setCurrentTab(0);
        spec = tabs.newTabSpec("tag3");
        spec.setContent(R.id.tab2);
//        spec.setIndicator("3-HI", getResources().getDrawable(R.drawable.ic_menu_info_details_foreground));
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_menu_info_details_foreground);
        spec.setIndicator(createTabIndicator("3-HELLO", icon, 18));
        tabs.addTab(spec);
        Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText txtPerson = (EditText) findViewById(R.id.txtPerson);
                String theUser = txtPerson.getText().toString();
                txtPerson.setText("Hola " + theUser);
            }
        });
    }
    private CharSequence createTabIndicator(String text, Drawable icon, int desiredIconSize) {
        // Thu nhỏ kích thước biểu tượng
        Bitmap bitmap = ((BitmapDrawable) icon).getBitmap();
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, desiredIconSize, desiredIconSize, false);
        Drawable resizedIcon = new BitmapDrawable(getResources(), resizedBitmap);

        // Tạo chuỗi Spannable
        SpannableStringBuilder sb = new SpannableStringBuilder(text + "     ");
        AlignmentSpan alignmentSpan = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);


        resizedIcon.setBounds(0, 0, resizedIcon.getIntrinsicWidth(), resizedIcon.getIntrinsicHeight());

        ImageSpan imageSpan = new ImageSpan(resizedIcon, ImageSpan.ALIGN_CENTER);
        sb.setSpan(imageSpan, 5, 7, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        sb.setSpan(alignmentSpan, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return sb;
    }
}





