package com.coco.pojo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
public class CaseHistory {
    BigDecimal id;
    String name;
    String doctorName;
    String recipe;
    String medicalTime;
    Short status;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getMedicalTime() {
        return medicalTime;
    }

    public void setMedicalTime(String medicalTime) {
        this.medicalTime = medicalTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
