package com.example.jihuiquan.newsagain.module.joke;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jihuiquan.newsagain.R;
import com.example.jihuiquan.newsagain.data.joke.JokeInfo;
import com.example.jihuiquan.newsagain.databinding.JokeitemBinding;

import java.util.List;


/**
 */

public class JokeAdapter extends RecyclerView.Adapter {
    private List<JokeInfo.Data> jokeData;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        JokeitemBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.jokeitem, parent, false);
        JokeViewHolder jokeViewHolder = new JokeViewHolder(inflate.getRoot());
        jokeViewHolder.setBinding(inflate);
        return jokeViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof JokeViewHolder && jokeData != null) {
            JokeInfo.Data data = jokeData.get(position);
            ((JokeViewHolder) holder).binding.setJokeInfo(data);
        }
    }

    @Override
    public int getItemCount() {
        if (jokeData != null) return jokeData.size();
        return 0;
    }

    public void setJokes(JokeInfo jokeInfo) {
        this.jokeData = jokeInfo.getResult().getData();
        notifyDataSetChanged();
    }

    class JokeViewHolder extends RecyclerView.ViewHolder {
        private JokeitemBinding binding;

        public JokeViewHolder(View itemView) {
            super(itemView);
        }

        public void setBinding(JokeitemBinding binding) {
            this.binding = binding;
        }
    }
}
