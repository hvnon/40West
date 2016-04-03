package com.as.fortywest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.as.fortywest.R;
import com.as.fortywest.model.DrawerItem;
import com.as.fortywest.model.DummyModel;
import com.as.fortywest.util.DummyContent;

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
			convertView = mInflater.inflate(R.layout.list_view_item_navigation_drawer_shop, parent, false);
			holder = new ViewHolder();
			holder.icon = (TextView) convertView.findViewById(R.id.list_item_navigation_drawer_shop_icon); // holder.icon object is null if mIsFirstType is set to false
			holder.title = (TextView) convertView.findViewById(R.id.list_item_navigation_drawer_shop_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		DrawerItem item = mDrawerItems.get(position);

		if (mIsFirstType) {	//We chose to set icon that exists in list_view_item_navigation_drawer_1.xml
			holder.icon.setText(item.getIcon());
		}
		holder.title.setText(item.getTitle());

		return convertView;
	}

	private static class ViewHolder {
		public TextView icon;
		public /*Roboto*/TextView title;
	}
}