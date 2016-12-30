package com.example.jihuiquan.newsagain.module.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.databinding.FragmentNewsBinding;

/**
 * Created by jihuiquan on 2016/12/23.
 */

public class NewsFragment extends Fragment {
    private static final String TAG = "NewsFragment";
    private NewsPagerAdapter newsPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentNewsBinding newsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_news, container, false);
        newsPagerAdapter = new NewsPagerAdapter(getFragmentManager());
        newsBinding.vpNews.setAdapter(newsPagerAdapter);
        newsBinding.pstsTitle.setViewPager(newsBinding.vpNews);
        return newsBinding.getRoot();
    }
}
