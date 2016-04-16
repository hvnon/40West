package com.as.fortywest.model;

import java.util.ArrayList;

/**
 * Created by slock on 4/7/2016.
 */
public class ProductColor {
    private int mId;
    private String mName;
    private String mCode;
    private ArrayList<ProductSize> mSizes;
    private ArrayList<ProductImage> mImages;

    public ProductColor(){
        mSizes = new ArrayList<ProductSize>();
    }

    public ProductColor(int id, String name, String code, ArrayList<ProductSize> sizes, ArrayList<ProductImage> images){
        mId = id;
        mName = name;
        mCode = code;
        mSizes = sizes;
        mImages = images;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    public ArrayList<ProductSize> getSizes() {
        return mSizes;
    }

    public void setSizes(ArrayList<ProductSize> mSizes) {
        this.mSizes = mSizes;
    }

    public int getQty(){
        int totalQty = 0;
        if(mSizes != null && mSizes.size() > 0){
            for(ProductSize size : mSizes){
                totalQty += size.getStock();
            }
        }
        return totalQty;
    }

    public ArrayList<ProductImage> getImages() {
        return mImages;
    }

    public void setImages(ArrayList<ProductImage> mImages) {
        this.mImages = mImages;
    }
}
