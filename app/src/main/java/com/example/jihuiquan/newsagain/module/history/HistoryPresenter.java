package com.example.jihuiquan.newsagain.module.history;

import android.text.format.Time;

import com.example.jihuiquan.newsagain.data.history.HistoryInfo;
import com.example.jihuiquan.newsagain.data.history.source.HistoryDataSource;

/**
 * Created by jihuiquan on 2016/12/30.
 */

public class HistoryPresenter implements HistoryContract.Presenter{
    private final HistoryDataSource historyDataSource;
    private final HistoryContract.View mView;

    public HistoryPresenter(HistoryDataSource historyDataSource, HistoryContract.View view){
        this.historyDataSource = historyDataSource;
        this.mView = view;
    }

    @Override
    public void loadData(String key, double v) {
        Time time = new Time("GMT+8");
        time.setToNow();
        historyDataSource.getHistory("e5819f08efaa65bc97a7ef93de55cc46", 1.0, time.month+1,time.monthDay,new HistoryDataSource.HistoryCallback() {
            @Override
            public void onLoginSucceed(HistoryInfo user) {
                mView.loadSucceed(user);
            }

            @Override
            public void onLoginFailed(String msg) {
                mView.loadFailed(msg);
            }
        });
    }
}
