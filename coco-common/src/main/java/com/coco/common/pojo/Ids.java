package com.coco.common.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/19 0019.
 */
public class Ids implements Serializable{
    private String ids;

    public Ids(){
        super();
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    @Override
    public String toString(){
        return "ids=" + ids;
    }
}
