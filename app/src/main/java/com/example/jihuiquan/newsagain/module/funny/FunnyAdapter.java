package com.example.jihuiquan.newsagain.module.funny;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.funny.FunnyInfo;
import com.example.jihuiquan.newsagain.databinding.FunnyitemBinding;

import java.util.List;


/**
 */

public class FunnyAdapter extends RecyclerView.Adapter {
    private List<FunnyInfo.ResultBean.DataBean> funnyData;
    private Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        FunnyitemBinding funnyitemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.funnyitem, parent, false);
        FunnyViewHolder funnyViewHolder = new FunnyViewHolder(funnyitemBinding.getRoot());
        funnyViewHolder.setBinding(funnyitemBinding);
        return funnyViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FunnyViewHolder && funnyData != null) {
            FunnyInfo.ResultBean.DataBean resultBean = funnyData.get(position);
            ((FunnyViewHolder) holder).binding.setDataBean(resultBean);
            String pic = resultBean.getUrl();
            if (pic != null && !pic.isEmpty()) {
                ((FunnyViewHolder) holder).binding.gvFunnyGif.setVisibility(View.VISIBLE);
                Glide.with(context).load(pic).placeholder(R.drawable.share).crossFade().into(((FunnyViewHolder) holder).binding.gvFunnyGif);
            } else {
                ((FunnyViewHolder) holder).binding.gvFunnyGif.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (funnyData != null) return funnyData.size();
        return 0;
    }

    public void setFunnyData(FunnyInfo funnyBean) {
        this.funnyData = funnyBean.getResult().getData();
        notifyDataSetChanged();
    }

    class FunnyViewHolder extends RecyclerView.ViewHolder {
        private FunnyitemBinding binding;


        public FunnyViewHolder(View itemView) {
            super(itemView);
        }
        public void setBinding(FunnyitemBinding binding){
            this.binding = binding;
        }
    }
}
