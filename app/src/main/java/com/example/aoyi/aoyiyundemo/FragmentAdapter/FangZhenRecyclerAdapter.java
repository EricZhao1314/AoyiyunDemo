package com.example.aoyi.aoyiyundemo.FragmentAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aoyi.aoyiyundemo.FangZhen;
import com.example.aoyi.aoyiyundemo.FangZhenActivity;
import com.example.aoyi.aoyiyundemo.R;
import com.example.aoyi.aoyiyundemo.fragment.FangZhenFragment;

import java.util.List;

/**
 * Created by aoyi on 2016/12/23.
 */

public class FangZhenRecyclerAdapter extends RecyclerView.Adapter<FangZhenRecyclerAdapter.ViewHolder> {
    private List<FangZhen>mfangzhenList;
    private Context mContext;
    public FangZhenRecyclerAdapter(List<FangZhen> fangzhenList) {
        mfangzhenList = fangzhenList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.fangzhen_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        //为每个方阵设置点击事件
        holder.fangzhenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                FangZhen fangzhen=mfangzhenList.get(position);
                Intent intent=new Intent(v.getContext(), FangZhenActivity.class);
                intent.putExtra(FangZhenActivity.FANGZHENNAME,fangzhen.getFangzhenName());
                intent.putExtra(FangZhenActivity.FANGZHENJIDIANXINALUNAME,fangzhen.getJidanxianluName());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FangZhen fangzhen=mfangzhenList.get(position);
        holder.fangzhenName.setText(fangzhen.getFangzhenName());

    }

    @Override
    public int getItemCount() {
        return mfangzhenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View fangzhenView;
        TextView fangzhenName;
        ImageView fangzhenImage;
        public ViewHolder(View view) {
            super(view);
            fangzhenView=view;
            fangzhenName= (TextView) view.findViewById(R.id.fangzhenName_textview);
            fangzhenImage= (ImageView) view.findViewById(R.id.fangzhen_image);
        }
    }
}
