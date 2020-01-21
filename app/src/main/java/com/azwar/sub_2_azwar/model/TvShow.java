package com.azwar.sub_2_azwar.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private int poster;
    private String title;
    private String overview;
    private String creator;
    private String status;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public TvShow(){
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(poster);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(creator);
        parcel.writeString(status);
    }

    protected TvShow(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        overview = in.readString();
        creator = in.readString();
        status = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
