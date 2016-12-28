package com.example.jihuiquan.newsagain.module.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.databinding.ActivityMainBinding;
import com.example.jihuiquan.newsagain.module.funny.FunnyFragment;
import com.example.jihuiquan.newsagain.module.history.HistoryFragment;
import com.example.jihuiquan.newsagain.module.joke.JokeFragment;
import com.example.jihuiquan.newsagain.module.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private List<Fragment> fragmentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
        binding.newsIv.setImageResource(R.drawable.news_selected);
        binding.newsTv.setTextColor(getResources().getColor(R.color.colorBottomSelected));

    }

    private void init() {
        initToolbar();
        initBotton();
        initContent();
    }

    private void initContent() {
        fragmentsList.add(new NewsFragment());
        fragmentsList.add(new JokeFragment());
        fragmentsList.add(new FunnyFragment());
        fragmentsList.add(new HistoryFragment());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,fragmentsList.get(0)).add(R.id.frame_layout,fragmentsList.get(1)).add(R.id.frame_layout,fragmentsList.get(2)).add(R.id.frame_layout,fragmentsList.get(3)).hide(fragmentsList.get(1)).hide(fragmentsList.get(2)).hide(fragmentsList.get(3)).show(fragmentsList.get(0)).commit();
    }

    private void initBotton() {
        binding.setNewsClickListener(this);
        binding.setJokeClickListener(this);
        binding.setFunnyClickListener(this);
        binding.setHistoryClickListener(this);
    }

    private void initToolbar() {
        binding.toolbar.setTitle("我的头条");
        binding.toolbar.setTitleTextAppearance(this, R.style.ToolBarTextAppearance);
        setSupportActionBar(binding.toolbar);

    }

    @Override
    public void onClick(View view) {
        binding.newsTv.setTextColor(getResources().getColor(R.color.colorComment));
        binding.jokeTv.setTextColor(getResources().getColor(R.color.colorComment));
        binding.funnyTv.setTextColor(getResources().getColor(R.color.colorComment));
        binding.historyTv.setTextColor(getResources().getColor(R.color.colorComment));
        binding.newsIv.setImageResource(R.drawable.news_normal);
        binding.jokeIv.setImageResource(R.drawable.joke_normal);
        binding.funnyIv.setImageResource(R.drawable.funny_normal);
        binding.historyIv.setImageResource(R.drawable.history_normal);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.news:
                fragmentTransaction.hide(fragmentsList.get(1)).hide(fragmentsList.get(2)).hide(fragmentsList.get(3)).show(fragmentsList.get(0)).commit();
                binding.newsIv.setImageResource(R.drawable.news_selected);
                binding.newsTv.setTextColor(getResources().getColor(R.color.colorBottomSelected));
                break;
            case R.id.joke:
                fragmentTransaction.hide(fragmentsList.get(0)).hide(fragmentsList.get(2)).hide(fragmentsList.get(3)).show(fragmentsList.get(1)).commit();
                binding.jokeIv.setImageResource(R.drawable.joke_selected);
                binding.jokeTv.setTextColor(getResources().getColor(R.color.colorBottomSelected));
                break;
            case R.id.funny:
                fragmentTransaction.hide(fragmentsList.get(1)).hide(fragmentsList.get(0)).hide(fragmentsList.get(3)).show(fragmentsList.get(2)).commit();
                binding.funnyIv.setImageResource(R.drawable.funny_selected);
                binding.funnyTv.setTextColor(getResources().getColor(R.color.colorBottomSelected));
                break;
            case R.id.history:
                fragmentTransaction.hide(fragmentsList.get(1)).hide(fragmentsList.get(2)).hide(fragmentsList.get(0)).show(fragmentsList.get(3)).commit();
                binding.historyIv.setImageResource(R.drawable.history_selected);
                binding.historyTv.setTextColor(getResources().getColor(R.color.colorBottomSelected));
                break;
        }
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.toolbar_search, menu);
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search: {
                Toast.makeText(MainActivity.this,"search",Toast.LENGTH_SHORT).show();
            }
            break;
            default:
                break;
        }
        return true;
    }
}
