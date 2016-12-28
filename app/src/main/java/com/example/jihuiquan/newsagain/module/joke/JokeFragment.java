package com.example.jihuiquan.newsagain.module.joke;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.joke.JokeInfo;
import com.example.jihuiquan.newsagain.data.joke.source.JokeDataSource;
import com.example.jihuiquan.newsagain.data.joke.source.impl.JokeDataSourceImpl;
import com.example.jihuiquan.newsagain.databinding.FragmentJokeBinding;

/**
 * Created by jihuiquan on 2016/12/23.
 */

public class JokeFragment extends Fragment implements JokeContract.View{

    private FragmentJokeBinding jokeBinding;
    private JokeAdapter jokeAdapter;
    private static final String TAG = "JokeFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_joke, container, false);
        jokeBinding = DataBindingUtil.bind(inflate);
//        jokeAdapter = new JokeAdapter();
//        jokeBinding.rvContent.setAdapter(jokeAdapter);
        new JokeDataSourceImpl().getJoke("facd3f89a62400877ee559778e89bb6c", 1, 20, new JokeDataSource.JokeCallback() {
            @Override
            public void onLoginSucceed(JokeInfo user) {
            }

            @Override
            public void onLoginFailed(String msg) {
            }
        });
        return inflate;
    }

    @Override
    public void loadSucceed(JokeInfo jokeInfo) {

    }

    @Override
    public void loadFailed(String msg) {

    }
}
