package com.example.jihuiquan.newsagain.module.funny;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jihuiquan.newsagain.R;

/**
 * Created by jihuiquan on 2016/12/23.
 */

public class FunnyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_funny, container, false);
        return inflate;
    }
}
