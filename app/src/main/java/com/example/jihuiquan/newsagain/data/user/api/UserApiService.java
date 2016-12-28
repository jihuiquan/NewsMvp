package com.example.jihuiquan.newsagain.data.user.api;


import com.example.jihuiquan.newsagain.common.http.BaseHttpManager;
import com.example.jihuiquan.newsagain.common.http.HttpServiceManager;
import com.example.jihuiquan.newsagain.data.user.source.UserLoginDataSource;

/**
 * Created by tight on 2016/6/14.
 */
public class UserApiService {

    private static UserApi userApi;

    private synchronized static UserApi getUserService() {
        if (null == userApi) {
            userApi = HttpServiceManager.getService(UserApi.class);
        }
        return userApi;
    }

    public static void userLogin(UserLoginDataSource.UserLoginCallback callback) {
        BaseHttpManager.executeHttp(getUserService().login(), callback);
    }
}
