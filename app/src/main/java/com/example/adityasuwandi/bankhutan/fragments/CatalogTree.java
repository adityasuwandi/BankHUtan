package com.example.adityasuwandi.bankhutan.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adityasuwandi.bankhutan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogTree extends android.app.Fragment {
    private TextView mTreeName ;
    private TextView mTreeDesc ;
    public  CatalogTree()  {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.catalog_tree, container, false);
    }

}
