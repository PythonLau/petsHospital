package com.coco.common.pojo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public class EUTreeNodeWithAttributes {
    private BigDecimal id;
    private String text;
    private String state;
    private Map attributes;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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

    public Map getAttributes() {
        return attributes;
    }

    public void setAttributes(Map attributes) {
        this.attributes = attributes;
    }
}
