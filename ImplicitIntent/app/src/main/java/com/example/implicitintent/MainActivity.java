package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    RecyclerView recyclerView;
    YourAdapter yourAdapter;
    List<ImageView> imageViews = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

//                Intent intent = new Intent( Intent.ACTION_SENDTO,
//                        Uri.parse("sms:5551234"));
//
//                intent.putExtra("sms_body" , "are we playing golf next Saturday?");

                //"text/plain" cho văn bản thuần, "image/jpeg" cho hình ảnh JPEG, "audio/mp3"
//                Intent intent = new Intent( Intent.ACTION_SEND);
//                intent.setType("audio/mp3");
//                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
//                startActivity(intent);
                //
                String videoId = "";
                Intent intent = new Intent(Intent.ACTION_MAIN);
                //ACTION_MAIN ? ACTION_VIEW, Uri.parse() -> kênh muốn mở
//                String packageName = "com.google.android.youtube";
//                PackageManager packageManager = getPackageManager();
                intent.setPackage("com.google.android.youtube");
                //mở youtube
//                try {
//                    packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
//                    Log.d("zdz", ":gud ");
//                } catch (PackageManager.NameNotFoundException e) {
//                    Log.d("ddd", ":gud ");
//                }
//                intent.setPackage("com.google.android.youtube");
                try {
                    startActivity(intent);

                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();

                }

            }

        });
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        yourAdapter = new YourAdapter(imageViews);
        recyclerView.setAdapter(yourAdapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
        final CustomImageView[] imageView = {null};
        if (imageUri != null) {
            imageView[0] = new CustomImageView(this);
            // Sử dụng thư viện Glide để hiển thị ảnh từ Uri lên ImageView
            // Ờ phải set  <intent-filter> <action android:name="android.intent.action.SEND" /> và  <data android:mimeType="image/*" />

//            Glide.with(this)
//                    .load(imageUri)
//                    .into(imageView);
            String imageUriString = imageUri.toString();
            LoadImageTask loadImageTask = new LoadImageTask(imageView[0]);
            loadImageTask.execute(imageUriString);

            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (loadImageTask.getImageView().getDrawable() != null) {
                        Log.d("meomoe", "onNewIntent: " + loadImageTask.getImageView().getDrawable());
                        imageView[0] = loadImageTask.getImageView();
                        yourAdapter.addItem(imageView[0]);
                        yourAdapter.notifyDataSetChanged();
                        Log.d("hoho", "onNewIntent: " + yourAdapter.getItemCount());
                    }
                }
            };
            handler.postDelayed(runnable, 2000);

        }

    }
}