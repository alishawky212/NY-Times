package com.example.nytimes.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ArticaleUIModel implements Parcelable {

    private String title;
    private String mByline;
    private String mSource;
    private String mPublichDate;
    private String image_url;
    private String mAbstract;


    public ArticaleUIModel(String title, String mByline, String mSource, String mPublichDate, String image_url,String mAbstract) {
        this.title = title;
        this.mByline = mByline;
        this.mSource = mSource;
        this.mPublichDate = mPublichDate;
        this.image_url = image_url;
        this.mAbstract = mAbstract;
    }

    protected ArticaleUIModel(Parcel in) {
        title = in.readString();
        mByline = in.readString();
        mSource = in.readString();
        mPublichDate = in.readString();
        image_url = in.readString();
        mAbstract = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(mByline);
        dest.writeString(mSource);
        dest.writeString(mPublichDate);
        dest.writeString(image_url);
        dest.writeString(mAbstract);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArticaleUIModel> CREATOR = new Creator<ArticaleUIModel>() {
        @Override
        public ArticaleUIModel createFromParcel(Parcel in) {
            return new ArticaleUIModel(in);
        }

        @Override
        public ArticaleUIModel[] newArray(int size) {
            return new ArticaleUIModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getmByline() {
        return mByline;
    }

    public void setmByline(String mByline) {
        this.mByline = mByline;
    }

    public String getmSource() {
        return mSource;
    }

    public void setmSource(String mSource) {
        this.mSource = mSource;
    }

    public String getmPublichDate() {
        return mPublichDate;
    }

    public void setmPublichDate(String mPublichDate) {
        this.mPublichDate = mPublichDate;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getmAbstract() {
        return mAbstract;
    }

    public void setmAbstract(String mAbstract) {
        this.mAbstract = mAbstract;
    }
}
