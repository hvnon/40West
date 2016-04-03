package com.as.fortywest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class StoreOpenHour implements Parcelable {
    private String mDay;
    private String mFrom;
    private String mTo;

    public StoreOpenHour()
    {

    };

    public StoreOpenHour(String day, String from, String to){
        mDay = day;
        mFrom = from;
        mTo = to;
    }

    protected StoreOpenHour(Parcel in) {
        mDay = in.readString();
        mFrom = in.readString();
        mTo = in.readString();
    }

    public static final Creator<StoreOpenHour> CREATOR = new Creator<StoreOpenHour>() {
        @Override
        public StoreOpenHour createFromParcel(Parcel in) {
            return new StoreOpenHour(in);
        }

        @Override
        public StoreOpenHour[] newArray(int size) {
            return new StoreOpenHour[size];
        }
    };

    public String getDay() {
        return mDay;
    }

    public void setDay(String mDay) {
        this.mDay = mDay;
    }

    public String getFrom() {
        return mFrom;
    }

    public void setFrom(String mFrom) {
        this.mFrom = mFrom;
    }

    public String getTo() {
        return mTo;
    }

    public void setTo(String mTo) {
        this.mTo = mTo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDay);
        dest.writeString(mFrom);
        dest.writeString(mTo);
    }
}
