package com.example.tugasrecycle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    TextView mJuduldt, mdesdt;
    ImageView mIcondt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        ActionBar actionBar = getSupportActionBar();

        mJuduldt =  findViewById(R.id.juduldata);
        mdesdt = findViewById(R.id.deskripsidata);
        mIcondt = findViewById(R.id.icondata);

        Intent intent = getIntent();
        String mJudul = intent.getStringExtra("iJudul");
        String mDes = intent.getStringExtra("iDes");

        byte[] bytes = getIntent().getByteArrayExtra("iMage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        actionBar.setTitle(mJudul);
        mJuduldt.setText(mJudul);
        mdesdt.setText(mDes);
        mIcondt.setImageBitmap(bitmap);
    }
}
