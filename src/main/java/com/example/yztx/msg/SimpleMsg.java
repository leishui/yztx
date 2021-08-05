package com.example.yztx.msg;

public class SimpleMsg {
    private int status;
    private String msg;
    private Object content;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SimpleMsg() {
    }

    public SimpleMsg(int status, Object content) {
        this.status = status;
        this.content = content;
    }
    public SimpleMsg(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public SimpleMsg(int status, String msg, Object content) {
        this.status = status;
        this.msg = msg;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
