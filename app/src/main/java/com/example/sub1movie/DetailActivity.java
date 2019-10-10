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
    private String[] dataCrew,dataCrewDetail;
    private ArrayList<Movie>movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        crew();
        addItem();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent =getIntent();
        Movie movie = intent.getParcelableExtra("EXTRA_MOVIE");
        String movieName = movie.getNamaMovie();
        String movieTgl = movie.getTglMovie();
        String movieDesc = movie.getDescMovie();
//        String movieCrew = movie.getCrewMovie();
//        String movieCrewDetail = movie.getCrewDetailMovie();

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
//        tvCrew =findViewById(R.id.crew_detail);
//        tvCrew.setText(movieCrew);
//        tvCrewDetail =findViewById(R.id.position_detail);
//        tvCrewDetail.setText(movieCrewDetail);

    }
    private void crew() {
        dataCrew = getResources().getStringArray(R.array.data_name_crew);
        dataCrewDetail = getResources().getStringArray(R.array.data_name_crew);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataCrew.length; i++) {
            Movie movie = new Movie();
            movie.setCrewMovie(dataCrew[i]);
            movie.setCrewDetailMovie(dataCrewDetail[i]);
            movies.add(movie);
        }
    }

    }

