/**
 * Created by slock on 4/6/2016.
 */

package com.as.fortywest.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.as.fortywest.R;
import com.as.fortywest.dummy.DummyContent;
import com.as.fortywest.model.Product;
import com.as.fortywest.util.ImageUtil;

import static com.as.fortywest.util.LogUtils.makeLogTag;


public class ProductViewTabSpecFragment extends ProductBaseFragment {
    private static final String TAG = makeLogTag(ProductViewTabSpecFragment.class);
    private Product mProduct;
    private WebView spec;

    public static ProductViewTabSpecFragment newInstance(Product product) {
        ProductViewTabSpecFragment f = new ProductViewTabSpecFragment();

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
        View root = inflater.inflate(R.layout.fragment_product_view_tab_spec, container, false);
        spec = (WebView) root.findViewById(R.id.product_spec);
        if(getSelectedProduct() != null){
            Product product = getSelectedProduct();
            String mimeType = "text/html";
            String encoding = "utf-8";
            spec.loadData(DummyContent.loadHtmlFromAsset(getContext(), "product_spec.html"), mimeType, encoding);
        }
        return root;
    }


}