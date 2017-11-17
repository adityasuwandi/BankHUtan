package com.example.adityasuwandi.bankhutan.adapters;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.adityasuwandi.bankhutan.DataKatalog;
import com.example.adityasuwandi.bankhutan.OnLoadMoreListener;
import com.example.adityasuwandi.bankhutan.R;
import com.example.adityasuwandi.bankhutan.fragments.CatalogFragment;
import com.example.adityasuwandi.bankhutan.fragments.CatalogTree;
import com.example.adityasuwandi.bankhutan.serialized.ArticleData;

import org.w3c.dom.Text;

/**
 * Created by root on 15/09/17.
 */
public class CatalogFragmentAdapter extends RecyclerView.Adapter{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_cardview, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataKatalog.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mCatalogTitle;
        private TextView mCatalogText;
        private ImageView mImageView;
        public ListViewHolder(View itemView) {
            super(itemView);
            mCatalogTitle = (TextView) itemView.findViewById(R.id.catalogtitle);
            mCatalogText = (TextView) itemView.findViewById(R.id.catalogtext);
            mImageView = (ImageView) itemView.findViewById(R.id.catalogimg);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mCatalogTitle.setText(DataKatalog.title[position]);
            mCatalogText.setText(DataKatalog.text[position]);
            mImageView.setImageResource(DataKatalog.picturePath[position]);

        }
        public void onClick(View view){

        }
    }
}


