package com.example.externalstorage;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);

        StorageUtils storageUtils = new StorageUtils();
        boolean isWrite = storageUtils.isExternalStorageWritable();
        File albumDir = storageUtils.getAlbumStorageDir("MyAlbum");
        
        if (isWrite) {
            int drawableId = getResources().getIdentifier("sky", "drawable", getPackageName());

            // Kiểm tra xem tệp ảnh có tồn tại không
            if (drawableId != 0) {
                // Tạo một đối tượng Drawable từ ID
                Drawable drawable = getResources().getDrawable(drawableId);

                // Chuyển đổi Drawable thành Bitmap
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                // Tạo đường dẫn đến thư mục đích trên bộ nhớ ngoài
                File destinationFile = new File(albumDir, "my_image.jpg");

                // Ghi Bitmap vào tệp đích
                try {
                    FileOutputStream outputStream = new FileOutputStream(destinationFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    outputStream.close();
                    Log.d("MainActivity", "File copied successfully.");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (destinationFile.exists()) {
                    Log.d("MainActivity", "Image exists: " + destinationFile.getAbsolutePath());
                    Picasso.get().load(destinationFile).into(imageView);
                }
                else {
                    Log.e("MainActivity", "Image does not exist.");
                }
            } else {
                Log.e("MainActivity", "Drawable not found.");
            }

            boolean isReadable = storageUtils.isExternalStorageReadable();
            Log.d("MainActivity", "External storage is readable: " + isReadable);

            Log.d("MainActivity", "Album directory: " + albumDir.getAbsolutePath());

            storageUtils.deleteExternalStoragePrivateFile(this);
        }
    }
}