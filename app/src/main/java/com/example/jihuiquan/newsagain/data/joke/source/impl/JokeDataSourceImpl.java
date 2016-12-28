package com.example.jihuiquan.newsagain.data.joke.source.impl;

import com.example.jihuiquan.newsagain.data.joke.api.JokeApiService;
import com.example.jihuiquan.newsagain.data.joke.source.JokeDataSource;

/**
 */
public class JokeDataSourceImpl implements JokeDataSource {

    @Override
    public void getJoke(String key,int page,int pageSize ,JokeCallback callback) {
        JokeApiService.getJoke(key,page,pageSize,callback);
    }

}
