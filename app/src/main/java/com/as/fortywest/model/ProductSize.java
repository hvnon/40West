package com.as.fortywest.model;

/**
 * Created by slock on 4/7/2016.
 */
public class ProductSize {
    private int mId;
    private String mSize;
    private int mStock;

    public ProductSize(){

    }

    public ProductSize(int id, String size, int stock){
        mId = id;
        mSize = size;
        mStock = stock;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getSize() {
        return mSize;
    }

    public void setSize(String mSize) {
        this.mSize = mSize;
    }

    public int getStock() {
        return mStock;
    }

    public void setStock(int mStock) {
        this.mStock = mStock;
    }
}
