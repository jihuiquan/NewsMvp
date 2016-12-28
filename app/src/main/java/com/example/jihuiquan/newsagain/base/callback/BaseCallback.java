package com.example.jihuiquan.newsagain.base.callback;

/**
 * Created by tight on 2016/6/15.
 */
public interface BaseCallback<T> {
    void onCompleted();
    void onError(Throwable e);
    void onNext(T t);
}
