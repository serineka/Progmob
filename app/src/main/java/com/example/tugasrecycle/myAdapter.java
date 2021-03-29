package com.example.tugasrecycle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<Myholder> {

    Context c;
    ArrayList<model>models;

    public myAdapter(Context c, ArrayList<model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_view1, null);

        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myholder holder, int i) {
        holder.mJudul.setText(models.get(i).getJudul());
        holder.mdes.setText(models.get(i).getDeskripsi());
        holder.mIcon.setImageResource(models.get(i).getImg());

        holder.setItemClikListener(new ItemClikListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gjudul = models.get(position).getJudul();
                String gdes =  models.get(position).getDeskripsi();
                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mIcon.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(c,DataActivity.class);
                intent.putExtra("iJudul", gjudul);
                intent.putExtra("iDes", gdes);
                intent.putExtra("iMage", bytes);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return models.size();
    }
}
