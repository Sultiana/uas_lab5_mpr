package com.example.isumut_wisatasumaterautara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    private CardView button, button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (CardView) findViewById(R.id.keWisataAlam);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });


        button1 = (CardView) findViewById(R.id.keWisataBuatan);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });


        button2 = (CardView) findViewById(R.id.keWisataKuliner);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        button3 = (CardView) findViewById(R.id.kePusatPerbelanjaan);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

    }


    public void openActivity(){
        Intent intent = new Intent(this, Daftar.class);
        startActivity(intent);
    }

    public void openActivity1(){
        Intent intent = new Intent(this, Daftar.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Daftar.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, Daftar.class);
        startActivity(intent);
    }

}
