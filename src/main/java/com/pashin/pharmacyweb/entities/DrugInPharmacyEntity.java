package com.pashin.pharmacyweb.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "drug_in_pharmacy", catalog = "pharmacy", schema = "public")
@IdClass(DrugInPharmacyEntity.DrugInPharmacyKey.class)
public class DrugInPharmacyEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "pharmacy_id", nullable = false)
    private PharmacyEntity pharmacyID;

    @Id
    @ManyToOne
    @JoinColumn(name = "drug_id", nullable = false)
    private DrugEntity drugID;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public DrugInPharmacyEntity() {
    }

    public DrugInPharmacyEntity(PharmacyEntity pharmacyID, DrugEntity drugID, Integer quantity) {
        this.pharmacyID = pharmacyID;
        this.drugID = drugID;
        this.quantity = quantity;
    }

    public PharmacyEntity getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(PharmacyEntity pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public DrugEntity getDrugID() {
        return drugID;
    }

    public void setDrugID(DrugEntity drugID) {
        this.drugID = drugID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DrugInPharmacyEntity{" +
                "pharmacyID=" + pharmacyID +
                ", drugID=" + drugID +
                ", quantity=" + quantity +
                '}';
    }

    public static class DrugInPharmacyKey implements Serializable {

        private Long pharmacyID;

        private Long drugID;

        public DrugInPharmacyKey() {
        }

        public DrugInPharmacyKey(Long pharmacyID, Long drugID) {
            this.pharmacyID = pharmacyID;
            this.drugID = drugID;
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

        @Override
        public String toString() {
            return "DrugInPharmacyKey{" +
                    "pharmacyID=" + pharmacyID +
                    ", drugID=" + drugID +
                    '}';
        }
    }
}
