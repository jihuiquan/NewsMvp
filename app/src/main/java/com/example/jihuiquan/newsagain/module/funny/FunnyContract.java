package com.example.jihuiquan.newsagain.module.funny;

import com.example.jihuiquan.newsagain.data.funny.FunnyInfo;

/**
 * Created by jihuiquan on 2016/12/29.
 */

public interface FunnyContract {
    interface View{
        void loadSucceed(FunnyInfo funnyInfo);
        void loadFailed(String msg);

    }
    interface presenter{
        void loadData(String key,int page,int pageSize);
    }
}
