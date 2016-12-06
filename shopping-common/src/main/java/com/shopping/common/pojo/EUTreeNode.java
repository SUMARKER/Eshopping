package com.shopping.common.pojo;

/**
 * Created by Administrator on 2016/7/20.
 */
public class EUTreeNode {
    private long id;
    private String text;
    private String state;
//    private long parentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public long getParentId() {
//        return parentId;
//    }
//
//    public void setParentId(long parentId) {
//        this.parentId = parentId;
//    }
}
