package com.example.jihuiquan.newsagain.module.joke;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.joke.JokeInfo;
import com.example.jihuiquan.newsagain.data.joke.source.impl.JokeDataSourceImpl;
import com.example.jihuiquan.newsagain.databinding.FragmentJokeBinding;

/**
 * Created by jihuiquan on 2016/12/23.
 */

public class JokeFragment extends Fragment implements JokeContract.View{

    private FragmentJokeBinding jokeBinding;
    private JokeAdapter jokeAdapter;
    private static final String TAG = "JokeFragment";
    private JokeContract.Presenter jokePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        jokeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_joke, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        jokeBinding.rvContent.setLayoutManager(linearLayoutManager);
        jokePresenter = new JokePresenter(new JokeDataSourceImpl(), this);
        jokeAdapter =  new JokeAdapter();
        jokeBinding.rvContent.setAdapter(jokeAdapter);
        jokePresenter.loadData();
        initEvent();
        return jokeBinding.getRoot();
    }

    private void initEvent() {
        jokeBinding.swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                jokePresenter.loadData();
            }
        });
    }

    @Override
    public void loadSucceed(JokeInfo jokeInfo) {
        jokeAdapter.setJokes(jokeInfo);
        if (jokeBinding.swipeContainer.isRefreshing()) {
            jokeBinding.swipeContainer.setRefreshing(false);
        }
    }

    @Override
    public void loadFailed(String msg) {
        Toast.makeText(getActivity(),"加载失败！请重新加载",Toast.LENGTH_SHORT).show();
        if (jokeBinding.swipeContainer.isRefreshing()) {
            jokeBinding.swipeContainer.setRefreshing(false);
        }

    }
}
