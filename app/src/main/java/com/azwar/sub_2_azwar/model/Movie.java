package com.azwar.sub_2_azwar.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int poster;
    private String title;
    private String overview;
    private String release;
    private String language;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    @Override
    public int describeContents() {
        return 0;
    }
    public Movie(){

    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(poster);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(release);
        parcel.writeString(language);

    }
    protected Movie(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        overview = in.readString();
        release = in.readString();
        language = in.readString();

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
