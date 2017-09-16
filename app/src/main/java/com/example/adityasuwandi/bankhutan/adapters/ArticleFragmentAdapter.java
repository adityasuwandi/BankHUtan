package com.example.adityasuwandi.bankhutan.adapters;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.adityasuwandi.bankhutan.OnLoadMoreListener;
import com.example.adityasuwandi.bankhutan.R;
import com.example.adityasuwandi.bankhutan.serialized.ArticleData;

import java.util.List;

/**
 * Created by root on 15/09/17.
 */

public class ArticleFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private boolean isLoading;
    private OnLoadMoreListener onLoadMoreListener;
    private Activity activity;
    private List<ArticleData> articleDatas;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    public ArticleFragmentAdapter(RecyclerView recyclerView, List<ArticleData> articleDatas, Activity activity) {
        this.articleDatas = articleDatas;
        this.activity = activity;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {

                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }


                    isLoading = true;
                }
            }
        });
    }


    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return articleDatas.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(activity).inflate(R.layout.article_cardview, parent, false);
            return new UserViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(activity).inflate(R.layout.loadmore, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UserViewHolder) {
            ArticleData articleData = articleDatas.get(position);
            UserViewHolder userViewHolder = (UserViewHolder) holder;
            userViewHolder.title.setText(articleData.getTitle());
            userViewHolder.article.setText(articleData.getArticle());
        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return articleDatas == null ? 0 : articleDatas.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View view) {
            super(view);
            progressBar = (ProgressBar) view.findViewById(R.id.loadMoreBar);
        }
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView article;

        public UserViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_item_title);
            article = (TextView) view.findViewById(R.id.txt_item_article);
        }
    }

}
