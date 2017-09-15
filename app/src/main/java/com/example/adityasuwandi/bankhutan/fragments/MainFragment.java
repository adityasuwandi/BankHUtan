package com.example.adityasuwandi.bankhutan.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adityasuwandi.bankhutan.R;
import com.example.adityasuwandi.bankhutan.adapters.MainFragmentAdapter;

public class MainFragment extends Fragment {

    protected ViewPager pager;
    private AppCompatActivity appCompatActivity;
    private Toolbar toolbar;
    private TabLayout tabs;
    private MainFragmentAdapter adapter;
    private int image[] = new int[7];
    private int image_pressed[] = new int[7];
    private boolean first_time = true;
    public MainFragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //indicator = (TabPageIndicator) rootView.findViewById(R.id.tpi_header);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        appCompatActivity = (AppCompatActivity) getView().getContext();
        toolbar = getView().findViewById(R.id.tool_bar_new);
        tabs = getView().findViewById(R.id.tabs_new);
        pager =  getView().findViewById(R.id.pager_new);
        appCompatActivity.setSupportActionBar(toolbar);

        // Note that we are passing childFragmentManager, not FragmentManager
        adapter = new MainFragmentAdapter(getResources(),getChildFragmentManager());

        pager.setAdapter(adapter);

        tabs.setupWithViewPager(pager);

        image[0] = R.drawable.profile_button;
        image[1] = R.drawable.borrow_button;
        image[2] = R.drawable.lend_button;
        image[3] = R.drawable.library_button;
        image[4] = R.drawable.newbook_button;

        image_pressed[0] = R.drawable.profile_button_pressed;
        image_pressed[1] = R.drawable.borrow_button_pressed;
        image_pressed[2] = R.drawable.lend_button_pressed;
        image_pressed[3] = R.drawable.library_button_pressed;
        image_pressed[4] = R.drawable.newbook_button_pressed;

        for(int i=0; i<tabs.getTabCount(); i++)
            tabs.getTabAt(i).setIcon(image[i]);

        if(first_time == true)
        {
            tabs.getTabAt(0).setIcon(image_pressed[0]);
            appCompatActivity.getSupportActionBar().setTitle("Home");
            first_time = false;
        }

        tabs.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(pager){

                    @Override
                    public void onTabSelected(TabLayout.Tab tab)
                    {
                        super.onTabSelected(tab);
                        int tabnumberselected = tab.getPosition();
                        switch (tabnumberselected)
                        {
                            case 0 : {
                                tabs.getTabAt(0).setIcon(image_pressed[0]);
                                appCompatActivity.getSupportActionBar().setTitle("Home");
                                break;
                            }
                            case 1 : {
                                tabs.getTabAt(1).setIcon(image_pressed[1]);
                                appCompatActivity.getSupportActionBar().setTitle("Article");
                                break;
                            }
                            case 2: {
                                tabs.getTabAt(2).setIcon(image_pressed[2]);
                                appCompatActivity.getSupportActionBar().setTitle("Catalog");
                                break;
                            }
                            case 3: {
                                tabs.getTabAt(3).setIcon(image_pressed[3]);
                                appCompatActivity.getSupportActionBar().setTitle("My Forest");
                                break;
                            }
                            case 4: {
                                tabs.getTabAt(4).setIcon(image_pressed[4]);
                                appCompatActivity.getSupportActionBar().setTitle("Profile");
                                break;
                            }
                        }
                    }

                    ////

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab)
                    {
                        super.onTabUnselected(tab);
                        int tabnumberunselected = tab.getPosition();
                        switch (tabnumberunselected)
                        {
                            case 0 : {
                                if(first_time == false)
                                    tabs.getTabAt(0).setIcon(image[0]);
                                break;
                            }
                            case 1 :
                                tabs.getTabAt(1).setIcon(image[1]);
                                break;
                            case 2:
                                tabs.getTabAt(2).setIcon(image[2]);
                                break;
                            case 3:
                                tabs.getTabAt(3).setIcon(image[3]);
                                break;
                            case 4:
                                tabs.getTabAt(4).setIcon(image[4]);
                                break;
                        }

                    }

                }
        );

}
