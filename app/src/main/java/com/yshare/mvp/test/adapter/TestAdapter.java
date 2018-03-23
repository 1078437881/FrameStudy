package com.yshare.mvp.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yshare.framestudy.R;
import com.yshare.mvp.test.bean.StoriesBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/21.
 */

public class TestAdapter extends RecyclerView.Adapter {

    private List<StoriesBean> list;
    private Context context;

    public TestAdapter(List<StoriesBean> list){
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_test,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView1,textView2;
        public viewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);

        }
    }
}
