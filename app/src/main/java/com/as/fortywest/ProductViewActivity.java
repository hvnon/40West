package com.as.fortywest;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.as.fortywest.fragment.ProductViewTabGalleryFragment;
import com.as.fortywest.fragment.ProductViewTabInfoFragment;
import com.as.fortywest.fragment.ProductViewTabSpecFragment;
import com.as.fortywest.model.Product;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


public class ProductViewActivity extends AppCompatActivity implements ActionBar.TabListener {
    public static String PRODUCT_ITEM = "Product_Item";
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        // Set FAB button
        setupFAB();

        // Enable actionbar back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set data receiving
        Bundle data = getIntent().getExtras();
        if(data != null){
            product = data.getParcelable(PRODUCT_ITEM);
        }

        // Add some tabview
        initActionBar();
    }

    @SuppressWarnings("deprecation")
    public void initActionBar() {
        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            actionBar.addTab(actionBar.newTab().setText(R.string.product_view_tab_info).setTabListener(this));
            actionBar.addTab(actionBar.newTab().setText(R.string.product_view_tab_spec).setTabListener(this));
            actionBar.addTab(actionBar.newTab().setText(R.string.product_view_tab_gallery).setTabListener(this));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        switch (tab.getPosition()){
            case 0:
                ft.replace(R.id.content_frame, ProductViewTabInfoFragment.newInstance(product));
              break;
            case 1:
                ft.replace(R.id.content_frame, ProductViewTabSpecFragment.newInstance(product));
                break;
            case 2:
                ft.replace(R.id.content_frame, ProductViewTabGalleryFragment.newInstance(product));
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_product_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupFAB() {
        final ImageView fabIconNew = new ImageView(this);
        fabIconNew.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_white_24dp));
        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconNew)
                .setBackgroundDrawable(R.drawable.button_action_red_selector)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        rLSubBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_action_blue_selector));

        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        ImageView rlIcon4 = new ImageView(this);
        ImageView rlIcon5 = new ImageView(this);

        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_action_star_rate));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_action_store));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_action_3d_rotation));
        rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_social_party_mode));
        rlIcon5.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_add_shopping_cart));

        SubActionButton subActionFavorite = rLSubBuilder.setContentView(rlIcon1).build();
        SubActionButton subActionShop = rLSubBuilder.setContentView(rlIcon2).build();
        SubActionButton subActionVR = rLSubBuilder.setContentView(rlIcon3).build();
        SubActionButton subActionAR = rLSubBuilder.setContentView(rlIcon4).build();
        SubActionButton subActionCart = rLSubBuilder.setContentView(rlIcon5).build();

        subActionFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Favourite clicked", Toast.LENGTH_SHORT).show();
            }
        });

        subActionShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Store clicked", Toast.LENGTH_SHORT).show();
            }
        });

        subActionVR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "VR clicked", Toast.LENGTH_SHORT).show();
            }
        });


        subActionAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "AR clicked", Toast.LENGTH_SHORT).show();
                String[] imageLocations = new String[0];
                Intent theIntent = new Intent (getApplication(), AugmentedActivity.class);
                theIntent.putExtra("MarkerPresent", "NO");
                theIntent.putExtra("ImagePath", product.getImage());
                theIntent.putExtra("productid",product.getId());
                theIntent.putExtra("PastTransaction",imageLocations );
                startActivity(theIntent);
            }
        });

        subActionCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cart clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Build the menu with default options: light theme, 90 degrees, 72dp radius.
        // Set 4 default SubActionButtons
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(subActionFavorite)
                .addSubActionView(subActionShop)
                .addSubActionView(subActionVR)
                .addSubActionView(subActionAR)
                .addSubActionView(subActionCart)
                .attachTo(rightLowerButton)
                .build();

        // Listen menu open and close events to animate the button content view
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                fabIconNew.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                fabIconNew.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }
        });
    }
}