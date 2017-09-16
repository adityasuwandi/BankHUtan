package com.example.adityasuwandi.bankhutan;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.support.v4.app.FragmentTransaction;


import com.example.adityasuwandi.bankhutan.fragments.ArticleFragment;
import com.example.adityasuwandi.bankhutan.fragments.CatalogFragment;
import com.example.adityasuwandi.bankhutan.fragments.HomeFragment;
import com.example.adityasuwandi.bankhutan.fragments.MyForestFragment;
import com.example.adityasuwandi.bankhutan.fragments.ProfileFragment;

public class CobaActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        bottomNavigation = (BottomNavigationView) findViewById(R.id.navigations);
        //bottomNavigation.inflateMenu(R.menu.navigation);
        fragmentManager = getSupportFragmentManager();

        //Untuk inisialisasi fragment pertama kali
        fragmentManager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        //Memberikan listener saat menu item di bottom navigation diklik
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_artikel:
                fragment = new ArticleFragment();
                break;
            case R.id.navigation_katalog:
                fragment = new CatalogFragment();
                break;
            case R.id.navigation_myforest:
                fragment = new MyForestFragment();
                break;
            case R.id.navigation_profil:
                fragment = new ProfileFragment();
                break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container, fragment).commit();
                return true;
            }
        });
    }
}




//    private static final String SELECTED_ITEM = "arg_selected_item";
//    private BottomNavigationView navigationView;
//    private int selectedItem;
//    public static Activity main = null;
//    private final String TAG_HOME = "tag_home";
//    private final String TAG_PROFILE = "tag_profile";
//    private final String TAG_CATALOG = "tag_catalog";
//    private final String TAG_ARTICLE = "tag_article";
//    private final String TAG_MYFOREST = "tag_myforest";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_coba);
//        main = CobaActivity.this;
//        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                selectFragment(item);
//                return true;
//            }
//        });
//
//        MenuItem selectedMenu;
//        if (savedInstanceState != null) {
//            selectedItem = savedInstanceState.getInt(SELECTED_ITEM, 1);
//            selectedMenu = navigationView.getMenu().findItem(selectedItem);
//        } else {
//            selectedMenu = navigationView.getMenu().getItem(1);
//        }
//        selectFragment(selectedMenu);
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        MenuItem scanItem = navigationView.getMenu().getItem(1);
//        if (selectedItem != scanItem.getItemId()) {
//            // select home item
//            selectFragment(scanItem);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    private void selectFragment(MenuItem item) {
//        Fragment frag = null;
//        // init corresponding fragment
//        switch (item.getItemId()) {
//            case R.id.navigation_home:
//                frag = HomeFragment.newInstance();
//                break;
//            case R.id.navigation_artikel:
//                frag = ArticleFragment.newInstance();
//                break;
//            case R.id.navigation_katalog:
//                frag = CatalogFragment.newInstance();
//                break;
//            case R.id.navigation_myforest:
//                frag = MyForestFragment.newInstance();
//                break;
//            case R.id.navigation_profil:
//                frag = ProfileFragment.newInstance();
//                break;
//        }
//        // update selected item
//        selectedItem = item.getItemId();
//
//        // uncheck the other items.
//        for (int i = 0; i< navigationView.getMenu().size(); i++) {
//            MenuItem menuItem = navigationView.getMenu().getItem(i);
//            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
//        }
//        if (frag != null) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.container, frag);
//            ft.commit();
//        }
//    }





