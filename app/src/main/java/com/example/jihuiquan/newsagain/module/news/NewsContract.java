package com.example.jihuiquan.newsagain.module.news;

import com.example.jihuiquan.newsagain.data.news.NewsInfo;

/**
 * Created by jihuiquan on 2016/12/28.
 */

public interface NewsContract {
    interface Presenter{
        void loadData(String type);

    }
    interface View{
        void loadSucceed(NewsInfo newsInfo);
        void loadFailed(String failedMsg);
    }
}
