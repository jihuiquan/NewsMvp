package com.example.jihuiquan.newsagain.common.http;


import com.example.jihuiquan.newsagain.common.config.AppConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tight on 2016/6/14.
 */
public class HttpServiceManager {

    public static Retrofit retrofit;

    public static <T> T getService(Class<T> cls) {
        if (null==retrofit){
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConfig.BASE_ONLINE_URL)
                    .client(HttpClientManager.getClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(cls);
    }

}
