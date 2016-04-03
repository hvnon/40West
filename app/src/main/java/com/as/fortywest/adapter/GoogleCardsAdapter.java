package com.as.fortywest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.as.fortywest.R;
import com.as.fortywest.model.DummyModel;
import com.as.fortywest.util.ImageUtil;

import java.util.List;

public class GoogleCardsAdapter extends ArrayAdapter<DummyModel>
		implements OnClickListener {

	private LayoutInflater mInflater;

	public GoogleCardsAdapter(Context context, List<DummyModel> items) {
		super(context, 0, items);
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.list_item_google_cards_shop, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_google_cards_shop_image);
			holder.promo = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_shop_promo);
			holder.discount = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_shop_discount);
			holder.price = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_shop_price);
			holder.description = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_shop_description);
			holder.day = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_shop_day);
			holder.buy = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_shop_buy);
			holder.buy.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.buy.setTag(position);
		DummyModel item = getItem(position);
		ImageUtil.displayImage(holder.image, item.getImageURL(), null);

		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public TextView promo;
		public TextView discount;
		public TextView price;
		public TextView description;
		public TextView day;
		public TextView buy;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int possition = (Integer) v.getTag();
		switch (v.getId()) {
		case R.id.list_item_google_cards_shop_buy:
			// click on explore button
			Toast.makeText(getContext(), "Buy: ", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
