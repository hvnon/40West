package com.as.fortywest.model;

/**
 * Created by slock on 4/7/2016.
 */
public class ProductImage {
    private int mId;
    private String mImageURL;

    public ProductImage(){

    }

    public ProductImage(int id, String url){
        mId = id;
        mImageURL = url;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getImageURL() {
        return mImageURL;
    }

    public void setImageURL(String imageURL) {
        this.mImageURL = imageURL;
    }
}
