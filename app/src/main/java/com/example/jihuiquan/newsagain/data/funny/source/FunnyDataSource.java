package com.example.jihuiquan.newsagain.data.funny.source;

import com.example.jihuiquan.newsagain.base.callback.BaseCallback;
import com.example.jihuiquan.newsagain.data.funny.FunnyInfo;

/**
 * Created by jihuiquan on 2016/12/29.
 */

public interface FunnyDataSource {
    abstract class FunnyCallback implements BaseCallback<FunnyInfo> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            onLoginFailed(e.getMessage());
        }

        @Override
        public void onNext(FunnyInfo user) {
            onLoginSucceed(user);
        }

        public abstract void onLoginSucceed(FunnyInfo user);

        public abstract void onLoginFailed(String msg);
    }

    void getFunny( String key,int page,int pageSize, FunnyDataSource.FunnyCallback callback);
}
