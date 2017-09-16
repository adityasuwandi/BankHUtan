package com.example.adityasuwandi.bankhutan.adapters;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.example.adityasuwandi.bankhutan.fragments.HarvestFragment;
import com.example.adityasuwandi.bankhutan.fragments.InProgressFragment;
import com.example.adityasuwandi.bankhutan.fragments.NewTreeFragment;

/**
 * Created by root on 15/09/17.
 */

public class MyForestFragmentAdapter extends FragmentPagerAdapter {

    String[] title = new String[]{
            "New Tree", "In Progress", "Harvest"
    };

    private final Resources resources;

    SparseArray<Fragment> registeredFragments = new SparseArray<>();

    public MyForestFragmentAdapter(Resources resources,FragmentManager fm) {
        super(fm);
        this.resources = resources;
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
                fragment = new NewTreeFragment();
                break;
            case 1:
                fragment = new InProgressFragment();
                break;
            case 2:
                fragment = new HarvestFragment();
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
