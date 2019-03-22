
package com.example.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ArticaleDataModel {


    @SerializedName("abstract")
    private String mAbstract;
    @SerializedName("adx_keywords")
    private String mAdxKeywords;
    @SerializedName("asset_id")
    private Long mAssetId;
    @SerializedName("byline")
    private String mByline;
    @SerializedName("column")
    private Object mColumn;
    @SerializedName("des_facet")
    private Object mDesFacet;
    @SerializedName("geo_facet")
    private Object mGeoFacet;
    @SerializedName("id")
    private Long mId;
    @SerializedName("media")
    private List<MediumDataModel> mMedia;
    @SerializedName("org_facet")
    private Object mOrgFacet;
    @SerializedName("per_facet")
    private Object mPerFacet;
    @SerializedName("published_date")
    private String mPublishedDate;
    @SerializedName("section")
    private String mSection;
    @SerializedName("source")
    private String mSource;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("views")
    private Long mViews;

    public String getAbstract() {
        return mAbstract;
    }

    public void setAbstract(String mAbstract) {
        this.mAbstract = mAbstract;
    }

    public String getAdxKeywords() {
        return mAdxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        mAdxKeywords = adxKeywords;
    }

    public Long getAssetId() {
        return mAssetId;
    }

    public void setAssetId(Long assetId) {
        mAssetId = assetId;
    }

    public String getByline() {
        return mByline;
    }

    public void setByline(String byline) {
        mByline = byline;
    }

    public Object getColumn() {
        return mColumn;
    }

    public void setColumn(Object column) {
        mColumn = column;
    }

    public Object getDesFacet() {
        return mDesFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        mDesFacet = desFacet;
    }

    public Object getGeoFacet() {
        return mGeoFacet;
    }

    public void setGeoFacet(String geoFacet) {
        mGeoFacet = geoFacet;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<MediumDataModel> getMedia() {
        return mMedia;
    }

    public void setMedia(List<MediumDataModel> media) {
        mMedia = media;
    }

    public Object getOrgFacet() {
        return mOrgFacet;
    }

    public void setOrgFacet(String orgFacet) {
        mOrgFacet = orgFacet;
    }

    public Object getPerFacet() {
        return mPerFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        mPerFacet = perFacet;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        mPublishedDate = publishedDate;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Long getViews() {
        return mViews;
    }

    public void setViews(Long views) {
        mViews = views;
    }

}
