package com.example.implicitintent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
public class LoadImageTask extends AsyncTask<String, Void, Drawable> {

    private CustomImageView imageView;

    public LoadImageTask(CustomImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Drawable doInBackground(String... params) {
        // Lấy đường dẫn ảnh từ tham số đầu vào
        String imageUri = params[0];

        try {
            // Thực hiện tải ảnh bằng Glide
            Context context = imageView.getContext();

            FutureTarget<Drawable> future = Glide.with(context)
                    .load(imageUri)
                    .submit();

            // Lấy Drawable từ FutureTarget
            return future.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Drawable result) {
        if (result != null) {
            // Gán Drawable vào ImageView
            imageView.setImageDrawable(result);


        }
    }
    public CustomImageView getImageView() {
        return this.imageView;
    }
}
