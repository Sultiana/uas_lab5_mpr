package com.example.isumut_wisatasumaterautara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        button = (ImageView) findViewById(R.id.kehome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        TextView nama = findViewById(R.id.nama);
        TextView jenis = findViewById(R.id.jenis);
        ImageView gambar = findViewById(R.id.gambar);
        TextView deskripsi = findViewById(R.id.deskripsi);

        Bundle bundle = getIntent().getExtras();

        String namaa = bundle.getString("nama");
        String jeniss = bundle.getString("jenis");
        String gambarr = bundle.getString("gambar");
        String deskripsii = bundle.getString("deskripsi");


        Glide.with(this).load(gambarr).into(gambar);
        jenis.setText(jeniss);
        nama.setText(namaa);
        deskripsi.setText(deskripsii);

    }

    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}