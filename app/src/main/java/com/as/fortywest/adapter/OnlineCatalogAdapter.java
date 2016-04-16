package com.as.fortywest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.as.fortywest.R;
import com.as.fortywest.model.ProductCategory;

import java.util.List;

public class OnlineCatalogAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<ProductCategory> mCategories;

	public OnlineCatalogAdapter(Context context, List<ProductCategory> categories) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mCategories = categories;
	}

	@Override
	public int getCount() {
		return mCategories.size();
	}

	@Override
	public Object getItem(int position) {
		return mCategories.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_view_item_offline_catalog, parent, false);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		ProductCategory productCategory = mCategories.get(position);
		holder.title.setText(productCategory.getName());
		holder.image.setImageResource(productCategory.getImage());
		return convertView;
	}
	
	private static class ViewHolder {
		public TextView title;
		public ImageView image;
	}
}
