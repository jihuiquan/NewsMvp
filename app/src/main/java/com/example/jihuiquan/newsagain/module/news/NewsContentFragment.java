package com.example.jihuiquan.newsagain.module.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.news.NewsInfo;
import com.example.jihuiquan.newsagain.data.news.source.impl.NewsDataSourceImpl;
import com.example.jihuiquan.newsagain.databinding.FragmentNewsItemBinding;

/**
 * Created by jihuiquan on 2016/12/28.
 */

public class NewsContentFragment extends Fragment implements NewsContract.View{
    private String type;
    private NewsAdapter newsAdapter;
    private static final String TAG = "NewsContentFragment";
    private FragmentNewsItemBinding itemBinding;
    private NewsContract.Presenter newsPresenter;

    public static NewsContentFragment newInstance(String type) {

        Bundle args = new Bundle();
        NewsContentFragment fragment = new NewsContentFragment();
        args.putString("TYPE", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            type = args.getString("TYPE");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_item, container, false);
        itemBinding = DataBindingUtil.bind(view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        newsAdapter = new NewsAdapter();
        itemBinding.rvContent.setLayoutManager(linearLayoutManager);
        itemBinding.rvContent.setAdapter(newsAdapter);
        newsPresenter = new NewsPresenter(new NewsDataSourceImpl(), this);
        newsPresenter.loadData(type);
        initEvent();
        return view;
    }


    @Override
    public void loadSucceed(NewsInfo newsInfo) {
        newsAdapter.setNews(newsInfo);
        if (itemBinding.swipeContainer.isRefreshing()) {
            itemBinding.swipeContainer.setRefreshing(false);
        }
    }

    @Override
    public void loadFailed(String failedMsg) {

    }
    private void initEvent() {
        itemBinding.swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsPresenter.loadData(type);
            }
        });
    }
}
