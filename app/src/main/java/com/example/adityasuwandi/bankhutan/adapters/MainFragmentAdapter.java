package com.example.adityasuwandi.bankhutan.adapters;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.example.adityasuwandi.bankhutan.fragments.ArticleFragment;
import com.example.adityasuwandi.bankhutan.fragments.CatalogFragment;
import com.example.adityasuwandi.bankhutan.fragments.HomeFragment;
import com.example.adityasuwandi.bankhutan.fragments.MyForestFragment;
import com.example.adityasuwandi.bankhutan.fragments.ProfileFragment;

/**
 * Created by root on 15/09/17.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private final Resources resources;

    //nama tab nya
    String[] title = new String[]{
            "Home", "Article", "Catalog", "MyForest", "Profile"
    };


    SparseArray<Fragment> registeredFragments = new SparseArray<>();

    public MainFragmentAdapter(Resources resources, FragmentManager fragmentManager){
        super(fragmentManager);
        this.resources =resources;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    //method ini yang akan memanipulasi penampilan Fragment dilayar
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new ArticleFragment();
                break;
            case 2:
                fragment = new CatalogFragment();
                break;
            case 3:
                fragment = new MyForestFragment();
                break;
            case 4:
                fragment = new ProfileFragment();
                break;
            default:
                fragment = null;
                break;
        }

        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {

//        return title[position];
        return null;
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
