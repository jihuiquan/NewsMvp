package com.example.jihuiquan.newsagain.module.history;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.history.HistoryInfo;
import com.example.jihuiquan.newsagain.databinding.HistoryitemBinding;

import java.util.List;


/**
 */

public class HistoryAdapter extends RecyclerView.Adapter {
    private List<HistoryInfo.ResultBean> historyData;
    private Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        HistoryitemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.historyitem, parent, false);
        HistoryViewHolder historyViewHolder = new HistoryViewHolder(binding.getRoot());
        historyViewHolder.setBinding(binding);
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HistoryViewHolder && historyData != null) {
            HistoryInfo.ResultBean resultBean = historyData.get(position);
            ((HistoryViewHolder) holder).binding.setResultBean(resultBean);
            String pic = resultBean.getPic();
            if (pic != null && !pic.isEmpty()) {
                ((HistoryViewHolder) holder).binding.ivHistoryPic.setVisibility(View.VISIBLE);
                Glide.with(context).load(pic).placeholder(R.drawable.share).crossFade().into(((HistoryViewHolder) holder).binding.ivHistoryPic);
            } else {
                ((HistoryViewHolder) holder).binding.ivHistoryPic.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (historyData != null) return historyData.size();
        return 0;
    }

    public void setHistory(HistoryInfo newsBean) {
        this.historyData = newsBean.getResult();
        notifyDataSetChanged();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        private HistoryitemBinding binding;

        public HistoryViewHolder(View itemView) {
            super(itemView);
        }

        public void setBinding(HistoryitemBinding binding) {
            this.binding = binding;
        }
    }
}
