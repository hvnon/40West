package com.as.fortywest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.as.fortywest.R;
import com.as.fortywest.adapter.OnlineCatalogAdapter;
import com.as.fortywest.dummy.DummyContent;
import com.as.fortywest.model.ProductCategory;

import java.util.ArrayList;

public class OnlineCatalogFragment extends Fragment implements AdapterView.OnItemClickListener {
    public static String TAG_OFFLINE_CATALOG_OBJECT_PARCELABLE = "Online_Catalog_Objects";
    private ListView mListView;
    private ArrayList<ProductCategory> mOnlineCatalogs;

    public static OnlineCatalogFragment newInstance() {
        return new OnlineCatalogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offline_catalog,
                container, false);

        mOnlineCatalogs = DummyContent.getDummyCatalogList();
        mListView = (ListView) rootView.findViewById(R.id.list_view);
        mListView.setAdapter(new OnlineCatalogAdapter(getActivity(), mOnlineCatalogs));
        mListView.setOnItemClickListener(this);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ProductCategory productCategory = mOnlineCatalogs.get(position);
    }
}