package com.as.fortywest.dummy;

import android.content.Context;

import com.as.fortywest.R;
import com.as.fortywest.model.ARImageGalleryModel;
import com.as.fortywest.model.ProductCategory;
import com.as.fortywest.model.DrawerItem;
import com.as.fortywest.model.OfflineCatalogModal;
import com.as.fortywest.model.StoreModel;
import com.as.fortywest.model.StoreOpenHour;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DummyContent {

    public static ArrayList<DrawerItem> getDrawerShopDummyList() {
        ArrayList<DrawerItem> mDrawerItems = new ArrayList<>();
        mDrawerItems.add(new DrawerItem(R.drawable.ic_action_home,
                R.string.drawer_home,
                DrawerItem.DRAWER_ITEM_TAG_HOME));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_web,
                R.string.drawer_online_category,
                DrawerItem.DRAWER_ITEM_TAG_ONLINE_CATEGORY));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_circular,
                R.string.drawer_offline_category,
                DrawerItem.DRAWER_ITEM_TAG_OFFLINE_CATEGORY));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_scissors,
                R.string.drawer_deal,
                DrawerItem.DRAWER_ITEM_TAG_DEAL));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_location,
                R.string.drawer_store_finder,
                DrawerItem.DRAWER_ITEM_TAG_STORE_FINDER));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_business,
                R.string.drawer_cart,
                DrawerItem.DRAWER_ITEM_TAG_CART));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_shape,
                R.string.drawer_wishlist,
                DrawerItem.DRAWER_ITEM_TAG_WISH_LIST));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_people,
                R.string.drawer_account,
                DrawerItem.DRAWER_ITEM_TAG_MY_ACCOUNT));
        mDrawerItems.add(new DrawerItem(R.drawable.ic_action_settings,
                R.string.drawer_setting,
                DrawerItem.DRAWER_ITEM_TAG_SETTING));

        return mDrawerItems;
    }

    public static ArrayList<ARImageGalleryModel> getImageGalleryMusicCategories() {
        ArrayList<ARImageGalleryModel> imageGallerySubcategoryModels = new ArrayList<ARImageGalleryModel>();

        ARImageGalleryModel imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(0L);
        imageGallerySubcategoryModel.setTitle("Living room Scuba 1");
        imageGallerySubcategoryModel.setUrl("http://res-4.cloudinary.com/made-com/image/upload/c_pad,dpr_1.0,f_auto,h_395,q_90,w_750/ritchie_3seater_scuba_blue_lb6.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(1L);
        imageGallerySubcategoryModel.setTitle("Living room 2");
        imageGallerySubcategoryModel.setUrl("http://res-3.cloudinary.com/made-com/image/upload/c_pad,dpr_1.0,f_auto,h_500,q_90,w_965/ritchie_3seater_scuba_blue_lb_1.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(2L);
        imageGallerySubcategoryModel.setTitle("Living room Scuba 3");
        imageGallerySubcategoryModel.setUrl("http://res-4.cloudinary.com/made-com/image/upload/c_pad,dpr_1.0,f_auto,h_395,q_90,w_750/ritchie_3seater_scuba_blue_lb3.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(3L);
        imageGallerySubcategoryModel.setTitle("Living room 4");
        imageGallerySubcategoryModel.setUrl("http://res-2.cloudinary.com/made-com/image/upload/c_pad,dpr_1.0,f_auto,q_90/showroom_1.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(4L);
        imageGallerySubcategoryModel.setTitle("Kitchen 2");
        imageGallerySubcategoryModel.setUrl("http://media.made.com/media/catalog/category/resized/247x197/OUTDOOR.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(5L);
        imageGallerySubcategoryModel.setTitle("Bedroom 1");
        imageGallerySubcategoryModel.setUrl("http://media.made.com/media/catalog/category/resized/247x197/Beds_menu_Capri.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        return imageGallerySubcategoryModels;
    }

    public static ArrayList<DummyModel> getDummyModelDragAndDropShopList() {
        ArrayList<DummyModel> list = new ArrayList<>();

        list.add(new DummyModel(0, "http://pengaja.com/uiapptemplate/newphotos/shop/0.jpg", "Black Shirt", R.string.fontello_heart_empty));
        list.add(new DummyModel(1, "http://pengaja.com/uiapptemplate/newphotos/shop/1.jpg", "Black Sweater", R.string.fontello_heart_empty));
        list.add(new DummyModel(2, "http://pengaja.com/uiapptemplate/newphotos/shop/2.jpg", "Shirt", R.string.fontello_heart_empty));
        list.add(new DummyModel(3, "http://pengaja.com/uiapptemplate/newphotos/shop/3.jpg", "White Shirt", R.string.fontello_heart_empty));
        list.add(new DummyModel(4, "http://pengaja.com/uiapptemplate/newphotos/shop/4.jpg", "White T shirt", R.string.fontello_heart_empty));
        list.add(new DummyModel(5, "http://pengaja.com/uiapptemplate/newphotos/shop/5.jpg", "T shirt", R.string.fontello_heart_empty));
        list.add(new DummyModel(6, "http://pengaja.com/uiapptemplate/newphotos/shop/6.jpg", "Hoodies", R.string.fontello_heart_empty));

        return list;
    }

    public static ArrayList<DummyModel> getDummyModelList() {
        ArrayList<DummyModel> list = new ArrayList<>();

        list.add(new DummyModel(1, "", "Big Johns Furniture", R.string.fontello_heart_empty));
        list.add(new DummyModel(2, "", "De Beers Imports", R.string.fontello_heart_empty));
        list.add(new DummyModel(3, "", "Kellys Fine Furniture", R.string.fontello_heart_empty));
        list.add(new DummyModel(4, "", "Super Home Center", R.string.fontello_heart_empty));
        list.add(new DummyModel(5, "", "Italian Showroom", R.string.fontello_heart_empty));

        return list;
    }

    public static ArrayList<OfflineCatalogModal> getDummyOfflineCatalogList(){
        ArrayList<OfflineCatalogModal> returnList = new ArrayList<>();

        returnList.add(new OfflineCatalogModal(0, "Herman Miller Thrive Portfolio Catalog", "Herman_Miller_Thrive_Portfolio_Catalog.pdf", R.drawable.offline_catalog_herman));
        returnList.add(new OfflineCatalogModal(1, "IKEA Catalogue English 2016", "ikea_catalogue_en.pdf", R.drawable.offline_catalog_ikea_2016));
        returnList.add(new OfflineCatalogModal(2, "IKEA Catalogue English 2015", "ikea_catalogue_en.pdf", R.drawable.offline_catalog_ikea_2016));
        return returnList;

    }

    public static ArrayList<StoreModel> getDummyStoreList(){
        ArrayList<StoreModel> list = new ArrayList<>();
        List<StoreOpenHour> defaultHours = new ArrayList<>();
        defaultHours.add(new StoreOpenHour("Monday", "9:00 am", "4:00 pm"));
        defaultHours.add(new StoreOpenHour("Tuesday", "9:00 am", "4:00 pm"));
        defaultHours.add(new StoreOpenHour("Wedmesday", "9:00 am", "4:00 pm"));
        defaultHours.add(new StoreOpenHour("Thursday", "9:00 am", "10:00 pm"));
        defaultHours.add(new StoreOpenHour("Friday", "9:00 am", "4:00 pm"));
        defaultHours.add(new StoreOpenHour("Saturday", "9:00 am", "6:00 pm"));
        defaultHours.add(new StoreOpenHour("Sunday", "0", "0"));


        list.add(new StoreModel(1, "Big Johns Furniture", "0.06 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", R.drawable.ic_close, defaultHours));
        list.add(new StoreModel(2, "De Beers Imports", "2.5 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", R.drawable.ic_open, defaultHours));
        list.add(new StoreModel(3, "Kellys Fine Furniture", "4.2 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", R.drawable.ic_open, defaultHours));
        list.add(new StoreModel(4, "Super Home Center", "5.0 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", R.drawable.ic_close, defaultHours));
        list.add(new StoreModel(5, "Italian Showroom", "6.2 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", R.drawable.ic_open, defaultHours));

        return list;
    }

    public static ArrayList<DummyModel> getDummyModelListSocial() {
        ArrayList<DummyModel> list = new ArrayList<>();

        list.add(new DummyModel(0, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/0.jpg", "Jane Smith", R.string.fontello_heart_empty));
        list.add(new DummyModel(1, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/1.jpg", "Jane Smith", R.string.fontello_heart_empty));
        list.add(new DummyModel(2, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/2.jpg", "Jane Smith", R.string.fontello_heart_empty));
        list.add(new DummyModel(3, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/3.jpg", "Jane Smith", R.string.fontello_heart_empty));
        list.add(new DummyModel(4, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/4.jpg", "Jane Smith", R.string.fontello_heart_empty));
        list.add(new DummyModel(5, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/5.jpg", "Jane Smith", R.string.fontello_heart_empty));
        list.add(new DummyModel(6, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/6.jpg", "Jane Smith", R.string.fontello_heart_empty));
        list.add(new DummyModel(7, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/7.jpg", "Jane Smith", R.string.fontello_heart_empty));

        return list;
    }

    public static ArrayList<ProductCategory> getDummyCatalogList(){
        ArrayList<ProductCategory> returnList = new ArrayList<>();

        returnList.add(new ProductCategory(0, "Living Room", "livingroom", R.drawable.ic_web));
        returnList.add(new ProductCategory(1, "Dining Room", "diningroom", R.drawable.ic_web));
        returnList.add(new ProductCategory(2, "Bedroom", "bedroom", R.drawable.ic_web));
        returnList.add(new ProductCategory(3, "Home Office", "homeoffice" ,R.drawable.ic_web));
        returnList.add(new ProductCategory(4, "Home Decor", "homedecor",R.drawable.ic_web));
        returnList.add(new ProductCategory(5, "Kitchen", "kitchen", R.drawable.ic_web));
        returnList.add(new ProductCategory(6, "Kids", "kids", R.drawable.ic_web));
        returnList.add(new ProductCategory(7, "Misc.", "misc", R.drawable.ic_web));

        return returnList;

    }

    public static String loadProductJSONFromAsset(Context mContext) {
        String json = null;
        try {
            InputStream is = mContext.getAssets().open("json/data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
