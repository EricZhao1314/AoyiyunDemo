package com.example.aoyi.aoyiyundemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.aoyi.aoyiyundemo.fragment.JidianxianluHuiliuxiangFragment;
import com.example.aoyi.aoyiyundemo.fragment.JidianxianluNibianqiFragment;
import com.example.aoyi.aoyiyundemo.fragment.JidianxinaluXiangBianFragment;

import java.util.ArrayList;
import java.util.List;

public class FangZhenActivity extends AppCompatActivity {
    public static final String FANGZHENNAME="fangzhen_name";
    public static final String FANGZHENJIDIANXINALUNAME="fangzhen_jidianxianlu_name";
    private TextView fangzhenTitleText;
    private ImageView fangzhen_shuaxinimage;
    private ViewPager viewPager_fangzhen;
    private PagerSlidingTabStrip tab_fangzhen;
    private List<Fragment> fangzhenViewPagerFragmentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fang_zhen);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        Intent intent=getIntent();
        String fangzhenTitlejidianxianluName=intent.getStringExtra(FANGZHENJIDIANXINALUNAME);
        String fangzhenTitleFangzhenName=intent.getStringExtra(FANGZHENNAME);
        String fangzhenTitle=fangzhenTitlejidianxianluName+"-"+fangzhenTitleFangzhenName;
        initView();
        fangzhenTitleText.setText(fangzhenTitle);
        //为方阵viewpager准备数据源
        JidianxinaluXiangBianFragment xiangbianFragment=new JidianxinaluXiangBianFragment(fangzhenTitlejidianxianluName,fangzhenTitleFangzhenName);
        JidianxianluNibianqiFragment nibianqiFragment=new JidianxianluNibianqiFragment(fangzhenTitlejidianxianluName,fangzhenTitleFangzhenName);
        JidianxianluHuiliuxiangFragment huiliuxiangFragment=new JidianxianluHuiliuxiangFragment(fangzhenTitlejidianxianluName,fangzhenTitleFangzhenName);
        fangzhenViewPagerFragmentList.add(xiangbianFragment);
        fangzhenViewPagerFragmentList.add(nibianqiFragment);
        fangzhenViewPagerFragmentList.add(huiliuxiangFragment);
        //常见适配器viewpager的适配器
        MyFangZhenPagerFragmentAdapter adapter=new MyFangZhenPagerFragmentAdapter(getSupportFragmentManager());
        viewPager_fangzhen.setAdapter(adapter);
        tab_fangzhen.setTextColor(Color.WHITE);
        tab_fangzhen.setTextSize(50);
        tab_fangzhen.setViewPager(viewPager_fangzhen);


    }


    private void initView() {
        fangzhenTitleText= (TextView) findViewById(R.id.Fangzhen_name_text_title);
        fangzhen_shuaxinimage= (ImageView) findViewById(R.id.fangzhen_shuaxin);
        viewPager_fangzhen= (ViewPager) findViewById(R.id.viewpager_fangzhen);
        tab_fangzhen= (PagerSlidingTabStrip) findViewById(R.id.tab_fangzhen);
    }
    public class MyFangZhenPagerFragmentAdapter extends FragmentPagerAdapter {
        String[] title={"箱变","逆变器","汇流箱"};
        public MyFangZhenPagerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fangzhenViewPagerFragmentList.get(position);

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
