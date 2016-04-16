package com.as.fortywest.model;

public class DrawerItem {
	public static final int DRAWER_ITEM_TAG_HOME = 13;
	public static final int DRAWER_ITEM_TAG_ABOUT = 10;
	public static final int DRAWER_ITEM_TAG_MY_ACCOUNT = 11;
	public static final int DRAWER_ITEM_TAG_SETTING = 12;


	public static final int DRAWER_ITEM_TAG_ONLINE_CATEGORY = 26;
	public static final int DRAWER_ITEM_TAG_OFFLINE_CATEGORY = 20;
	public static final int DRAWER_ITEM_TAG_DEAL = 21;
	public static final int DRAWER_ITEM_TAG_CART = 22;
	public static final int DRAWER_ITEM_TAG_WISH_LIST = 23;
	public static final int DRAWER_ITEM_TAG_SCAN_QR = 24;
	public static final int DRAWER_ITEM_TAG_STORE_FINDER = 25;



	public DrawerItem(int icon, int title, int tag) {
		this.icon = icon;
		this.title = title;
		this.tag = tag;
	}

	private int icon;
	private int title;
	private int tag;

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}
}
