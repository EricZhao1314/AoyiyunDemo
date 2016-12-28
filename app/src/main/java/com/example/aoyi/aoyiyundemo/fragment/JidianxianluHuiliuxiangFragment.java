package com.example.aoyi.aoyiyundemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aoyi.aoyiyundemo.R;

/**
 * Created by aoyi on 2016/12/25.
 */

public class JidianxianluHuiliuxiangFragment extends Fragment {
    private String jidianxianluName;
    private String fangzhenName;

    public JidianxianluHuiliuxiangFragment(String jidianxianluName, String fangzhenName) {
        this.jidianxianluName = jidianxianluName;
        this.fangzhenName = fangzhenName;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.jidianxianlu_huiliuxiang_fragment,container,false);
        return view;
    }
}
