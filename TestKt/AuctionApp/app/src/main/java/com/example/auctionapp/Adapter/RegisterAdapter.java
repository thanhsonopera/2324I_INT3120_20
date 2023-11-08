package com.example.auctionapp.Adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionapp.Activity.AutionRoom;
import com.example.auctionapp.Model.BsCarHome;

import com.example.auctionapp.databinding.ItemRvRegisterUserBinding;

import java.util.ArrayList;

public class RegisterAdapter  extends RecyclerView.Adapter<RegisterAdapter.MyViewHolder> {
    ArrayList<BsCarHome> arrayList;
    Context context;
    public RegisterAdapter(Context context, ArrayList<BsCarHome> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRvRegisterUserBinding binding = ItemRvRegisterUserBinding.inflate(inflater, parent, false);
        return new RegisterAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RegisterAdapter.MyViewHolder holder, int position) {
        BsCarHome item = arrayList.get(position);
        String timeStart = item.getDateAuction() + " " + item.getTimeAuctionStart();
        String timeEnd = item.getDateAuction() + " " + item.getTimeAuctionEnd();
        holder.itemView.timeStart.setText(timeStart);
        holder.itemView.timeEnd.setText(timeEnd);
        holder.itemView.BS.setText(item.getNameBs());
        holder.itemView.typeCar.setText(item.getTypeCar());
        holder.itemView.province.setText(item.getProvince());
        //check show button
        holder.itemView.goAuctionRoom.setOnClickListener(v -> {
            Intent goAuctionRoom = new Intent(v.getContext(), AutionRoom.class);
            goAuctionRoom.putExtra("uIdBsCar", "2209"); //Test
            v.getContext().startActivity(goAuctionRoom);
        });
    }

    public int getItemCount() {
        return arrayList != null ? arrayList.size() : 0;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemRvRegisterUserBinding itemView;

        public MyViewHolder(@NonNull ItemRvRegisterUserBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
