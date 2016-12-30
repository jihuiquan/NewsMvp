package com.example.jihuiquan.newsagain.data.history.api;

import com.example.jihuiquan.newsagain.data.history.HistoryInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jihuiquan on 2016/12/28.
 */

public interface HistoryApi {
    @GET("http://api.juheapi.com/japi/toh")
    Observable<HistoryInfo> getHistory(@Query("key") String key,  @Query("v") double v,@Query("month") int month,@Query("day") int day);
}
