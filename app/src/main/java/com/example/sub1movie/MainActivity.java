package com.example.sub1movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sub1movie.POJO.Movie;
import com.example.sub1movie.adapter.MovieAdapter;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private MovieAdapter movieAdapter;
    private String[]dataNameMovie,dataTglMovie,dataDescMovie,dataCrew,dataCrewDetail,dataDescDetail;
    private TypedArray imgMovie;
    private ArrayList<Movie>movies;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_movie);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent changeActivity = new Intent(MainActivity.this,DetailActivity.class);
                changeActivity.putExtra("EXTRA_MOVIE",movies.get(position));
                startActivity(changeActivity);
            }
        });

        init();
        addItem();

    }
    private void init() {
        dataNameMovie=getResources().getStringArray(R.array.data_name_movie);
        dataTglMovie=getResources().getStringArray(R.array.data_tgl_movie);
        imgMovie = getResources().obtainTypedArray(R.array.data_picture);
        dataDescMovie = getResources().getStringArray(R.array.data_description_detail);


    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0 ; i<imgMovie.length();i++){
            Movie movie = new Movie();
            movie.setNamaMovie(dataNameMovie[i]);
            movie.setTglMovie(dataTglMovie[i]);
            movie.setDescMovie(dataDescMovie[i]);
            movie.setPicture(imgMovie.getResourceId(i,-1));
            movies.add(movie);
        }

        movieAdapter.setMovies(movies);
    }

}
