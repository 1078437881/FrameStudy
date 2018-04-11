package com.yshare.mvp.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yshare.framestudy.R;
import com.yshare.mvp.test.bean.StoriesBean;
import com.yshare.utils.TimeUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/21.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.viewHolder> {

    private List<StoriesBean> list;
    private Context context;

    public TestAdapter(List<StoriesBean> list){
        this.list = list;
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_test,parent,false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImages().get(0)).crossFade().into(holder.imageView);
        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(TimeUtils.getNowTime());
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
