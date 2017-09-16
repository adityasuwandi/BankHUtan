package com.example.adityasuwandi.bankhutan.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.adityasuwandi.bankhutan.R;

/**
 * Created by root on 16/09/17.
 */

public class LoadMore extends ListView implements AbsListView.OnScrollListener {


    private static final String TAG = LoadMore.class
            .getSimpleName();

    private OnScrollListener mOnScrollListener;
    private LayoutInflater mInflater;

    private View mFooterView;
    private View mLoadMoreStatusView;

    private OnLoadMoreListener mOnLoadMoreListener;

    private boolean mIsLoadingMore = false;
    private int mCurrentScrollState;

    public LoadMore(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoadMore(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {

        mFooterView = mInflater.inflate(R.layout.loadmore,
                this, false);
        mLoadMoreStatusView = mFooterView.findViewById(R.id.loadMoreBar);
        addFooterView(mFooterView);
        setLoading(false);

        super.setAdapter(adapter);
    }

    private void init(Context context) {

        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        super.setOnScrollListener(this);
    }

    public void setLoadMoreStatusView(View v, int statusViewId) {
        removeFooterView(mFooterView);

        mFooterView = v;
        mLoadMoreStatusView = mFooterView.findViewById(statusViewId);
        addFooterView(mFooterView);
    }

    public void setLoadMoreStatusView(View v) {
        removeFooterView(mFooterView);

        mFooterView = v;
        mLoadMoreStatusView = mFooterView.findViewById(R.id.loadMoreBar);
        addFooterView(mFooterView);
    }

    /**
     * Set the listener that will receive notifications every time the list
     * scrolls.
     *
     * @param l The scroll listener.
     */
    @Override
    public void setOnScrollListener(AbsListView.OnScrollListener l) {
        mOnScrollListener = l;
    }

    /**
     * Register a callback to be invoked when this list reaches the end (last item
     * be visible)
     *
     * @param onLoadMoreListener The callback to run.
     */

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        mOnLoadMoreListener = onLoadMoreListener;
    }

    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {

        if (mOnScrollListener != null) {
            mOnScrollListener.onScroll(view, firstVisibleItem, visibleItemCount,
                    totalItemCount);
        }

        if (visibleItemCount == totalItemCount) {
            if (mLoadMoreStatusView != null) {
                mLoadMoreStatusView.setVisibility(View.GONE);
            }
            return;
        }

        if (mOnLoadMoreListener != null) {

            boolean loadMore = firstVisibleItem + visibleItemCount >= totalItemCount;

            if (!mIsLoadingMore && loadMore
                    && mCurrentScrollState != SCROLL_STATE_IDLE) {
                setLoading(true);
                onLoadMore();
            }
        }
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        mCurrentScrollState = scrollState;

        if (mOnScrollListener != null) {
            mOnScrollListener.onScrollStateChanged(view, scrollState);
        }
    }

    public void setLoading(boolean loading) {
        Log.d(TAG, "setLoading: " + loading);

        mIsLoadingMore = loading;
        mLoadMoreStatusView.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    public void onLoadMore() {
        Log.d(TAG, "onLoadMore");
        if (mOnLoadMoreListener != null) {
            mOnLoadMoreListener.onLoadMore();
        }
    }

    public void onLoadMoreComplete() {
        setLoading(false);
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

}
