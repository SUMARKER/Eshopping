package com.shopping.rest.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
public class CatNode {
    @JsonProperty("n")
    private String name;
    @JsonProperty("u")
    private String url;
    @JsonProperty("i")
    private List<?> Item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getItem() {
        return Item;
    }

    public void setItem(List<?> item) {
        Item = item;
    }
}
