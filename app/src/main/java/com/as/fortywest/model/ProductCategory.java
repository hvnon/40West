package com.as.fortywest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by slock on 4/1/2016.
 */
public class ProductCategory implements Parcelable {
    private int mId;
    private int mImage;
    private String mName;
    private String mCode;

    public ProductCategory() {
    }

    public ProductCategory(int id, String name, String code, int image) {
        mId = id;
        mName = name;
        mCode = code;
        mImage = image;
    }

    public ProductCategory(Parcel source) {
        mId = source.readInt();
        mImage = source.readInt();
        mName = source.readString();
        mCode = source.readString();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getCode() {
        return mName;
    }

    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeInt(mImage);
        dest.writeString(mName);
        dest.writeString(mCode);
    }

    public static final Creator<ProductCategory> CREATOR
            = new Creator<ProductCategory>() {

        public ProductCategory createFromParcel(Parcel in) {
            return new ProductCategory(in);
        }

        public ProductCategory[] newArray(int size) {
            return new ProductCategory[size];
        }
    };

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }
}
