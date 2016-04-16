package com.as.fortywest.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by slock on 4/7/2016.
 */
public class Product implements Parcelable{

    @SerializedName("productid")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("category")
    private String mCategory;

    @SerializedName("price")
    private String mPrice;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("url")
    private String mImage;

    @SerializedName("colors")
    private ArrayList<ProductColor> mColors;


    public Product(){
        mColors = new ArrayList<ProductColor>();
    };

    public Product(int id, String name, String category, String price, String description, String image, ArrayList<ProductColor> colors){
        mId = id;
        mName = name;
        mCategory = category;
        mPrice = price;
        mDescription = description;
        mImage = image;
        mColors = colors;
    };

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

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public ArrayList<ProductColor> getColors() {
        return mColors;
    }

    public void setColors(ArrayList<ProductColor> mColors) {
        this.mColors = mColors;
    }

    public int getQty(){
        int totalQty = 0;
        if(mColors != null && mColors.size() > 0){
            for(ProductColor color : mColors){
                totalQty += color.getQty();
            }
        }
        return totalQty;
    }

    protected Product(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mDescription = in.readString();
        mCategory = in.readString();
        mPrice = in.readString();
        mImage = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
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
        dest.writeString(mDescription);
        dest.writeString(mCategory);
        dest.writeString(mPrice);
        dest.writeString(mImage);
    }

    @Override
    public String toString()
    {
        return "Product [" +
                "product_id=" + mId + ", " +
                "product_name=" + mName + ", " +
                "category=" + mCategory + ", " +
                "description=" + mDescription + ", " +
                "price=" + mPrice + ", " +
                "image=" + mImage + ", " +
                "colors=" + mColors +
                "]";
    }
}