package com.as.fortywest;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.as.fortywest.fragment.OfflineCatalogFragment;
import com.as.fortywest.fragment.ProductGalleryButtonsFragment;
import com.as.fortywest.model.DrawerItem;

public class ProductCatalogActivity extends AppCompatActivity {
    public static String CATEGORY_TYPE = "CategoryType";
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabpage_main);

        mHandler = new Handler();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle data = getIntent().getExtras();

        if(data != null){
            int categoryType = data.getInt(CATEGORY_TYPE);
            if(categoryType == DrawerItem.DRAWER_ITEM_TAG_ONLINE_CATEGORY){
                setActionBarTitle("Online Catalog");
                commitFragment(ProductGalleryButtonsFragment.newInstance());
            } else if(categoryType == DrawerItem.DRAWER_ITEM_TAG_OFFLINE_CATEGORY){
                setActionBarTitle("Offline Catalog");
                commitFragment(OfflineCatalogFragment.newInstance());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private class CommitFragmentRunnable implements Runnable {
        private Fragment fragment;
        public CommitFragmentRunnable(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void run() {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.online_placeholder, fragment).commit();
        }
    }

    public void commitFragment(Fragment fragment) {
        mHandler.post(new CommitFragmentRunnable(fragment));
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
