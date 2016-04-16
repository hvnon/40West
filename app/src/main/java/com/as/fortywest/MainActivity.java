package com.as.fortywest;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.as.fortywest.adapter.DrawerAdapter;
import com.as.fortywest.fragment.StoreLocatorFragment;
import com.as.fortywest.model.DrawerItem;
import com.as.fortywest.dummy.DummyContent;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<DrawerItem> mDrawerItems;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private Handler mHandler;
    private boolean mShouldFinish = false;

    private static final int ZXING_CAMERA_PERMISSION = 1;
    private Class<?> mClss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar(savedInstanceState);

        ImageLoader imageLoader = ImageLoader.getInstance();
        if (!imageLoader.isInited()) {
            imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        }
    }

    private void setupToolbar(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set Actionbar icon & title
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Initial Drawer menu data
        mDrawerItems = DummyContent.getDrawerShopDummyList();
        mTitle = mDrawerTitle = getTitle();
        mDrawerList = (ListView) findViewById(R.id.list_view);
        mDrawerList.getLayoutParams().width = (int) getResources().getDimension(R.dimen.drawer_width);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                supportInvalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new DrawerAdapter(this, mDrawerItems, true));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mHandler = new Handler();

        // Set Drawer state
        if (savedInstanceState == null) {
            mDrawerLayout.openDrawer(mDrawerList);
        }
    }


    @Override
    public void onBackPressed() {
        if (!mShouldFinish && !mDrawerLayout.isDrawerOpen(mDrawerList)) {
            Toast.makeText(getApplicationContext(), R.string.confirm_exit, Toast.LENGTH_SHORT).show();
            mShouldFinish = true;
            mDrawerLayout.openDrawer(mDrawerList);
        } else if (!mShouldFinish && mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_help:
                TextView content = (TextView) getLayoutInflater().inflate(R.layout.about_view, null);
                content.setMovementMethod(LinkMovementMethod.getInstance());
                content.setText(Html.fromHtml(getString(R.string.about_body)));
                new AlertDialog.Builder(this)
                        .setTitle(R.string.about)
                        .setView(content)
                        .setInverseBackgroundForced(true)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
            default:
                if (mDrawerToggle.onOptionsItemSelected(item)) {
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position, mDrawerItems.get(position).getTag(), view);
        }
    }

    private void selectItem(int position, int drawerTag, View view) {

        // Specific the Activities Navigate
        switch (drawerTag) {
            case DrawerItem.DRAWER_ITEM_TAG_ONLINE_CATEGORY:
                launchOnlineCatalog(view);
                break;
            case DrawerItem.DRAWER_ITEM_TAG_OFFLINE_CATEGORY:
                launchOfflineCatalogActivity(view);
                break;
            case DrawerItem.DRAWER_ITEM_TAG_DEAL:
                launchDealActivity(view);
                break;
            case DrawerItem.DRAWER_ITEM_TAG_STORE_FINDER:
                launchStoreLocatorActivity(view);
                break;
            default:
                Fragment fragment = getFragmentByDrawerTag(drawerTag);
                commitFragment(fragment);
                break;
        }

        mDrawerList.setItemChecked(position, true);
        setTitle(mDrawerItems.get(position).getTitle());
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private Fragment getFragmentByDrawerTag(int drawerTag) {
        Fragment fragment;
//        if (drawerTag == DrawerItem.DRAWER_ITEM_TAG_OFFLINE_CATEGORY) {
//            fragment = OfflineCatalogFragment.newInstance();
//        } else if (drawerTag == DrawerItem.DRAWER_ITEM_TAG_ONLINE_CATEGORY) {
//            fragment = OnlineCatalogFragment.newInstance();
//        } else
        if (drawerTag == DrawerItem.DRAWER_ITEM_TAG_STORE_FINDER) {
            fragment = StoreLocatorFragment.newInstance();
        } else {
            fragment = new Fragment();
        }
        mShouldFinish = false;
        return fragment;
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
                    .replace(R.id.content_frame, fragment).commit();
        }
    }

    public void commitFragment(Fragment fragment) {
        // Using Handler class to avoid lagging while
        // committing fragment in same time as closing
        // navigation drawer
        mHandler.post(new CommitFragmentRunnable(fragment));
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void launchCameraActivity(Class<?> clss) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            mClss = clss;
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        } else {
            Intent intent = new Intent(this, clss);
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ZXING_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(mClss != null) {
                        Intent intent = new Intent(this, mClss);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this, "Please grant camera permission to use the QR Scanner", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    public void launchQRScanActivity(View v) {
        launchCameraActivity(QRScannerActivity.class);
    }

    public void launchSavedARActivity(View v) {
        Intent intent = new Intent(this, ARImageGalleryActivity.class);
        startActivity(intent);
    }

    public void launchOfflineCatalogActivity(View v) {
        Intent intent = new Intent(this, ProductCatalogActivity.class);
        intent.putExtra(ProductCatalogActivity.CATEGORY_TYPE, DrawerItem.DRAWER_ITEM_TAG_OFFLINE_CATEGORY);
        startActivity(intent);
    }

    public void launchDealActivity(View v) {
        Intent intent = new Intent(this, DealsActivity.class);
        startActivity(intent);
    }

    public void launchStoreLocatorActivity(View v) {
        Intent intent = new Intent(this, StoreLocatorActivity.class);
        startActivity(intent);
    }

    public void launchOnlineCatalog(View v) {
        Intent intent = new Intent(this, ProductCatalogActivity.class);
        intent.putExtra(ProductCatalogActivity.CATEGORY_TYPE, DrawerItem.DRAWER_ITEM_TAG_ONLINE_CATEGORY);
        startActivity(intent);
    }
}
