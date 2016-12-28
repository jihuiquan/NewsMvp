package com.example.jihuiquan.newsagain.common.http;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 */
public class HttpClientManager {

    private static OkHttpClient client;

    public static OkHttpClient getClient() {
        if (null == client) {
            HttpClientManager manager = new HttpClientManager();
            client = new OkHttpClient.Builder()
                    .addInterceptor(manager.getHttpLoggingInterceptor())
//                    .addInterceptor(manager.getHeaderInterceptor())
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return client;
    }

//    private Interceptor getHeaderInterceptor() {
//        Interceptor interceptor = chain -> {
//            Request request = chain.request();
//            String method = request.method();
//            switch (method) {
//                case "POST":
//                    RequestBody body = request.body();
//                    FormBody.Builder builder = new FormBody.Builder();
//                    if (null != body && body.contentLength() > 0) {
////                                Log.d("body", body.getClass().getSimpleName());
//                        if (body instanceof FormBody) {
//                            FormBody oldBody = (FormBody) body;
//
//                            for (int i = 0; i < oldBody.size(); i++) {
//                                builder.add(oldBody.name(i), oldBody.value(i));
//                            }
//                        } else {
//                            return chain.proceed(request);
//                        }
//                    }
//                    FormBody edutk = builder.add("protk", GroupMealsApp.getInstance().getCurrentUser().getToken() + "").build();
////                            FormBody formBody = new FormBody.Builder().add("protk", AbSharedUtil.getString(EduApp.getInstance(),
////                                    UILogin.USER_TOKEN) + "").build();
//                    Request newPostRequest = request.newBuilder().post(edutk).build();
//                    Log.d("post_request", newPostRequest.body().contentLength() + "");
//                    return chain.proceed(newPostRequest);
//                case "GET":
//                    HttpUrl url = request.url();
//                    HttpUrl newUrl = url.newBuilder().addQueryParameter("protk", GroupMealsApp.getInstance().getCurrentUser().getToken() + "").build();
//                    Request newGetRequest = request.newBuilder().url(newUrl).build();
//                    Log.d("get_request", newGetRequest.url().toString());
//                    return chain.proceed(newGetRequest);
//                default:
//                    Log.d("default_request", request.url().toString());
//                    return chain.proceed(request);
//            }
//
//        };
//        return interceptor;
//    }

    private Interceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

}
