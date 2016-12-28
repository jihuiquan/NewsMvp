package com.example.jihuiquan.newsagain.data.user.source;

import com.example.jihuiquan.newsagain.base.callback.BaseCallback;
import com.example.jihuiquan.newsagain.data.user.User;


/**
 */
public interface UserLoginDataSource {

    abstract class UserLoginCallback implements BaseCallback<User> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            onLoginFailed(e.getMessage());
        }

        @Override
        public void onNext(User user) {
                onLoginSucceed(user.toString());
        }

        public abstract void onLoginSucceed(String user);

        public abstract void onLoginFailed(String msg);
    }

    void login( UserLoginCallback callback);
}
