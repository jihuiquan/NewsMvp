package com.example.jihuiquan.newsagain.module.funny;


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
import com.example.jihuiquan.newsagain.data.funny.FunnyInfo;
import com.example.jihuiquan.newsagain.data.funny.source.impl.FunnyDataSourceImp;
import com.example.jihuiquan.newsagain.databinding.FragmentFunnyBinding;

/**
 * Created by jihuiquan on 2016/12/23.
 */

public class FunnyFragment extends Fragment implements FunnyContract.View{

    private FragmentFunnyBinding fragmentFunnyBinding;
    private FunnyAdapter funnyAdapter;
    private FunnyPresenter funnyPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFunnyBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_funny, container, false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        fragmentFunnyBinding.rvContent.setLayoutManager(staggeredGridLayoutManager);
        funnyAdapter = new FunnyAdapter();
        fragmentFunnyBinding.rvContent.setAdapter(funnyAdapter);
        funnyPresenter = new FunnyPresenter(this, new FunnyDataSourceImp());
        funnyPresenter.loadData("facd3f89a62400877ee559778e89bb6c", 1, 20);
        initEvent();
        return fragmentFunnyBinding.getRoot();
    }

    private void initEvent() {
        fragmentFunnyBinding.swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                funnyPresenter.loadData("facd3f89a62400877ee559778e89bb6c", 1, 20);
            }
        });
    }

    @Override
    public void loadSucceed(FunnyInfo funnyInfo) {
        funnyAdapter.setFunnyData(funnyInfo);
        if (fragmentFunnyBinding.swipeContainer.isRefreshing()) {
            fragmentFunnyBinding.swipeContainer.setRefreshing(false);
        }
    }

    @Override
    public void loadFailed(String msg) {
        Toast.makeText(getActivity(),"加载失败！请重新加载",Toast.LENGTH_SHORT).show();
        if (fragmentFunnyBinding.swipeContainer.isRefreshing()) {
            fragmentFunnyBinding.swipeContainer.setRefreshing(false);
        }
    }
}
