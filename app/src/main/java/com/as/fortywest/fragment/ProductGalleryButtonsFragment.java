package com.as.fortywest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.as.fortywest.ProductCatalogActivity;
import com.as.fortywest.R;
import com.as.fortywest.util.ImageUtil;

import static com.as.fortywest.util.LogUtils.LOGI;

public class ProductGalleryButtonsFragment extends Fragment implements View.OnClickListener {

    LinearLayout livingRoom;
    LinearLayout diningRoom;
    LinearLayout kitchen;
    LinearLayout bedroom;
    LinearLayout misc;
    LinearLayout kids;
    LinearLayout homeDecor;
    LinearLayout homeOffice;

    View v;
    String category = "";

    public static ProductGalleryButtonsFragment newInstance() {
        return new ProductGalleryButtonsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_product_gallery_buttons, container, false);

        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivLivingRoomGalleryButton), "http://interiorzine.com/wp-content/uploads/2016/01/house-located-kharkiv-sbm-studio-19.jpg", null);
        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivDiningRoomGalleryButton), "http://st.hzcdn.com/simgs/b881af380e2f1fa3_8-5957/traditional-dining-room.jpg", null);
        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivKitchenGalleryButton), "http://interiorzine.com/wp-content/uploads/2015/11/kitchen-design-trends-2016-2017-onda-cayenne.jpg", null);
        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivBedroomGalleryButton), "http://cdn.home-designing.com/wp-content/uploads/2008/09/bedroom6.jpg", null);
        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivMiscGalleryButton), "http://interiorzine.com/wp-content/uploads/2015/12/three-level-spanish-style-house-9.jpg", null);
        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivKidsGalleryButton), "http://indiabright.com/wp-content/uploads/2015/11/Incredible-Yellow-and-Green-Kids-Bedroom-Sets.jpg", null);
        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivHomeDecorGalleryButton), "http://images.designtrends.com/wp-content/uploads/2016/03/03092403/Modern-Calssic-Living-Room-Design.jpeg", null);
        ImageUtil.displayImage((ImageView) v.findViewById(R.id.ivHomeOfficeGalleryButton), "http://office-turn.com/wp-content/uploads/2011/12/compact-home-Office-furniture-New-York.jpg", null);



        // add more listeners here when more buttons are added
        livingRoom = (LinearLayout) v.findViewById(R.id.LivingRoomGalleryButton);
        diningRoom = (LinearLayout) v.findViewById(R.id.DiningRoomGalleryButton);
        kitchen = (LinearLayout) v.findViewById(R.id.KitchenGalleryButton);
        bedroom = (LinearLayout) v.findViewById(R.id.BedroomGalleryButton);
        misc = (LinearLayout) v.findViewById(R.id.MiscGalleryButton);
        kids = (LinearLayout) v.findViewById(R.id.KidsGalleryButton);
        homeDecor = (LinearLayout) v.findViewById(R.id.HomeDecorGalleryButton);
        homeOffice = (LinearLayout) v.findViewById(R.id.HomeOfficeGalleryButton);

        livingRoom.setOnClickListener(this);
        diningRoom.setOnClickListener(this);
        kitchen.setOnClickListener(this);
        bedroom.setOnClickListener(this);
        misc.setOnClickListener(this);
        kids.setOnClickListener(this);
        homeDecor.setOnClickListener(this);
        homeOffice.setOnClickListener(this);

        setHasOptionsMenu(true);

        // Set Actionbar title for Online Category
        ((ProductCatalogActivity) getActivity()).setActionBarTitle("Online Catalog");

        return v;
    }

    @Override
    public void onClick(View v) {
        String backStack = "";
        switch (v.getId()) {
            case R.id.LivingRoomGalleryButton:
                backStack = "livingroomfragment";
                category = "livingroom";
                break;

            case R.id.BedroomGalleryButton:
                backStack = "bedroomfragment";
                category = "bedroom";
                break;

            case R.id.DiningRoomGalleryButton:
                backStack = "diningroomfragment";
                category = "diningroom";
                break;

            case R.id.KitchenGalleryButton:
                backStack = "kitchenfragment";
                category = "kitchen";
                break;

            case R.id.KidsGalleryButton:
                backStack = "kidsfragment";
                category = "kids";
                break;

            case R.id.HomeDecorGalleryButton:
                backStack = "homedecorfragment";
                category = "homedecor";
                break;

            case R.id.HomeOfficeGalleryButton:
                backStack = "homeofficefragment";
                category = "homeoffice";
                break;

            case R.id.MiscGalleryButton:
                backStack = "miscfragment";
                category = "misc";
                break;
        }

        ProductGalleryFragment sgf = ProductGalleryFragment.newInstance(category);
        FragmentManager sfm = getFragmentManager();
        FragmentTransaction sft = sfm.beginTransaction();
        sft.replace(R.id.online_placeholder, sgf);

        if(backStack != ""){
            sft.addToBackStack(backStack);
        }
        sft.commit();
    }



}
