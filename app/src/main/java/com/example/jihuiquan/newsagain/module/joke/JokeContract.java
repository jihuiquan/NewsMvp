package com.example.jihuiquan.newsagain.module.joke;

import com.example.jihuiquan.newsagain.data.joke.JokeInfo;

/**
 * Created by jihuiquan on 2016/12/28.
 */

public interface JokeContract {
    interface Presenter{
        void loadData();
    }
    interface View{
        void loadSucceed(JokeInfo jokeInfo);
        void loadFailed(String msg);
    }
}
