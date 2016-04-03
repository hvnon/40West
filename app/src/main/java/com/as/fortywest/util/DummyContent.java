package com.as.fortywest.util;

import com.as.fortywest.R;
import com.as.fortywest.model.ARImageGalleryModel;
import com.as.fortywest.model.DrawerItem;
import com.as.fortywest.model.DummyModel;
import com.as.fortywest.model.OfflineCatalogModal;
import com.as.fortywest.model.StoreModel;
import com.as.fortywest.model.StoreOpenHour;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {

    public static ArrayList<DrawerItem> getDrawerShopDummyList() {
        ArrayList<DrawerItem> mDrawerItems = new ArrayList<>();
        mDrawerItems.add(new DrawerItem(R.string.material_icon_home,
                R.string.drawer_home,
                DrawerItem.DRAWER_ITEM_TAG_HOME));
        mDrawerItems.add(new DrawerItem(R.string.material_icon_headline,
                R.string.drawer_category,
                DrawerItem.DRAWER_ITEM_TAG_OFFLINE_CATEGORY));
        mDrawerItems.add(new DrawerItem(R.string.material_icon_dollar,
                R.string.drawer_deal,
                DrawerItem.DRAWER_ITEM_TAG_DEAL));
        mDrawerItems.add(new DrawerItem(R.string.material_icon_shop,
                R.string.drawer_store_finder,
                DrawerItem.DRAWER_ITEM_TAG_STORE_FINDER));
//        mDrawerItems.add(new DrawerItem(R.string.material_icon_cart,
//                R.string.drawer_cart,
//                DrawerItem.DRAWER_ITEM_TAG_CART));
//        mDrawerItems.add(new DrawerItem(R.string.material_icon_star,
//                R.string.drawer_wishlist,
//                DrawerItem.DRAWER_ITEM_TAG_WISH_LIST));
//        mDrawerItems.add(new DrawerItem(R.string.material_icon_account,
//                R.string.drawer_account,
//                DrawerItem.DRAWER_ITEM_TAG_MY_ACCOUNT));
//        mDrawerItems.add(new DrawerItem(R.string.material_icon_settings,
//                R.string.drawer_setting,
//                DrawerItem.DRAWER_ITEM_TAG_SETTING));

        return mDrawerItems;
    }

    public static ArrayList<ARImageGalleryModel> getImageGalleryMusicCategories() {
        ArrayList<ARImageGalleryModel> imageGallerySubcategoryModels = new ArrayList<ARImageGalleryModel>();

        ARImageGalleryModel imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(0L);
        imageGallerySubcategoryModel.setTitle("Living room 1");
        imageGallerySubcategoryModel.setUrl("http://pengaja.com/uiapptemplate/violins/147587554_205e3ed653_o.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(1L);
        imageGallerySubcategoryModel.setTitle("Living room 2");
        imageGallerySubcategoryModel.setUrl("http://pengaja.com/uiapptemplate/violins/2322113757_808c904f04_o.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(2L);
        imageGallerySubcategoryModel.setTitle("Living room 3");
        imageGallerySubcategoryModel.setUrl("http://pengaja.com/uiapptemplate/violins/2323048092_b6c70654ef_o.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(3L);
        imageGallerySubcategoryModel.setTitle("Kitchen 1");
        imageGallerySubcategoryModel.setUrl("http://pengaja.com/uiapptemplate/violins/2348623142_af7802400f_b.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(4L);
        imageGallerySubcategoryModel.setTitle("Kitchen 2");
        imageGallerySubcategoryModel.setUrl("http://pengaja.com/uiapptemplate/violins/459221457_09e40e82a8_b.jpg");
        imageGallerySubcategoryModels.add(imageGallerySubcategoryModel);

        imageGallerySubcategoryModel = new ARImageGalleryModel();
        imageGallerySubcategoryModel.setId(5L);
        imageGallerySubcategoryModel.setTitle("Bedroom 1");
        imageGallerySubcategoryModel.setUrl("http://pengaja.com/uiapptemplate/violins/5950552903_7dbea63895_b.jpg");
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

        returnList.add(new OfflineCatalogModal(0, "Living Room", "LivingRoom.pdf"));
        returnList.add(new OfflineCatalogModal(1, "Kitchen", "Kitchen.pdf"));
        returnList.add(new OfflineCatalogModal(2, "Bed Room", "BedRoom.pdf"));

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


        list.add(new StoreModel(1, "Big Johns Furniture", "0.06 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", defaultHours));
        list.add(new StoreModel(2, "De Beers Imports", "2.5 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", defaultHours));
        list.add(new StoreModel(3, "Kellys Fine Furniture", "4.2 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", defaultHours));
        list.add(new StoreModel(4, "Super Home Center", "5.0 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", defaultHours));
        list.add(new StoreModel(5, "Italian Showroom", "6.2 mil away", "9017", "123 East St, Beverly Hills, CA, 90210", "555 555 555", "sales@bjc.com", defaultHours));

        return list;
    }
}
