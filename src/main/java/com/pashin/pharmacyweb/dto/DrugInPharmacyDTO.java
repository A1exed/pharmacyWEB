package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class DrugInPharmacyDTO implements Serializable {

    private Long pharmacyID;

    private Long drugID;

    private String networkName;

    private String pharmacyAddress;

    private String drugName;

    private String form;

    private String manufacturerName;

    private Integer quantity;

    public DrugInPharmacyDTO() {
    }

    public DrugInPharmacyDTO(Long pharmacyID, Long drugID, String networkName, String pharmacyAddress, String drugName, String form, String manufacturerName, Integer quantity) {
        this.pharmacyID = pharmacyID;
        this.drugID = drugID;
        this.networkName = networkName;
        this.pharmacyAddress = pharmacyAddress;
        this.drugName = drugName;
        this.form = form;
        this.manufacturerName = manufacturerName;
        this.quantity = quantity;
    }

    public Long getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(Long pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public Long getDrugID() {
        return drugID;
    }

    public void setDrugID(Long drugID) {
        this.drugID = drugID;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DrugInPharmacyDTO{" +
                "pharmacyID=" + pharmacyID +
                ", drugID=" + drugID +
                ", networkName='" + networkName + '\'' +
                ", pharmacyAddress='" + pharmacyAddress + '\'' +
                ", drugName='" + drugName + '\'' +
                ", form='" + form + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
