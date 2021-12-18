package com.example.isumut_wisatasumaterautara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Daftar extends AppCompatActivity {

    private ImageView button;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Daftar_wisata> wisataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);


        button = (ImageView) findViewById(R.id.kehome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });




        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        wisataList = new ArrayList<>();
        fetchMovies();


    }

    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void fetchMovies() {

        String url = "https://raw.githubusercontent.com/SalsaAlya/film/main/iSumut.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0 ; i < response.length() ; i ++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String nama = jsonObject.getString("nama");
                                String jenis = jsonObject.getString("jenis");
                                String gambar = jsonObject.getString("gambar");
                                String deskripsi = jsonObject.getString("deskripsi");

                                Daftar_wisata daftar_wisata = new Daftar_wisata(nama , jenis , gambar , deskripsi);
                                wisataList.add(daftar_wisata);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            Daftar_AdapaterWisata adapter = new Daftar_AdapaterWisata(Daftar.this , wisataList);

                            recyclerView.setAdapter(adapter);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Daftar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}