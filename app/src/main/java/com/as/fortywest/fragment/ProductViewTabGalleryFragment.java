/**
 * Created by slock on 4/6/2016.
 */

package com.as.fortywest.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.as.fortywest.R;
import com.as.fortywest.model.Product;
import com.as.fortywest.util.ImageUtil;

import static com.as.fortywest.util.LogUtils.makeLogTag;


public class ProductViewTabGalleryFragment extends ProductBaseFragment {
    private static final String TAG = makeLogTag(ProductViewTabGalleryFragment.class);
    private Product mProduct;
    private ImageView productImage;
    private TextView nameTextView;
    private TextView priceTextView;
    private TextView descriptionTextView;

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
        return R.layout.fragment_product_view_tab_info;
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_product_view_tab_info, container, false);

        productImage = (ImageView) root.findViewById(R.id.product_image);
        nameTextView = (TextView) root.findViewById(R.id.product_name);
        priceTextView = (TextView) root.findViewById(R.id.product_price);
        descriptionTextView = (TextView) root.findViewById(R.id.product_description);

        if(getSelectedProduct() != null){
            Product product = getSelectedProduct();
            ImageUtil.displayImage(productImage, product.getImage(), null);
            nameTextView.setText(product.getName());
            priceTextView.setText(product.getPrice());
            descriptionTextView.setText(product.getDescription());
        }
        return root;
    }


}