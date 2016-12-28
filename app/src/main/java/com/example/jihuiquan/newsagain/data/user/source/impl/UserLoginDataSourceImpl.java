package com.example.jihuiquan.newsagain.data.user.source.impl;

import com.example.jihuiquan.newsagain.data.user.api.UserApiService;
import com.example.jihuiquan.newsagain.data.user.source.UserLoginDataSource;

/**
 */
public class UserLoginDataSourceImpl implements UserLoginDataSource {

    @Override
    public void login(UserLoginCallback callback) {
        UserApiService.userLogin(callback);
    }

}
