package com.example.jihuiquan.newsagain.data.funny.api;

import com.example.jihuiquan.newsagain.data.funny.FunnyInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jihuiquan on 2016/12/29.
 */

public interface FunnyApi {
    @GET("http://japi.juhe.cn/joke/img/text.from")
    Observable<FunnyInfo> getFunny(@Query("key") String key,@Query("page") int page,@Query("pagesize") int pageSize);
}
