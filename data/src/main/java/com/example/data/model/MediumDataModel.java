
package com.example.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MediumDataModel {

    @SerializedName("approved_for_syndication")
    private Long mApprovedForSyndication;
    @SerializedName("caption")
    private String mCaption;
    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("media-metadata")
    private List<MediaMetadatumDataModel> mMediaMetadata;
    @SerializedName("subtype")
    private String mSubtype;
    @SerializedName("type")
    private String mType;

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

    public List<MediaMetadatumDataModel> getMediaMetadata() {
        return mMediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatumDataModel> mediaMetadata) {
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
