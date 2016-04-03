package com.as.fortywest.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.as.fortywest.PDFViewActivity;
import com.as.fortywest.R;
import com.as.fortywest.adapter.OfflineCatalogAdapter;
import com.as.fortywest.model.OfflineCatalogModal;
import com.as.fortywest.util.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class OfflineCatalogFragment extends Fragment implements OnItemClickListener {
	public static String TAG_OFFLINE_CATALOG_OBJECT_PARCELABLE = "Catalog_Objects";
	private ListView mListView;
	private ArrayList<OfflineCatalogModal> mOfflineCatalogs;

	public static OfflineCatalogFragment newInstance() {
		return new OfflineCatalogFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_left_menus,
				container, false);

		mOfflineCatalogs = DummyContent.getDummyOfflineCatalogList();

		mListView = (ListView) rootView.findViewById(R.id.list_view);
		mListView.setAdapter(new OfflineCatalogAdapter(getActivity(), mOfflineCatalogs));
		mListView.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		OfflineCatalogModal offlineCatalog = mOfflineCatalogs.get(position);
		Intent intent = new Intent(getActivity(), PDFViewActivity.class);
		intent.putExtra(TAG_OFFLINE_CATALOG_OBJECT_PARCELABLE, offlineCatalog);
		startActivity(intent);
	}
}
