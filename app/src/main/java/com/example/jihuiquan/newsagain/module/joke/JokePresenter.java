package com.example.jihuiquan.newsagain.module.joke;

import com.example.jihuiquan.newsagain.data.joke.JokeInfo;
import com.example.jihuiquan.newsagain.data.joke.source.JokeDataSource;

/**
 * Created by jihuiquan on 2016/12/28.
 */

public class JokePresenter implements JokeContract.Presenter{

    private final JokeDataSource jokeDataSource;
    private final JokeContract.View mView;

    public JokePresenter(JokeDataSource jokeDataSource, JokeContract.View view){
        this.jokeDataSource = jokeDataSource;
        this.mView = view;
    }
    @Override
    public void loadData() {
        jokeDataSource.getJoke("facd3f89a62400877ee559778e89bb6c", 1, 20, new JokeDataSource.JokeCallback() {
            @Override
            public void onLoginSucceed(JokeInfo user) {
                mView.loadSucceed(user);
            }

            @Override
            public void onLoginFailed(String msg) {
                mView.loadFailed(msg);
            }
        });

    }
}
