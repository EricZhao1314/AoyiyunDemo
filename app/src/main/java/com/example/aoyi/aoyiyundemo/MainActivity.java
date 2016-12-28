package com.example.aoyi.aoyiyundemo;

import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.media.TransportController;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.aoyi.aoyiyundemo.fragment.GaojingxinxiFragment;
import com.example.aoyi.aoyiyundemo.fragment.JidianxianluFragment;
import com.example.aoyi.aoyiyundemo.fragment.ShishijiankongFragment;
import com.example.aoyi.aoyiyundemo.fragment.ShujutongjiFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //声明下面四个按钮
    private LinearLayout shishijiankongLayout;
    private LinearLayout gaojingxinxiLayout;
    private LinearLayout jidianxianluLayout;
    private LinearLayout shujutongjiLayout;
    //导航栏弹出侧滑
    private ImageView daohangImageView;
    //侧滑栏
    private DrawerLayout mdrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏actionBar
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        daohangImageView= (ImageView) findViewById(R.id.daohanglan);
        mdrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        shishijiankongLayout= (LinearLayout) findViewById(R.id.shishijiankong_layout_bottom);
        gaojingxinxiLayout= (LinearLayout) findViewById(R.id.gaojingxinxi_layout_bottom);
        jidianxianluLayout= (LinearLayout) findViewById(R.id.jidianxianlu_layout_bottom);
        shujutongjiLayout= (LinearLayout) findViewById(R.id.shujutongji_layout_bottom);
        replaceFragment(new ShishijiankongFragment());
        daohangImageView.setOnClickListener(this);
        shishijiankongLayout.setOnClickListener(this);
        gaojingxinxiLayout.setOnClickListener(this);
        jidianxianluLayout.setOnClickListener(this);
        shujutongjiLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.daohanglan:
                mdrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.shishijiankong_layout_bottom:
                //各种换fragment
                replaceFragment(new ShishijiankongFragment());
                break;
            case R.id.gaojingxinxi_layout_bottom:
                replaceFragment(new GaojingxinxiFragment());
                break;
            case R.id.jidianxianlu_layout_bottom:
                replaceFragment(new JidianxianluFragment());
                break;
            case R.id.shujutongji_layout_bottom:
                replaceFragment(new ShujutongjiFragment());
                break;

        }
    }
//切换fragment方法
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
    }
}
