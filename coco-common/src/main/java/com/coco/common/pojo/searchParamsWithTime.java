package com.coco.common.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/10 0010.
 */
public class searchParamsWithTime implements Serializable{
    private String search_condition;
    private String search_key;
    private Date beginDate;
    private Date endDate;
    private String rows;
    private String pageNumber;

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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }
}
