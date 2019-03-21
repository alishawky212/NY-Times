
package com.example.domain.model;


import java.util.List;

public class Medium {

    private Long mApprovedForSyndication;
    private String mCaption;
    private String mCopyright;
    private List<MediaMetadatum> mMediaMetadata;
    private String mSubtype;
    private String mType;

    public Medium(Long mApprovedForSyndication, String mCaption, String mCopyright, List<MediaMetadatum> mMediaMetadata, String mSubtype, String mType) {
        this.mApprovedForSyndication = mApprovedForSyndication;
        this.mCaption = mCaption;
        this.mCopyright = mCopyright;
        this.mMediaMetadata = mMediaMetadata;
        this.mSubtype = mSubtype;
        this.mType = mType;
    }

    public Long getApprovedForSyndication() {
        return mApprovedForSyndication;
    }

    public void setApprovedForSyndication(Long approvedForSyndication) {
        mApprovedForSyndication = approvedForSyndication;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public List<MediaMetadatum> getMediaMetadata() {
        return mMediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        mMediaMetadata = mediaMetadata;
    }

    public String getSubtype() {
        return mSubtype;
    }

    public void setSubtype(String subtype) {
        mSubtype = subtype;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
