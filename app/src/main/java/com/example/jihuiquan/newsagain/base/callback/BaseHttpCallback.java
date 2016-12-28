package com.example.jihuiquan.newsagain.base.callback;


import com.example.jihuiquan.newsagain.base.BaseResponseModel;
import com.example.jihuiquan.newsagain.common.constant.HttpResponseCode;

/**
 * Created by tight on 2016/6/22.
 */
public abstract class BaseHttpCallback<T> implements BaseCallback<BaseResponseModel<T>> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFailed(e.getMessage());
    }

    @Override
    public void onNext(BaseResponseModel<T> tBaseResponseModel) {
        if (tBaseResponseModel.getStatus() == HttpResponseCode.STATUS_OK) {
            onSucceed(tBaseResponseModel.getData());
        } else {
            onFailed(tBaseResponseModel.getMessage());
        }
    }

    public abstract void onSucceed(T t);
    public abstract void onFailed(String msg);
}
