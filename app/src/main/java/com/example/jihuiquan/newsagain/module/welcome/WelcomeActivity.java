package com.example.jihuiquan.newsagain.module.welcome;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.databinding.ActivityWelcomeBinding;
import com.example.jihuiquan.newsagain.module.home.MainActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by jihuiquan on 2016/12/22.
 */

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding activityWelcomeBinding;
    private Subscription mSubscribe;
    private static final String TAG = "WelcomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityWelcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        activityWelcomeBinding.setSkipHomeActivityClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSubscribe.unsubscribe();
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mSubscribe = Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

    }
}
