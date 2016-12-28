package com.example.jihuiquan.newsagain.data.news.api;


import com.example.jihuiquan.newsagain.common.http.BaseHttpManager;
import com.example.jihuiquan.newsagain.common.http.HttpServiceManager;
import com.example.jihuiquan.newsagain.data.news.source.NewsDataSource;

/**
 * Created by tight on 2016/6/14.
 */
public class NewsApiService {

    private static NewsApi userApi;

    private synchronized static NewsApi getUserService() {
        if (null == userApi) {
            userApi = HttpServiceManager.getService(NewsApi.class);
        }
        return userApi;
    }

    public static void getNews(String type,String key,NewsDataSource.NewsCallback callback) {
        BaseHttpManager.executeHttp(getUserService().getNews(type,key), callback);
    }
}
