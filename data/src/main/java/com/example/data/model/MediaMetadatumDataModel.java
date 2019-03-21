
package com.example.data.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class MediaMetadatumDataModel {

    @SerializedName("format")
    private String mFormat;
    @SerializedName("height")
    private Long mHeight;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("width")
    private Long mWidth;

    public String getFormat() {
        return mFormat;
    }

    public void setFormat(String format) {
        mFormat = format;
    }

    public Long getHeight() {
        return mHeight;
    }

    public void setHeight(Long height) {
        mHeight = height;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Long getWidth() {
        return mWidth;
    }

    public void setWidth(Long width) {
        mWidth = width;
    }

}
