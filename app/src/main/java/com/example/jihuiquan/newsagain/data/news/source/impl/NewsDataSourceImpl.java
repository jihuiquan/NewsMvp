package com.example.jihuiquan.newsagain.data.news.source.impl;

import com.example.jihuiquan.newsagain.data.news.api.NewsApiService;
import com.example.jihuiquan.newsagain.data.news.source.NewsDataSource;

/**
 */
public class NewsDataSourceImpl implements NewsDataSource {

    @Override
    public void getNews(String type,String key, NewsCallback callback) {
        NewsApiService.getNews(type,key,callback);
    }

}
