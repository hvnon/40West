package com.as.fortywest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.as.fortywest.adapter.SearchAdapter;
import com.as.fortywest.adapter.StoreFinderAdapter;
import com.as.fortywest.model.StoreModel;
import com.as.fortywest.dummy.DummyContent;

import java.util.ArrayList;

public class StoreLocatorActivity extends AppCompatActivity implements OnClickListener, AdapterView.OnItemClickListener {
	private EditText mSearchField;
	private TextView mXMark;
	private View mMicrofon;
	private ListView mListView;
	private ArrayList<StoreModel> searchableArrayList;
	public static String TAG_STORE_OBJECT_PARCELABLE = "Store_Objects";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_locator);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle(R.string.store_finder_activity);

		mSearchField = (EditText) findViewById(R.id.search_field);
		mXMark = (TextView) findViewById(R.id.search_x);
		mMicrofon = findViewById(R.id.search_microfon);
		mListView = (ListView) findViewById(R.id.list_view);

		searchableArrayList = DummyContent.getDummyStoreList();
		mListView.setAdapter(new StoreFinderAdapter(StoreLocatorActivity.this, searchableArrayList));
		mListView.setOnItemClickListener(this);
		mXMark.setOnClickListener(this);
		mMicrofon.setOnClickListener(this);

		mSearchField.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@SuppressLint("DefaultLocale")
			@Override
			public void afterTextChanged(Editable editable) {
				String searchText = editable.toString().trim();
				ArrayList<String> searchedArray = new ArrayList<String>();
				for (StoreModel store : searchableArrayList) {
					if (store.getPostalCode().toLowerCase().contains(searchText.toLowerCase())
							|| store.getName().toLowerCase().contains(searchText.toLowerCase())) {
						searchedArray.add(store.getName());
					}
				}
				if (searchText.isEmpty()) {
					mListView.setAdapter(new StoreFinderAdapter(StoreLocatorActivity.this, searchableArrayList));
					mXMark.setText(R.string.fontello_x_mark);
				} else {
					mListView.setAdapter(new SearchAdapter(
							StoreLocatorActivity.this, searchedArray));
					mXMark.setText(R.string.fontello_x_mark_masked);
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.search_x:
				mSearchField.setText(null);
				break;
			case R.id.search_microfon:
				Toast.makeText(this, "Implement voice search", Toast.LENGTH_LONG)
						.show();
				break;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		StoreModel storeModel = searchableArrayList.get(position);
		Intent intent = new Intent(getApplicationContext(), StoreDetailActivity.class);
		intent.putExtra(TAG_STORE_OBJECT_PARCELABLE, storeModel);
		startActivity(intent);
	}
}
