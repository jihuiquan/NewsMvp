package com.example.jihuiquan.newsagain.data.funny.source.impl;

import com.example.jihuiquan.newsagain.data.funny.api.FunnyApiService;
import com.example.jihuiquan.newsagain.data.funny.source.FunnyDataSource;

/**
 * Created by jihuiquan on 2016/12/29.
 */

public class FunnyDataSourceImp implements FunnyDataSource{
    @Override
    public void getFunny(String key,int page,int pageSize ,FunnyDataSource.FunnyCallback callback) {
        FunnyApiService.getFunny(key,page,pageSize,callback);
    }
}
