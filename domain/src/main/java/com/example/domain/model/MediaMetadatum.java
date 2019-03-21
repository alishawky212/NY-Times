
package com.example.domain.model;


@SuppressWarnings("unused")
public class MediaMetadatum {


    private String mFormat;

    private Long mHeight;

    private String mUrl;

    private Long mWidth;

    public MediaMetadatum(String mFormat, Long mHeight, String mUrl, Long mWidth) {
        this.mFormat = mFormat;
        this.mHeight = mHeight;
        this.mUrl = mUrl;
        this.mWidth = mWidth;
    }

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
