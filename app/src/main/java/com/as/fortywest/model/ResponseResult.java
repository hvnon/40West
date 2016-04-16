package com.as.fortywest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slock on 4/13/2016.
 */
public class ResponseResult {
    @SerializedName("results")
    public ArrayList<Product> products;

    @SerializedName("total_results_count")
    public int totalResultCount;

    @SerializedName("code")
    public String code;

    @SerializedName("offset")
    public String offset;

    public ResponseResult(){
        products = new ArrayList<Product>();
    }
}
