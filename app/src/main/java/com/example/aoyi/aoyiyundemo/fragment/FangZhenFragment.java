package com.example.aoyi.aoyiyundemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aoyi.aoyiyundemo.FangZhen;
import com.example.aoyi.aoyiyundemo.FragmentAdapter.FangZhenRecyclerAdapter;
import com.example.aoyi.aoyiyundemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aoyi on 2016/12/23.
 */

public class FangZhenFragment extends Fragment {
    private List<FangZhen>fangzhenList=new ArrayList<>();
    String[]fangzhenNamearr={"#1方阵","#2方阵","#3方阵","#4方阵","#5方阵","#6方阵"};
    private RecyclerView fangzhen_recyclerview;
    private FangZhenRecyclerAdapter fangzhen_adapter;
    private String mjidianxianluName;

    public FangZhenFragment(String jidianxinaluName) {
        mjidianxianluName=jidianxinaluName;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate( R.layout.fangzhen_fragment,container,false);
        intiFangZhen();//初始化方阵数据
        fangzhen_recyclerview= (RecyclerView) view.findViewById(R.id.fangzhen_recyclerview);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        fangzhen_recyclerview.setLayoutManager(layoutManager);

        fangzhen_adapter=new FangZhenRecyclerAdapter(fangzhenList);
        fangzhen_recyclerview.setAdapter(fangzhen_adapter);


        return view;
    }

    private void intiFangZhen() {
            fangzhenList.clear();//一定要加这句话，要不然会出现重复现象
            for (int i = 0; i < fangzhenNamearr.length; i++) {
                FangZhen fangzhen = new FangZhen(fangzhenNamearr[i], mjidianxianluName);
                fangzhenList.add(fangzhen);
            }

    }


}
