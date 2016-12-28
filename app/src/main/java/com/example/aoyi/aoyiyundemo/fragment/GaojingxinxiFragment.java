package com.example.aoyi.aoyiyundemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aoyi.aoyiyundemo.R;

/**
 * Created by aoyi on 2016/12/22.
 */

public class GaojingxinxiFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.gaojingxinxi_fragemnt,container,false);
        return view;
    }
}
