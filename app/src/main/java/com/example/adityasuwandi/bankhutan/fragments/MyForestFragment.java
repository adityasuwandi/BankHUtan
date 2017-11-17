package com.example.adityasuwandi.bankhutan.fragments;



import android.os.Bundle;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v4.app.Fragment;


import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;



import com.example.adityasuwandi.bankhutan.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyForestFragment extends android.app.Fragment {

//    private static final String SELECTED_ITEM = "arg_selected_item";
//    private BottomNavigationView navigationView;
//    private int selectedItem;
//    public static Activity main = null;
//    private final String TAG_MYTREE = "tag_mytree";
//    private final String TAG_INPROGRESS = "tag_inProgress";
//    private final String TAG_CATALOG = "tag_harvest";

//    public static Fragment newInstance() {
//        Fragment frag = new MyForestFragment();
//        return frag;
//    }

//    private TabLayout tabs;
//    private MyForestFragmentAdapter adapter;
//    protected ViewPager viewPager;
//    private boolean first_time = true;
//    private AppCompatActivity appCompatActivity;

    public MyForestFragment() {
        // Required empty public constructor
    }
    public WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_my_forest, container, false);
        mWebView = (WebView) v.findViewById(R.id.webart);
        mWebView.loadUrl("https://adityasuwandi.github.io/webBankHutan/apus");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
