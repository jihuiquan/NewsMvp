package com.example.jihuiquan.newsagain.data.history.api;

import com.example.jihuiquan.newsagain.common.http.BaseHttpManager;
import com.example.jihuiquan.newsagain.common.http.HttpServiceManager;
import com.example.jihuiquan.newsagain.data.history.source.HistoryDataSource;

/**
 */
public class HistoryApiService {

    private static HistoryApi userApi;

    private synchronized static HistoryApi getUserService() {
        if (null == userApi) {
            userApi = HttpServiceManager.getService(HistoryApi.class);
        }
        return userApi;
    }

    public static void getHistory(String key,double v,int month,int day,HistoryDataSource.HistoryCallback callback) {
        BaseHttpManager.executeHttp(getUserService().getHistory(key,v,month,day), callback);
    }
}
