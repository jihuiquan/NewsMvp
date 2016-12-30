package com.example.jihuiquan.newsagain.module.history;

import com.example.jihuiquan.newsagain.data.history.HistoryInfo;

/**
 * Created by jihuiquan on 2016/12/30.
 */

public interface HistoryContract {
    interface View{
        void loadSucceed(HistoryInfo historyInfo);
        void loadFailed(String msg);
    }
    interface Presenter{
        void loadData(String key,double v);
    }
}
