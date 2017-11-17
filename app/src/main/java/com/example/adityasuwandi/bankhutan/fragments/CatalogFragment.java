package com.example.adityasuwandi.bankhutan.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adityasuwandi.bankhutan.R;
import com.example.adityasuwandi.bankhutan.adapters.CatalogFragmentAdapter;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class CatalogFragment extends android.app.Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.catalogview);
        CatalogFragmentAdapter listAdapter = new CatalogFragmentAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
        }


    }




