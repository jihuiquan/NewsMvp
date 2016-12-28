package com.example.jihuiquan.newsagain.data.news.source;

import com.example.jihuiquan.newsagain.base.callback.BaseCallback;
import com.example.jihuiquan.newsagain.data.news.NewsInfo;


/**
 */
public interface NewsDataSource {

    abstract class NewsCallback implements BaseCallback<NewsInfo> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            onLoginFailed(e.getMessage());
        }

        @Override
        public void onNext(NewsInfo user) {
                onLoginSucceed(user);
        }

        public abstract void onLoginSucceed(NewsInfo user);

        public abstract void onLoginFailed(String msg);
    }

    void getNews(String type,String key,NewsCallback callback);
}
