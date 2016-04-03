package com.as.fortywest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by slock on 4/1/2016.
 */
public class OfflineCatalogModal implements Parcelable {
    private int mId;
    private String mName;
    private String mAssetName;

    public OfflineCatalogModal() {
    }

    public OfflineCatalogModal(int id, String name, String assetName) {
        mId = id;
        mName = name;
        mAssetName = assetName;
    }

    public OfflineCatalogModal(Parcel source) {
        mId = source.readInt();
        mName = source.readString();
        mAssetName = source.readString();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAssetName() {
        return mAssetName;
    }

    public void setmAssetName(String mAssetName) {
        this.mAssetName = mAssetName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mAssetName);
    }

    public static final Parcelable.Creator<OfflineCatalogModal> CREATOR
            = new Parcelable.Creator<OfflineCatalogModal>() {

        public OfflineCatalogModal createFromParcel(Parcel in) {
            return new OfflineCatalogModal(in);
        }

        public OfflineCatalogModal[] newArray(int size) {
            return new OfflineCatalogModal[size];
        }
    };
}
