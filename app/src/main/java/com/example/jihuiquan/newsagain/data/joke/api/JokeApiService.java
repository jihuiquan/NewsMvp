package com.example.jihuiquan.newsagain.data.joke.api;

import com.example.jihuiquan.newsagain.common.http.BaseHttpManager;
import com.example.jihuiquan.newsagain.common.http.HttpServiceManager;
import com.example.jihuiquan.newsagain.data.joke.source.JokeDataSource;

/**
 * Created by tight on 2016/6/14.
 */
public class JokeApiService {

    private static JokeApi userApi;

    private synchronized static JokeApi getUserService() {
        if (null == userApi) {
            userApi = HttpServiceManager.getService(JokeApi.class);
        }
        return userApi;
    }

    public static void getJoke(String key,int page,int pageSize,JokeDataSource.JokeCallback callback) {
        BaseHttpManager.executeHttp(getUserService().getNews(key,page,pageSize), callback);
    }
}
