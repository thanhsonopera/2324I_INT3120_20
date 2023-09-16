package com.example.implicitintent;

import android.os.Parcelable;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private Parcelable[] imageUri;

    // Phương thức để thiết lập URL ảnh
    public void setImageUrl(Parcelable[] uri) {
        this.imageUri = uri;
    }

    // Phương thức để lấy URL ảnh
    public Parcelable[] getImageUrl() {
        return imageUri;
    }
}