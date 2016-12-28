package com.example.jihuiquan.newsagain.module.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisa on 2016/12/2.
 * Email: 457420045@qq.com
 */

public class NewsPagerAdapter extends FragmentPagerAdapter {

    public static final String[] titles = {"头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"};
    List<Fragment> fragmentsList = new ArrayList<>();

    public NewsPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentsList.add(NewsContentFragment.newInstance("top"));
        fragmentsList.add(NewsContentFragment.newInstance("shehui"));
        fragmentsList.add(NewsContentFragment.newInstance("guonei"));
        fragmentsList.add(NewsContentFragment.newInstance("guoji"));
        fragmentsList.add(NewsContentFragment.newInstance("yule"));
        fragmentsList.add(NewsContentFragment.newInstance("tiyu"));
        fragmentsList.add(NewsContentFragment.newInstance("junshi"));
        fragmentsList.add(NewsContentFragment.newInstance("keji"));
        fragmentsList.add(NewsContentFragment.newInstance("caijing"));
        fragmentsList.add(NewsContentFragment.newInstance("shishang"));
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragmentsList.get(0);
            case 1:
                return fragmentsList.get(1);
            case 2:
                return fragmentsList.get(2);
            case 3:
                return fragmentsList.get(3);
            case 4:
                return fragmentsList.get(4);
            case 5:
                return fragmentsList.get(5);
            case 6:
                return fragmentsList.get(6);
            case 7:
                return fragmentsList.get(7);
            case 8:
                return fragmentsList.get(8);
            case 9:
                return fragmentsList.get(9);
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


}
