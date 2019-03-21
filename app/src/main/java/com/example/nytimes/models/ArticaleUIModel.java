package com.example.nytimes.models;

public class ArticaleUIModel {

    private String title;
    private String mByline;
    private String mSource;
    private String mPublichDate;
    private String image_url;


    public ArticaleUIModel(String title, String mByline, String mSource, String mPublichDate, String image_url) {
        this.title = title;
        this.mByline = mByline;
        this.mSource = mSource;
        this.mPublichDate = mPublichDate;
        this.image_url = image_url;
    }

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
}
