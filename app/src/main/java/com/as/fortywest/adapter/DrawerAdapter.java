package com.as.fortywest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.as.fortywest.R;
import com.as.fortywest.model.DrawerItem;

import java.util.List;

public class DrawerAdapter extends BaseAdapter {

	private List<DrawerItem> mDrawerItems;
	private LayoutInflater mInflater;
	private final boolean mIsFirstType; //Choose between two types of list items

	public DrawerAdapter(Context context, List<DrawerItem> items, boolean isFirstType) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mDrawerItems = items;
		mIsFirstType = isFirstType;
	}

	@Override
	public int getCount() {
		return mDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDrawerItems.get(position).getTag();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_view_item_navigation_drawer, parent, false);
			holder = new ViewHolder();
			holder.dividerTop = (View) convertView
					.findViewById(R.id.divider_top);
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.dividerBottom = (View) convertView
					.findViewById(R.id.divider_bottom);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		DrawerItem item = mDrawerItems.get(position);

		if (mIsFirstType) {	//We chose to set icon that exists in list_view_item_navigation_drawer_1.xml
			// holder.icon.setText(item.getIcon());
			holder.icon.setImageResource(item.getIcon());
		}
		holder.title.setText(item.getTitle());

		return convertView;
	}

	private static class ViewHolder {
		public ImageView icon;
		public/* Roboto */TextView title;
		public View dividerTop;
		public View dividerBottom;
	}
}