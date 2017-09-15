package com.example.adityasuwandi.bankhutan.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adityasuwandi.bankhutan.BackPressImplement;
import com.example.adityasuwandi.bankhutan.OnBackPressListener;
import com.example.adityasuwandi.bankhutan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootFragment extends Fragment implements OnBackPressListener {

    @Override
    public boolean onBackPressed() {
        return new BackPressImplement(this).onBackPressed();
    }
}
