package com.example.sub1movie.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int picture;
    private String namaMovie,tglMovie,descMovie,crewMovie,crewDetailMovie,descMovieDetail,namaMovieDetail,tglMovieDetail;

    public Movie(){

    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getNamaMovie() {
        return namaMovie;
    }

    public void setNamaMovie(String namaMovie) {
        this.namaMovie = namaMovie;
    }

    public String getTglMovie() {
        return tglMovie;
    }

    public void setTglMovie(String tglMovie) {
        this.tglMovie = tglMovie;
    }

    public String getDescMovie() {
        return descMovie;
    }

    public void setDescMovie(String descMovie) {
        this.descMovie = descMovie;
    }

    public String getCrewMovie() {
        return crewMovie;
    }

    public void setCrewMovie(String crewMovie) {
        this.crewMovie = crewMovie;
    }

    public String getCrewDetailMovie() {
        return crewDetailMovie;
    }

    public void setCrewDetailMovie(String crewDetailMovie) {
        this.crewDetailMovie = crewDetailMovie;
    }

    public String getDescMovieDetail() {
        return descMovieDetail;
    }

    public void setDescMovieDetail(String descMovieDetail) {
        this.descMovieDetail = descMovieDetail;
    }

    public String getNamaMovieDetail() {
        return namaMovieDetail;
    }

    public void setNamaMovieDetail(String namaMovieDetail) {
        this.namaMovieDetail = namaMovieDetail;
    }

    public String getTglMovieDetail() {
        return tglMovieDetail;
    }

    public void setTglMovieDetail(String tglMovieDetail) {
        this.tglMovieDetail = tglMovieDetail;
    }

    protected Movie(Parcel in) {
        picture = in.readInt();
        namaMovie = in.readString();
        tglMovie = in.readString();
        descMovie = in.readString();
        crewMovie = in.readString();
        crewDetailMovie = in.readString();
        descMovieDetail = in.readString();
        namaMovieDetail = in.readString();
        tglMovieDetail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(picture);
        dest.writeString(namaMovie);
        dest.writeString(tglMovie);
        dest.writeString(descMovie);
        dest.writeString(crewMovie);
        dest.writeString(crewDetailMovie);
        dest.writeString(descMovieDetail);
        dest.writeString(namaMovieDetail);
        dest.writeString(tglMovieDetail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };



}
