package com.example.jihuiquan.newsagain.data.funny.api;

import com.example.jihuiquan.newsagain.common.http.BaseHttpManager;
import com.example.jihuiquan.newsagain.common.http.HttpServiceManager;
import com.example.jihuiquan.newsagain.data.funny.source.FunnyDataSource;

/**
 * Created by jihuiquan on 2016/12/29.
 */

public class FunnyApiService {
    private static FunnyApi userApi;

    private synchronized static FunnyApi getUserService() {
        if (null == userApi) {
            userApi = HttpServiceManager.getService(FunnyApi.class);
        }
        return userApi;
    }

    public static void getFunny(String key,int page,int pageSize,FunnyDataSource.FunnyCallback callback) {
        BaseHttpManager.executeHttp(getUserService().getFunny(key,page,pageSize), callback);
    }
}
