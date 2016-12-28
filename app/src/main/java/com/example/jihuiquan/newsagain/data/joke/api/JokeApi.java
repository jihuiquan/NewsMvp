package com.example.jihuiquan.newsagain.data.joke.api;

import com.example.jihuiquan.newsagain.data.joke.JokeInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jihuiquan on 2016/12/28.
 */

public interface JokeApi {
    @GET("http://japi.juhe.cn/joke/content/text.from")
    Observable<JokeInfo> getNews(@Query("key") String key,@Query("page") int page,@Query("pagesize") int pagesize);
}
