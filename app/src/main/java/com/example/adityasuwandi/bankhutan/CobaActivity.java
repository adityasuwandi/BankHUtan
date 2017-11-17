package com.example.adityasuwandi.bankhutan;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.support.v4.app.FragmentTransaction;


import com.example.adityasuwandi.bankhutan.fragments.ArticleFragment;
import com.example.adityasuwandi.bankhutan.fragments.CatalogFragment;
import com.example.adityasuwandi.bankhutan.fragments.CatalogTree;
import com.example.adityasuwandi.bankhutan.fragments.HomeFragment;
import com.example.adityasuwandi.bankhutan.fragments.MyForestFragment;
import com.example.adityasuwandi.bankhutan.fragments.ProfileFragment;

public class CobaActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "arg_selected_item";
    private BottomNavigationView navigationView;
    private int selectedItem;
    public static Activity main = null;
    private final String TAG_HOME = "tag_home";
    private final String TAG_PROFILE = "tag_profile";
    private final String TAG_CATALOG = "tag_catalog";
    private final String TAG_ARTICLE = "tag_article";
    private final String TAG_MYFOREST = "tag_myforest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);
        main = CobaActivity.this;
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedMenu;
        if (savedInstanceState != null) {
            selectedItem = savedInstanceState.getInt(SELECTED_ITEM, 1);
            selectedMenu = navigationView.getMenu().findItem(selectedItem);
        } else {
            selectedMenu = navigationView.getMenu().getItem(1);
        }
        selectFragment(selectedMenu);

    }

    @Override
    public void onBackPressed() {
        MenuItem scanItem = navigationView.getMenu().getItem(1);
        if (selectedItem != scanItem.getItemId()) {
            // select home item
            selectFragment(scanItem);
        } else {
            super.onBackPressed();
        }
    }

    public void selectFragment(MenuItem item) {
        android.app.Fragment frag = null;
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.navigation_home:
                frag = new CatalogTree();
                break;
            case R.id.navigation_artikel:
                frag = new ArticleFragment();
                break;
            case R.id.navigation_katalog:
                frag = new CatalogFragment();
                break;
            case R.id.navigation_myforest:
                frag = new MyForestFragment();
                break;
            case R.id.navigation_profil:
                frag = new ProfileFragment();
                break;
        }
        // update selected item
        selectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i< navigationView.getMenu().size(); i++) {
            MenuItem menuItem = navigationView.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }
        if (frag != null) {
            android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.container, frag);
            ft.commit();
        }
    }




}
