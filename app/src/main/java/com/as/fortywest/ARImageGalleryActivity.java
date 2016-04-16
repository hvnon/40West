package com.as.fortywest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.as.fortywest.adapter.ARImageGalleryAdapter;
import com.as.fortywest.model.ARImageGalleryModel;
import com.as.fortywest.dummy.DummyContent;

import java.util.ArrayList;

public class ARImageGalleryActivity extends AppCompatActivity {
	private ArrayList<ARImageGalleryModel> mSubcategories;
	private ListView mListView;
	private boolean mIsLayoutOnTop = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		mListView = (ListView) findViewById(R.id.list_view);
		mSubcategories = DummyContent.getImageGalleryMusicCategories();
		setAdapter();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setAdapter() {
		BaseAdapter adapter = new ARImageGalleryAdapter(this, mSubcategories, mIsLayoutOnTop);
		mListView.setAdapter(adapter);
	}
}
