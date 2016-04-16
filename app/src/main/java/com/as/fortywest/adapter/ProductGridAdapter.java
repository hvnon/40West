package com.as.fortywest.adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.as.fortywest.R;
import com.as.fortywest.model.GalleryItem;
import com.as.fortywest.model.Product;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;

public class ProductGridAdapter extends ArrayAdapter<Product> {
    private DisplayImageOptions options;
    private Context context;
    private int layoutResourceId;
    private ArrayList<Product> data = new ArrayList<Product>();


    public ProductGridAdapter(Context context, int layoutResourceId, ArrayList<Product> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_stub)
                .showImageForEmptyUri(R.drawable.ic_empty)
                .showImageOnFail(R.drawable.ic_error)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new RoundedBitmapDisplayer(20))
                .build();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImageHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();

            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ImageHolder();
            holder.name = (TextView) row.findViewById(R.id.name);
            holder.price = (TextView) row.findViewById(R.id.price);
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ImageHolder) row.getTag();
        }


        Product item = data.get(position);
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        ImageLoader.getInstance().displayImage(item.getImage(), holder.image, options);

        return row;
    }

    static class ImageHolder {
        TextView name;
        ImageView image;
        TextView price;
    }
}