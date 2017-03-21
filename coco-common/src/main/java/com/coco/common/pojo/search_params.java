package com.coco.common.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
public class search_params implements Serializable{
    private String search_condition;
    private String search_key;
    private String rows;
    private String pageNumber;

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getSearch_condition() {
        return search_condition;
    }

    public void setSearch_condition(String search_condition) {
        this.search_condition = search_condition;
    }

    public String getSearch_key() {
        return search_key;
    }

    public void setSearch_key(String search_key) {
        this.search_key = search_key;
    }
}
