package com.example.jihuiquan.newsagain.data.user.api;

import com.example.jihuiquan.newsagain.data.user.User;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by jihuiquan on 2016/12/23.
 */

public interface UserApi {
    @GET("/go")
    Observable<User> login();
}
