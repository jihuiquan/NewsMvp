package com.example.jihuiquan.newsagain.module.funny;

import com.example.jihuiquan.newsagain.data.funny.FunnyInfo;
import com.example.jihuiquan.newsagain.data.funny.source.FunnyDataSource;

/**
 * Created by jihuiquan on 2016/12/29.
 */

public class FunnyPresenter implements FunnyContract.presenter{
    private final FunnyContract.View mView;
    private final FunnyDataSource funnyDataSource;

    public FunnyPresenter(FunnyContract.View view, FunnyDataSource funnyDataSource){
        this.mView = view;
        this.funnyDataSource = funnyDataSource;
    }

    @Override
    public void loadData(String key, int page, int pageSize) {
        funnyDataSource.getFunny(key,page,pageSize, new FunnyDataSource.FunnyCallback() {
            @Override
            public void onLoginSucceed(FunnyInfo user) {
                mView.loadSucceed(user);
            }

            @Override
            public void onLoginFailed(String msg) {
                mView.loadFailed(msg);
            }
        });
    }
}
