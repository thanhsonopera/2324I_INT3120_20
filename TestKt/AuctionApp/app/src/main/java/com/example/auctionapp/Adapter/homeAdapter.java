package com.example.auctionapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionapp.Model.BsCarHome;
import com.example.auctionapp.databinding.ItemRvHomeBinding;

import java.util.ArrayList;

public class homeAdapter extends RecyclerView.Adapter<homeAdapter.MyViewHolder> {
    ArrayList<BsCarHome> arrayList;
    public homeAdapter(ArrayList<BsCarHome> arrayList) {
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRvHomeBinding binding = ItemRvHomeBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BsCarHome item = arrayList.get(position);
        holder.itemView.STT.setText(String.valueOf(position));
        holder.itemView.favourite.setOnClickListener(view -> {

        });

        holder.itemView.countFavourite.setText(String.valueOf(item.getCountFavourite()));
        holder.itemView.BS.setText(item.getNameBs());
        holder.itemView.typeCar.setText(item.getTypeCar());
        holder.itemView.province.setText(item.getProvince());
        holder.itemView.register.setOnClickListener(view -> {

        });
    }
    public int getItemCount() {
        return arrayList != null ? arrayList.size() : 0;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemRvHomeBinding itemView;

        public MyViewHolder(@NonNull ItemRvHomeBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
