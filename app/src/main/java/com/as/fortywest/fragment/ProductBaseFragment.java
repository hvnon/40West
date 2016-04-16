package com.as.fortywest.fragment;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v4.app.Fragment;
import com.as.fortywest.R;
import com.as.fortywest.model.Product;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Created by slock on 4/15/2016.
 */
public abstract class ProductBaseFragment extends Fragment {
    public static final String PRODUCT_TAG = "Product";
    protected abstract int getFragmentLayout();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }
}
