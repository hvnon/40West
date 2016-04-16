package com.as.fortywest.fragment;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.as.fortywest.R;
import com.as.fortywest.adapter.SearchAdapter;
import com.as.fortywest.dummy.DummyModel;
import com.as.fortywest.dummy.DummyContent;
import java.util.ArrayList;

public class StoreLocatorFragment extends Fragment implements OnClickListener {
	private EditText mSearchField;
	private TextView mXMark;
	private View mMicrofon;
	private ListView mListView;
	private ArrayList<DummyModel> searchableArrayList;


	public static StoreLocatorFragment newInstance() {
		return new StoreLocatorFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		searchableArrayList = DummyContent.getDummyModelList();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_store_locator, container, false);
		mSearchField = (EditText) rootView.findViewById(R.id.search_field);
		mXMark = (TextView) rootView.findViewById(R.id.search_x);
		mMicrofon = rootView.findViewById(R.id.search_microfon);
		mListView = (ListView) rootView.findViewById(R.id.list_view);

		mXMark.setOnClickListener(this);
		mMicrofon.setOnClickListener(this);

		mSearchField.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {

			}

			@SuppressLint("DefaultLocale")
			@Override
			public void afterTextChanged(Editable editable) {
				String searchText = editable.toString().trim();
				ArrayList<String> searchedArray = new ArrayList<String>();
				for (DummyModel dm : searchableArrayList) {
					if (dm.getText().toLowerCase().contains(searchText.toLowerCase())) {
						searchedArray.add(dm.getText());
					}
				}
				if (searchText.isEmpty()) {
					mListView.setAdapter(null);
					mXMark.setText(R.string.fontello_x_mark);
				} else {
					mListView.setAdapter(new SearchAdapter(getActivity(), searchedArray));
					mXMark.setText(R.string.fontello_x_mark_masked);
				}
			}
		});
		return rootView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.search_x:
			mSearchField.setText(null);
			break;
		case R.id.search_microfon:
			Toast.makeText(getActivity(), "Implement voice search", Toast.LENGTH_LONG)
					.show();
			break;
		}
	}
}
