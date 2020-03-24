package com.example.mybottomnavigation.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {
    private int Image;
    private String Name;
    private String Description;
    private String Gendre;
    private String Duration;
    private String Director;

    public TVShow() {

    }

    public int getImage() {
        return Image;
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



    public TVShow(Parcel in) {
        this.Image = in.readInt();
        this.Name = in.readString();
        this.Description = in.readString();
        this.Gendre = in.readString();
        this.Duration = in.readString();
        this.Director = in.readString();
    }

    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel in) {
            return new TVShow(in);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Image);
        parcel.writeString(this.Name);
        parcel.writeString(this.Description);
        parcel.writeString(this.Gendre);
        parcel.writeString(this.Duration);
        parcel.writeString(this.Director);
    }
}
