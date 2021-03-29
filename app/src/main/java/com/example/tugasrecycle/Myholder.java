package com.example.tugasrecycle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView mIcon;
    TextView mJudul, mdes;
    ItemClikListener itemClikListener;

    Myholder(@NonNull View itemView) {
        super(itemView);
        this.mIcon = itemView.findViewById(R.id.icon);
        this.mJudul = itemView.findViewById(R.id.judul);
        this.mdes = itemView.findViewById(R.id.deskripsi);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        this.itemClikListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClikListener(ItemClikListener ic){
        this.itemClikListener = ic;
    }
}