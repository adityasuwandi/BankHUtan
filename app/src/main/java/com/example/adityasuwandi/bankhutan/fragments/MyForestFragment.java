package com.example.adityasuwandi.bankhutan.fragments;


import android.app.Activity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.example.adityasuwandi.bankhutan.CobaActivity;
import com.example.adityasuwandi.bankhutan.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyForestFragment extends Fragment {

    private static final String SELECTED_ITEM = "arg_selected_item";
    private BottomNavigationView navigationView;
    private int selectedItem;
    public static Activity main = null;
    private final String TAG_MYTREE = "tag_mytree";
    private final String TAG_INPROGRESS = "tag_inProgress";
    private final String TAG_CATALOG = "tag_harvest";

    public static Fragment newInstance() {
        Fragment frag = new MyForestFragment();
        return frag;
    }

//    private TabLayout tabs;
//    private MyForestFragmentAdapter adapter;
//    protected ViewPager viewPager;
//    private boolean first_time = true;
//    private AppCompatActivity appCompatActivity;

    public MyForestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_forest, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
