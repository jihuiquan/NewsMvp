package com.example.jihuiquan.newsagain.data.history.source.impl;

import com.example.jihuiquan.newsagain.data.history.api.HistoryApiService;
import com.example.jihuiquan.newsagain.data.history.source.HistoryDataSource;

/**
 */
public class HistoryDataSourceImpl implements HistoryDataSource {

    @Override
    public void getHistory(String key,double v,int month,int day,HistoryCallback callback) {
        HistoryApiService.getHistory(key,v,month,day,callback);
    }

}
