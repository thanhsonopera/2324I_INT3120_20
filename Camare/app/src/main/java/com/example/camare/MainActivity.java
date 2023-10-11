package com.example.camare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    
    private static final int CAMERA_REQUEST = 888;
    private static final int VIDEO_REQUEST = 999;
    ImageView imageView;
    Camera camera;
    Button photoButton;
    EditText editText;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.imageView1);
        photoButton = (Button) this.findViewById(R.id.button1);
        editText = (EditText) this.findViewById(R.id.editText1);
        photo();

        camera = Camera.open();  // Open the camera
        camera.startPreview();          // Start the camera preview

        Camera.PictureCallback pictureCallback = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Bitmap photoBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

                imageView.setImageBitmap(photoBitmap);
            }
        };

//        camera.takePicture(null, null, pictureCallback);
    }

    private void photo() {

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Integer.parseInt(editText.getText().toString()) == 1) {
                    //Xử lý cho ảnh nhận vào dữ liệu nhỏ
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
                else {
                    File videoFile = new File(getExternalFilesDir(null), "myvideo.mp4");
                    Uri videoUri = FileProvider.getUriForFile(getApplicationContext(), "com.example.camare.fileprovider", videoFile);

                    Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                    videoIntent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
                    videoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                    videoIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 60);
                    videoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivityForResult(videoIntent, VIDEO_REQUEST);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
        if (requestCode == VIDEO_REQUEST) {
            Uri videoUri = data.getData();

//            // Sử dụng Glide để hiển thị video trong ImageView
            Glide.with(this)
                    .load(videoUri)
                    .into(imageView);
            Bitmap thumbnail = ThumbnailUtils.createVideoThumbnail(videoUri.getPath(), MediaStore.Video.Thumbnails.MINI_KIND);
            imageView.setImageBitmap(thumbnail);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        camera.release();
    }
}