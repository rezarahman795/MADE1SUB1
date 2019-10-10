package com.example.sub1movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sub1movie.POJO.Movie;

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
        String movieDescDetail = movie.getDescMovieDetail();
        String movieCrew = movie.getCrewMovie();
        String movieCrewDetail = movie.getCrewDetailMovie();

        getSupportActionBar().setTitle(movieName);
        ImageView imageView = findViewById(R.id.pict_detail);
        Glide.with(this)
                .load(movie.getPicture())
                .into(imageView);
        tvNameMovie = findViewById(R.id.txt_name_detail);
        tvNameMovie.setText(movieName);
        tvTglMovie = findViewById(R.id.txt_tgl_Detail);
        tvTglMovie.setText(movieTgl);
        tvDescMovie = findViewById(R.id.txt_desc_detail);
        tvDescMovie.setText(movieDescDetail);
        tvCrew =findViewById(R.id.crew_movie);
        tvCrew.setText(movieCrew);
        tvCrewDetail =findViewById(R.id.position_detail_crew);
        tvCrewDetail.setText(movieCrewDetail);
    }
}
