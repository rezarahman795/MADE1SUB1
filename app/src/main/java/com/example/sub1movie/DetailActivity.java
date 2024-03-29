package com.example.sub1movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sub1movie.POJO.Movie;
import com.example.sub1movie.adapter.MovieAdapter;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNameMovie,tvTglMovie,tvDescMovie,tvCrew,tvCrewDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent =getIntent();
        Movie movie = intent.getParcelableExtra("EXTRA_MOVIE");
        String movieName = movie.getNamaMovie();
        String movieTgl = movie.getTglMovie();
        String movieDesc = movie.getDescMovie();
        String movieCrew = movie.getCrewMovie();
        String movieCrewDetail = movie.getCrewDetailMovie();

        getSupportActionBar().setTitle(movieName);

        ImageView imageView = findViewById(R.id.gambarMovie);
        Glide.with(this)
                .load(movie.getPicture())
                .into(imageView);

        tvNameMovie = findViewById(R.id.txt_name);
        tvNameMovie.setText(movieName);
        tvTglMovie = findViewById(R.id.txt_tgl);
        tvTglMovie.setText(movieTgl);
        tvDescMovie = findViewById(R.id.txt_desc);
        tvDescMovie.setText(movieDesc);
        tvCrew =findViewById(R.id.crew_detail);
        tvCrew.setText(movieCrew);
        tvCrewDetail =findViewById(R.id.position_detail);
        tvCrewDetail.setText(movieCrewDetail);

    }


    }

