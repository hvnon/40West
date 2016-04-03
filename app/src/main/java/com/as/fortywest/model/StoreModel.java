package com.as.fortywest.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slock on 4/1/2016.
 */

public class StoreModel implements Parcelable{
    private int mId;
    private String mName;
    private String mDistance;
    private String mPostalCode;
    private String mAddress;
    private String mPhone;
    private String mEmail;
    private List<StoreOpenHour> mWeek;

    public StoreModel() {
        mWeek = new ArrayList<StoreOpenHour>();
    }

    public StoreModel(int id, String name, String distance, String postalCode, String address, String phone, String email, List<StoreOpenHour> week) {
        mId = id;
        setName(name);
        setDistance(distance);
        setPostalCode(postalCode);
        setAddress(address);
        setWeek(week);
        setPhone(phone);
        setEmail(email);
    }

    protected StoreModel(Parcel in) {
        this();
        mId = in.readInt();
        mName = in.readString();
        mDistance = in.readString();
        mPostalCode = in.readString();
        mAddress = in.readString();
        mPhone = in.readString();
        mEmail = in.readString();
    }

    public static final Creator<StoreModel> CREATOR = new Creator<StoreModel>() {
        @Override
        public StoreModel createFromParcel(Parcel in) {
            return new StoreModel(in);
        }

        @Override
        public StoreModel[] newArray(int size) {
            return new StoreModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mDistance);
        dest.writeString(mPostalCode);
        dest.writeString(mAddress);
        dest.writeString(mPhone);
        dest.writeString(mEmail);
        dest.writeArray(mWeek.toArray());
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDistance() {
        return mDistance;
    }

    public void setDistance(String mDistance) {
        this.mDistance = mDistance;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public void setPostalCode(String mPostalCode) {
        this.mPostalCode = mPostalCode;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public List<StoreOpenHour> getWeek() {
        return mWeek;
    }

    public void setWeek(List<StoreOpenHour> mWeek) {
        this.mWeek = mWeek;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}

