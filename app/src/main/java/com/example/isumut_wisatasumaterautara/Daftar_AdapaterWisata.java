package com.example.isumut_wisatasumaterautara;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Daftar_AdapaterWisata extends RecyclerView.Adapter<Daftar_AdapaterWisata.MovieHolder> {

    private Context context;
    private List<Daftar_wisata> wisataList;

    public Daftar_AdapaterWisata(Context context , List<Daftar_wisata> wisata){
        this.context = context;
        wisataList = wisata;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        Daftar_wisata daftar_wisata = wisataList.get(position);
        holder.nama.setText(daftar_wisata.getNama());
        holder.jenis.setText(daftar_wisata.getJenis());
        Glide.with(context).load(daftar_wisata.getGambar()).into(holder.gambar);
        holder.deskripsi.setText(daftar_wisata.getDeskripsi());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nama" , daftar_wisata.getNama());
                bundle.putString("jenis" , daftar_wisata.getJenis());
                bundle.putString("gambar" , daftar_wisata.getGambar());
                bundle.putString("deskripsi" , daftar_wisata.getDeskripsi());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{

        ImageView gambar;
        TextView nama , jenis , deskripsi;
        ConstraintLayout constraintLayout;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);


            nama = itemView.findViewById(R.id.nama);
            jenis = itemView.findViewById(R.id.jenis);
            gambar = itemView.findViewById(R.id.gambar);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}