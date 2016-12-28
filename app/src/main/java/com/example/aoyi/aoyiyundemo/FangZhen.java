package com.example.aoyi.aoyiyundemo;

/**
 * Created by aoyi on 2016/12/23.
 */

public class FangZhen {
    private String fangzhenName;
    private int fangzhenId;
    private String jidanxianluName;
    private int jianxianluId;

    public FangZhen(String fangzhenName,  String jidanxianluName) {
        this.fangzhenName = fangzhenName;
        this.fangzhenId = fangzhenId;
        this.jidanxianluName = jidanxianluName;
        this.jianxianluId = jianxianluId;
    }

    public String getFangzhenName() {
        return fangzhenName;
    }

    public int getFangzhenId() {
        return fangzhenId;
    }

    public String getJidanxianluName() {
        return jidanxianluName;
    }

    public int getJianxianluId() {
        return jianxianluId;
    }

    public void setFangzhenName(String fangzhenName) {
        this.fangzhenName = fangzhenName;
    }

    public void setFangzhenId(int fangzhenId) {
        this.fangzhenId = fangzhenId;
    }

    public void setJidanxianluName(String jidanxianluName) {
        this.jidanxianluName = jidanxianluName;
    }

    public void setJianxianluId(int jianxianluId) {
        this.jianxianluId = jianxianluId;
    }
}
