package com.example.jihuiquan.newsagain.module.history;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.history.HistoryInfo;
import com.example.jihuiquan.newsagain.data.history.source.impl.HistoryDataSourceImpl;
import com.example.jihuiquan.newsagain.databinding.FragmentHistoryBinding;

/**
 * Created by jihuiquan on 2016/12/23.
 */

public class HistoryFragment extends Fragment implements HistoryContract.View {
    private static final String TAG = "HistoryFragment";
    private HistoryAdapter historyAdapter;
    private HistoryContract.Presenter historyPresenter;
    private FragmentHistoryBinding historyBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        historyBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        historyBinding.rvContent.setLayoutManager(staggeredGridLayoutManager);
        historyAdapter = new HistoryAdapter();
        historyBinding.rvContent.setAdapter(historyAdapter);
        historyPresenter = new HistoryPresenter(new HistoryDataSourceImpl(), this);
        return historyBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        historyPresenter.loadData("e5819f08efaa65bc97a7ef93de55cc46", 1.0);
        initEvent();
    }

    private void initEvent() {
        historyBinding.swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                historyPresenter.loadData("e5819f08efaa65bc97a7ef93de55cc46", 1.0);
            }
        });
    }

    @Override
    public void loadSucceed(HistoryInfo historyInfo) {
        historyAdapter.setHistory(historyInfo);
        if (historyBinding.swipeContainer.isRefreshing()) {
            historyBinding.swipeContainer.setRefreshing(false);
        }
    }

    @Override
    public void loadFailed(String msg) {
        Toast.makeText(getActivity(),"加载失败！请重新加载",Toast.LENGTH_SHORT).show();
        if (historyBinding.swipeContainer.isRefreshing()) {
            historyBinding.swipeContainer.setRefreshing(false);
        }
    }
}
