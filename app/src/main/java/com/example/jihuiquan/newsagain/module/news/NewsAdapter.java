package com.example.jihuiquan.newsagain.module.news;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.news.NewsInfo;
import com.example.jihuiquan.newsagain.databinding.NewsitemBinding;

import java.util.List;

import static android.view.View.GONE;

/**
 */

public class NewsAdapter extends RecyclerView.Adapter {
    private List<NewsInfo.ResultBean.DataBean> newsData;
    Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        NewsitemBinding newsitemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.newsitem,
                parent,
                false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(newsitemBinding.getRoot());
        newsViewHolder.setBinding(newsitemBinding);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NewsViewHolder && newsData != null) {
            NewsInfo.ResultBean.DataBean data = newsData.get(position);
            ((NewsViewHolder) holder).binding.setDataBean(data);

            String pic1path = data.getThumbnail_pic_s();
            if (pic1path != null) {
                Glide.with(context).load(pic1path).placeholder(R.mipmap.loading).crossFade().into(((NewsViewHolder) holder).binding.ivNewsPic1);
            } else {
                ((NewsViewHolder) holder).binding.ivNewsPic1.setVisibility(GONE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO ITEM点击操作。。。。。。。。。。。
                    Log.d("1111","22222");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (newsData != null) return newsData.size();
        return 0;
    }

    public void setNews(NewsInfo newsBean) {
        this.newsData = newsBean.getResult().getData();
        notifyDataSetChanged();
    }


    class NewsViewHolder extends RecyclerView.ViewHolder {
        private NewsitemBinding binding;


        public NewsViewHolder(View itemView) {
            super(itemView);
        }
        public void setBinding(NewsitemBinding binding) {
            this.binding = binding;
        }
    }

}
