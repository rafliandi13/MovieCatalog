package com.example.mybottomnavigation.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int Image;
    private String Name;
    private String Description;
    private String Gendre;
    private String Duration;
    private String Director;

    public int getImage() {
        return Image;
    }

    public String getGendre() {
        return Gendre;
    }

    public void setGendre(String gendre) {
        Gendre = gendre;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Movie() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.Image);
        dest.writeString(this.Name);
        dest.writeString(this.Description);
        dest.writeString(this.Gendre);
        dest.writeString(this.Duration);
        dest.writeString(this.Director);
    }

    protected Movie(Parcel in) {
        this.Image = in.readInt();
        this.Name = in.readString();
        this.Description = in.readString();
        this.Gendre = in.readString();
        this.Duration = in.readString();
        this.Director = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
