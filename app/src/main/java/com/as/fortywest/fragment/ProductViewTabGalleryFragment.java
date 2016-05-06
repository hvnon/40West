/**
 * Created by slock on 4/6/2016.
 */

package com.as.fortywest.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.as.fortywest.R;
import com.as.fortywest.adapter.ARImageGalleryAdapter;
import com.as.fortywest.dummy.DummyContent;
import com.as.fortywest.model.ARImageGalleryModel;
import com.as.fortywest.model.Product;
import com.as.fortywest.util.ImageUtil;

import java.util.ArrayList;

import static com.as.fortywest.util.LogUtils.makeLogTag;


public class ProductViewTabGalleryFragment extends ProductBaseFragment {
    private static final String TAG = makeLogTag(ProductViewTabGalleryFragment.class);
    private Product mProduct;
    private ArrayList<ARImageGalleryModel> mSubcategories;
    private ListView mListView;
    private boolean mIsLayoutOnTop = true;

    public static ProductViewTabGalleryFragment newInstance(Product product) {
        ProductViewTabGalleryFragment f = new ProductViewTabGalleryFragment();

        Bundle args = new Bundle();
        args.putParcelable(PRODUCT_TAG, product);
        f.setArguments(args);

        return f;
    }

    public Product getSelectedProduct() {
        return getArguments().getParcelable(PRODUCT_TAG);
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.list_view;
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.list_view, container, false);

        mListView = (ListView) root.findViewById(R.id.list_view);
        // mSubcategories = DummyContent.getImageGalleryProduct();

        if(getSelectedProduct() != null){
            Product product = getSelectedProduct();

            mSubcategories = new ArrayList<ARImageGalleryModel>();

            ARImageGalleryModel imageGallerySubcategoryModel = new ARImageGalleryModel();
            imageGallerySubcategoryModel.setId(4L);
            imageGallerySubcategoryModel.setTitle("Picture 1");
            imageGallerySubcategoryModel.setUrl(product.getImage());
            mSubcategories.add(imageGallerySubcategoryModel);

            setAdapter();
        }
        return root;
    }

    private void setAdapter() {
        BaseAdapter adapter = new ARImageGalleryAdapter(getContext(), mSubcategories, mIsLayoutOnTop);
        mListView.setAdapter(adapter);
    }


}