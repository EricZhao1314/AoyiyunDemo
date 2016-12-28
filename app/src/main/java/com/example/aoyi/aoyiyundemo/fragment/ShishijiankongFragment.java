package com.example.aoyi.aoyiyundemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.aoyi.aoyiyundemo.R;
import com.example.aoyi.aoyiyundemo.sevice.ChartService;

import org.achartengine.GraphicalView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by aoyi on 2016/12/22.
 */

public class ShishijiankongFragment extends Fragment {
    private LinearLayout gonglvquxiantuLayout;
    private GraphicalView shishigongluquxianview;
    private ChartService mService;
    private Timer timer;
    private Handler handler;
    private int t = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shishijiankong_fragment, container, false);
        gonglvquxiantuLayout = (LinearLayout) view.findViewById(R.id.gongluquxiantu);
        mService = new ChartService(getActivity());
        mService.setXYMultipleSeriesDataset("功率曲线");
        mService.setXYMultipleSeriesRenderer(20, 18000, "功率曲线1", "时间/h", "功率/Mw",
                Color.WHITE, Color.RED, Color.YELLOW, Color.BLACK);
        shishigongluquxianview = mService.getGraphicalView();
        //将图表添加到布局容器中
        gonglvquxiantuLayout.addView(shishigongluquxianview, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        final int[]Xshuju={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        final int[]Yshuju={2343,3234,5544,2222,3333,2235,3333,2222,1111,2222,4444,6666,8888,9999};
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (t!=Xshuju.length){
                handler.sendMessage(handler.obtainMessage());
                }else{
                    timer.cancel();
                }
            }
        }, 10, 100);//5000就是每5秒更新一次


         handler = new Handler() {
            @Override
            //定时更新图表
            public void handleMessage(Message msg) {


                mService.updateChart(Xshuju[t], Yshuju[t]);

                t += 1;
            }
        };
        return view;
    }



    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }


}
