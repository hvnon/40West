package com.as.fortywest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.as.fortywest.fragment.OfflineCatalogFragment;
import com.as.fortywest.model.OfflineCatalogModal;
import com.as.fortywest.model.StoreModel;

public class StoreDetailActivity extends AppCompatActivity {

    TextView storeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        // Set enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.store_detail_activity);

        storeName = (TextView) findViewById(R.id.store_name_text);

        Bundle data = getIntent().getExtras();
        if(data != null) {
            StoreModel storeModel = data.getParcelable(StoreLocatorActivity.TAG_STORE_OBJECT_PARCELABLE);
            storeName.setText(storeModel.getName());
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

}
