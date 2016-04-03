package com.as.fortywest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ARImageGalleryModel implements Parcelable {

	private long mId;
	private String mUrl;
	private String mTitle;

	public ARImageGalleryModel() {
	}

	protected ARImageGalleryModel(Parcel in) {
		mId = in.readLong();
		mUrl = in.readString();
		mTitle = in.readString();
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		mId = id;
	}

	public String getUrl() {
		return mUrl;
	}

	public void setUrl(String url) {
		mUrl = url;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(mId);
		dest.writeString(mUrl);
		dest.writeString(mTitle);
	}

	public static final Creator<ARImageGalleryModel> CREATOR = new Creator<ARImageGalleryModel>() {
		@Override
		public ARImageGalleryModel createFromParcel(Parcel in) {
			return new ARImageGalleryModel(in);
		}

		@Override
		public ARImageGalleryModel[] newArray(int size) {
			return new ARImageGalleryModel[size];
		}
	};
}