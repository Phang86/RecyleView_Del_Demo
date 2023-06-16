package com.hnhy.recyleview_del_demo.bean;

public class MsgBean {
    private String title = "系统消息";
    private String time;
    private String msgInfo;
    private int flag;

    public MsgBean(String time, String msgInfo, int flag) {
        this.time = time;
        this.msgInfo = msgInfo;
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


}
