package com.example.implicitintent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class YourAdapter extends RecyclerView.Adapter<YourAdapter.YourViewHolder> {
    private List<ImageView> imageViews;

    public YourAdapter(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @NonNull
    @Override
    public YourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view, parent, false);
        return new YourViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull YourViewHolder holder, int position) {
        ImageView imageView = imageViews.get(position);
        holder.bind(imageView);
    }

    @Override
    public int getItemCount() {
        return imageViews.size();
    }

    public void addItem(ImageView imageView) {
        imageViews.add(imageView);
    }

    public class YourViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public YourViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(ImageView imageView) {
                this.imageView.setImageDrawable(imageView.getDrawable());
        }
    }
}