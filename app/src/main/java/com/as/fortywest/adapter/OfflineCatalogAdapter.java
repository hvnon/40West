package com.as.fortywest.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.as.fortywest.R;
import com.as.fortywest.model.OfflineCatalogModal;
import com.as.fortywest.util.ImageUtil;

import java.util.List;

public class OfflineCatalogAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private List<OfflineCatalogModal> mCategories;
	
	public OfflineCatalogAdapter(Context context, List<OfflineCatalogModal> categories) {
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

		OfflineCatalogModal category = mCategories.get(position);
		holder.title.setText(category.getmName());
		holder.image.setImageResource(category.getmImage());
		return convertView;
	}
	
	private static class ViewHolder {
		public TextView title;
		public ImageView image;
	}
}
