package com.coco.pojo;

import java.math.BigDecimal;

public class TbFlowAchievementReport {
    private BigDecimal pv;

    private Long uv;

    private Integer statusonemedical;

    private Integer statustwomedical;

    private Integer statusthreemedical;

    private Integer statuszeromedical;

    private Integer statusonepackage;

    private Integer statustwopackage;

    private Integer statuszeropackage;

    private BigDecimal revenueofmedical;

    private BigDecimal revenueofpackage;

    private String serverdate;

    public BigDecimal getPv() {
        return pv;
    }

    public void setPv(BigDecimal pv) {
        this.pv = pv;
    }

    public Long getUv() {
        return uv;
    }

    public void setUv(Long uv) {
        this.uv = uv;
    }

    public Integer getStatusonemedical() {
        return statusonemedical;
    }

    public void setStatusonemedical(Integer statusonemedical) {
        this.statusonemedical = statusonemedical;
    }

    public Integer getStatustwomedical() {
        return statustwomedical;
    }

    public void setStatustwomedical(Integer statustwomedical) {
        this.statustwomedical = statustwomedical;
    }

    public Integer getStatusthreemedical() {
        return statusthreemedical;
    }

    public void setStatusthreemedical(Integer statusthreemedical) {
        this.statusthreemedical = statusthreemedical;
    }

    public Integer getStatuszeromedical() {
        return statuszeromedical;
    }

    public void setStatuszeromedical(Integer statuszeromedical) {
        this.statuszeromedical = statuszeromedical;
    }

    public Integer getStatusonepackage() {
        return statusonepackage;
    }

    public void setStatusonepackage(Integer statusonepackage) {
        this.statusonepackage = statusonepackage;
    }

    public Integer getStatustwopackage() {
        return statustwopackage;
    }

    public void setStatustwopackage(Integer statustwopackage) {
        this.statustwopackage = statustwopackage;
    }

    public Integer getStatuszeropackage() {
        return statuszeropackage;
    }

    public void setStatuszeropackage(Integer statuszeropackage) {
        this.statuszeropackage = statuszeropackage;
    }

    public BigDecimal getRevenueofmedical() {
        return revenueofmedical;
    }

    public void setRevenueofmedical(BigDecimal revenueofmedical) {
        this.revenueofmedical = revenueofmedical;
    }

    public BigDecimal getRevenueofpackage() {
        return revenueofpackage;
    }

    public void setRevenueofpackage(BigDecimal revenueofpackage) {
        this.revenueofpackage = revenueofpackage;
    }

    public String getServerdate() {
        return serverdate;
    }

    public void setServerdate(String serverdate) {
        this.serverdate = serverdate == null ? null : serverdate.trim();
    }
}