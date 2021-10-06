package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class DrugDTO implements Serializable {

    private Long drugID;

    private String drugName;

    private String form;

    private String manufacturerName;

    public DrugDTO() {
    }

    public DrugDTO(Long drugID, String drugName, String form, String manufacturerName) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.form = form;
        this.manufacturerName = manufacturerName;
    }

    public Long getDrugID() {
        return drugID;
    }

    public void setDrugID(Long drugID) {
        this.drugID = drugID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public String toString() {
        return "DrugDTO{" +
                "drugID=" + drugID +
                ", drugName='" + drugName + '\'' +
                ", form='" + form + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}
