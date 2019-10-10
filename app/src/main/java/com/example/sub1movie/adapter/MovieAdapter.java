package com.example.sub1movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sub1movie.POJO.Movie;
import com.example.sub1movie.R;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie>movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemMovieView = convertView;
        if (itemMovieView == null){
            itemMovieView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);

        }

        ViewHolder viewHolder = new ViewHolder(itemMovieView);
        Movie movies= (Movie)getItem(position);
       ImageView pictMovies = itemMovieView.findViewById(R.id.gambarMovie);
        viewHolder.bind(movies);
        Glide.with(itemMovieView)
                .load(movies.getPicture())
                .into(pictMovies);
        return itemMovieView;
    }

    private class ViewHolder {
        private TextView txtNameMovies,txtTglMovies,txtDescMovie,txtCrewMovie,txtCrewDetail;
        private ImageView pictMovies;

        ViewHolder(View view){
            txtNameMovies = view.findViewById(R.id.txt_name);
            txtTglMovies = view.findViewById(R.id.txt_tgl);
            txtDescMovie = view.findViewById(R.id.txt_desc);
            pictMovies =view.findViewById(R.id.gambarMovie);
            txtCrewMovie = view.findViewById(R.id.crew_detail);
            txtCrewDetail = view.findViewById(R.id.position_detail);

        }
        public void bind(Movie movies) {

            txtNameMovies.setText(movies.getNamaMovie());
            txtTglMovies.setText(movies.getTglMovie());
            txtDescMovie.setText(movies.getDescMovie());
            pictMovies.setImageResource(movies.getPicture());
            txtCrewMovie.setText(movies.getCrewMovie());
            txtCrewDetail.setText(movies.getCrewDetailMovie());


        }

    }
}
