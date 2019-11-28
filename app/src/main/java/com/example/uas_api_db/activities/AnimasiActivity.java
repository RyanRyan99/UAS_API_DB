package com.example.uas_api_db.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.uas_api_db.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class AnimasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animasi);



        //hide actionbar
        getSupportActionBar().hide();

        //Menerima data Skuy
        String nama = getIntent().getExtras().getString("nama_animasi");
        String deskripsi = getIntent().getExtras().getString("deskripsi_animasi");
        String studio = getIntent().getExtras().getString("studio_animasi");
        String kategori = getIntent().getExtras().getString("kategori_animasi");
        int episode = getIntent().getExtras().getInt("episode_animasi");
        String rating = getIntent().getExtras().getString("rating_animasi");
        String gambar_url = getIntent().getExtras().getString("gambar_animasi");

        //Views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.idcoolapsingtoolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_nama = findViewById(R.id.aa_nama_animasi);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_kategori = findViewById(R.id.aa_kategori);
        TextView tv_deskripsi = findViewById(R.id.aa_deskripsi);
        TextView tv_rating = findViewById(R.id.aa_rating);
        ImageView gambar = findViewById(R.id.aa_thumbnail);

        //Pengaturan Values
        tv_nama.setText(nama);
        tv_kategori.setText(kategori);
        tv_deskripsi.setText(deskripsi);
        tv_rating.setText(rating);
        tv_studio.setText(studio);
        collapsingToolbarLayout.setTitle(nama);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        //Set Gambar Bro-bro
        Glide.with(this).load(gambar_url).apply(requestOptions).into(gambar);


    }
}
