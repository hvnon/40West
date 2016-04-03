package com.as.fortywest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.as.fortywest.R;
import com.as.fortywest.model.StoreModel;

import java.util.ArrayList;

public class StoreFinderAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<StoreModel> mStores;

	public StoreFinderAdapter(Context context, ArrayList<StoreModel> subcategories) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mStores = subcategories;
	}

	@Override
	public int getCount() {
		return mStores.size();
	}

	@Override
	public Object getItem(int position) {
		return mStores.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_view_item_store_finder, parent, false);
			holder = new ViewHolder();
			holder.storeNameText = (TextView) convertView.findViewById(R.id.store_name_text);
			holder.storeDistance = (TextView) convertView.findViewById(R.id.store_distance);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		StoreModel store = mStores.get(position);
		holder.storeNameText.setText(store.getName());
		holder.storeDistance.setText(store.getDistance());
		return convertView;
	}
	
	private static class ViewHolder {
		public TextView storeNameText;
		public TextView storeDistance;
	}
}
