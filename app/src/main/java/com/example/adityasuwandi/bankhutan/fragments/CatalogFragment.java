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
public class CatalogFragment extends Fragment {

    public static Fragment newInstance() {
        Fragment frag = new ArticleFragment();
        return frag;
    }
//

    public CatalogFragment() {
        // Required empty public constructor
    }
//

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
