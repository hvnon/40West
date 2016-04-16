package com.as.fortywest.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.as.fortywest.Config;
import com.as.fortywest.ProductCatalogActivity;
import com.as.fortywest.ProductViewActivity;
import com.as.fortywest.R;
import com.as.fortywest.adapter.ProductGridAdapter;
import com.as.fortywest.dummy.DummyContent;
import com.as.fortywest.model.GalleryItem;
import com.as.fortywest.model.Product;
import com.as.fortywest.model.ResponseResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import static com.as.fortywest.util.LogUtils.LOGI;
import static com.as.fortywest.util.LogUtils.makeLogTag;


public class ProductGalleryFragment extends Fragment {

    public static final String CATALOG_TAG = "CATALOG_TAG";
    public static final String PREFERENCES_Gallery_FILE_NAME = "GalleryPreferences";
    private final String TAG = makeLogTag(ProductGalleryFragment.class);

    private GridView gridView;
    private ProductGridAdapter gridAdapter;
    ArrayList<Product> products;

    public static ProductGalleryFragment newInstance(String catalog) {
        ProductGalleryFragment f = new ProductGalleryFragment();

        Bundle args = new Bundle();
        args.putString(CATALOG_TAG, catalog);
        f.setArguments(args);

        return f;
    }

    public String getSelectedCatalogCode() {
        return getArguments().getString(CATALOG_TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_gallery, container, false);

        setHasOptionsMenu(true);
        this.setRetainInstance(true);

        // Set title bar
        ((ProductCatalogActivity) getActivity())
                .setActionBarTitle(getActionBarTitle(getSelectedCatalogCode()));

        new GalleryAsynTask().execute();
        return v;
    }

    private String getActionBarTitle(String currentCatalog){
        String actionTitle = "";
        if(currentCatalog == "livingroom"){
            actionTitle = "Living Room";
        } else if(currentCatalog == "diningroom"){
            actionTitle = "Dining Room";
        } else if(currentCatalog == "bedroom"){
            actionTitle = "Bedroom";
        } else if(currentCatalog == "homeoffice"){
            actionTitle = "Home Office";
        } else if(currentCatalog == "homedecor"){
            actionTitle = "Home Decor";
        } else if(currentCatalog == "kitchen"){
            actionTitle = "Kitchen";
        } else if(currentCatalog == "kids"){
            actionTitle = "Kids";
        } else if(currentCatalog == "misc"){
            actionTitle = "Misc";
        }

        return actionTitle;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.main, menu);
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            LOGI(TAG + "_40West-Gallery", "External device mounted");
            return true;
        }
        LOGI(TAG + "_40West-Gallery", "External device NOT mounted");
        return false;

    }


    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        LOGI(TAG + "_Gallery", "PAUSED");

    }

    public void onStop()
    {
        super.onStop();
        LOGI(TAG + "_Gallery", "STOPPED");

    }

    @Override
    public void onResume()
    {
        LOGI(TAG + "_Gallery", "RESUMED");
        super.onResume();

        // Set title bar
        ((ProductCatalogActivity) getActivity())
                .setActionBarTitle(getActionBarTitle(getSelectedCatalogCode()));
    }

    private class GalleryAsynTask extends AsyncTask<String, String, String> {
        int resultSize;
        protected String doInBackground(String... arg0) {
            StringBuilder serverSB = new StringBuilder();
            String jsonData = DummyContent.loadProductJSONFromAsset(getActivity());
            final GsonBuilder builder = new GsonBuilder();
            final Gson gson = builder.create();

            // Parse Object Data
            ResponseResult responseResult = gson.fromJson(jsonData, ResponseResult.class);
            products = responseResult.products;
            resultSize = products.size();

            return serverSB.toString();
        }

        protected void onPostExecute(String result) {
            LOGI(TAG, "onPostExecute");
            if (resultSize > 0) {
                gridView = (GridView) getView().findViewById(R.id.gridViewProducts);
                gridAdapter = new ProductGridAdapter(getActivity(), R.layout.grid_item_product, products);
                gridView.setAdapter(gridAdapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        Product item = (Product) parent.getItemAtPosition(position);

                        //Create intent
                        Intent intent = new Intent(getActivity(), ProductViewActivity.class);
                        intent.putExtra(ProductViewActivity.PRODUCT_ITEM, item);
                        startActivity(intent);
                    }
                });
            } else {
                Toast.makeText(getActivity(), "Cannot load Living Room product gallery at this time", Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();
            }
        }
    }
}
