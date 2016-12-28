package com.example.jihuiquan.newsagain.data.joke.source;

import com.example.jihuiquan.newsagain.base.callback.BaseCallback;
import com.example.jihuiquan.newsagain.data.joke.JokeInfo;


/**
 */
public interface JokeDataSource {

    abstract class JokeCallback implements BaseCallback<JokeInfo> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            onLoginFailed(e.getMessage());
        }

        @Override
        public void onNext(JokeInfo user) {
                onLoginSucceed(user);
        }

        public abstract void onLoginSucceed(JokeInfo user);

        public abstract void onLoginFailed(String msg);
    }

    void getJoke( String key,int page,int pageSize, JokeCallback callback);
}
