package com.example.jihuiquan.newsagain.module.news;

import com.example.jihuiquan.newsagain.data.news.NewsInfo;
import com.example.jihuiquan.newsagain.data.news.source.NewsDataSource;
import com.example.jihuiquan.newsagain.data.news.source.impl.NewsDataSourceImpl;

/**
 * Created by jihuiquan on 2016/12/28.
 */

public class NewsPresenter implements NewsContract.Presenter{
    private final NewsDataSourceImpl newsDataSource;
    private final NewsContract.View newsContentFragment;

    public NewsPresenter(NewsDataSourceImpl newsDataSource, NewsContract.View newsContentFragment){
        this.newsDataSource = newsDataSource;
        this.newsContentFragment = newsContentFragment;
    }
    @Override
    public void loadData(String type) {
        newsDataSource.getNews(type, "53555bf8010e1bf9c42cc0f9fbe8578a", new NewsDataSource.NewsCallback() {
            @Override
            public void onLoginSucceed(NewsInfo user) {
                newsContentFragment.loadSucceed(user);
            }

            @Override
            public void onLoginFailed(String msg) {
                newsContentFragment.loadFailed(msg);
            }
        });
    }
}
