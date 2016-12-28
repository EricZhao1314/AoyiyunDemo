package com.example.aoyi.aoyiyundemo.fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.astuetz.PagerSlidingTabStrip;
import com.example.aoyi.aoyiyundemo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aoyi on 2016/12/22.
 */

public class JidianxianluFragment extends Fragment {
    private ViewPager viewPager_jidianxianlu;
    private PagerSlidingTabStrip tab_jidian;
    private List<Fragment>jidianFragmentList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jidianxianlu_fragment, container, false);
        viewPager_jidianxianlu= (ViewPager) view.findViewById(R.id.viewpager_jidian);
        tab_jidian= (PagerSlidingTabStrip) view.findViewById(R.id.tab_jidian);
       //准备数据源
        FangZhenFragment jidianxianlu1=new FangZhenFragment("集电线路1");
        FangZhenFragment jidianxianlu2=new FangZhenFragment("集电线路2");
        FangZhenFragment jidianxianlu3=new FangZhenFragment("集电线路3");
        jidianFragmentList.add(jidianxianlu1);
        jidianFragmentList.add(jidianxianlu2);
        jidianFragmentList.add(jidianxianlu3);
        MyPagerFragmentAdapter adapter=new MyPagerFragmentAdapter(getChildFragmentManager());
        viewPager_jidianxianlu.setAdapter(adapter);
        tab_jidian.setTextColor(Color.WHITE);
        tab_jidian.setTextSize(60);
        tab_jidian.setViewPager(viewPager_jidianxianlu);
        return view;
    }

    public class MyPagerFragmentAdapter extends FragmentStatePagerAdapter {
        String[] title={"集电线路1","集电线路2","集电线路3"};
        public MyPagerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return jidianFragmentList.get(position);

        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }




}
