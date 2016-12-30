package com.example.jihuiquan.newsagain.data.history.source;

import com.example.jihuiquan.newsagain.base.callback.BaseCallback;
import com.example.jihuiquan.newsagain.data.history.HistoryInfo;


/**
 */
public interface HistoryDataSource {

    abstract class HistoryCallback implements BaseCallback<HistoryInfo> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            onLoginFailed(e.getMessage());
        }

        @Override
        public void onNext(HistoryInfo user) {
                onLoginSucceed(user);
        }

        public abstract void onLoginSucceed(HistoryInfo user);

        public abstract void onLoginFailed(String msg);
    }

    void getHistory(String key, double v,int month, int day, HistoryCallback callback);
}
