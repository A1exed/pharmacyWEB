package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class DrugInPharmacyDTO implements Serializable {

    private PharmacyDTO pharmacy;

    private DrugDTO drug;

    private Integer quantity;

    public DrugInPharmacyDTO() {
    }

    public DrugInPharmacyDTO(PharmacyDTO pharmacy, DrugDTO drug, Integer quantity) {
        this.pharmacy = pharmacy;
        this.drug = drug;
        this.quantity = quantity;
    }

    public PharmacyDTO getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyDTO pharmacy) {
        this.pharmacy = pharmacy;
    }

    public DrugDTO getDrug() {
        return drug;
    }

    public void setDrug(DrugDTO drug) {
        this.drug = drug;
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
                "pharmacy=" + pharmacy +
                ", drug=" + drug +
                ", quantity=" + quantity +
                '}';
    }
}
