package com.pashin.pharmacyweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "drug_in_pharmacy", catalog = "pharmacy", schema = "public")
@IdClass(DrugInPharmacyModel.DrugInPharmacyKey.class)
public class DrugInPharmacyModel implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "pharmacy_id", nullable = false)
    private PharmacyModel pharmacyID;

    @Id
    @ManyToOne
    @JoinColumn(name = "drug_id", nullable = false)
    private DrugModel drugID;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public DrugInPharmacyModel() {
    }

    public DrugInPharmacyModel(PharmacyModel pharmacyID, DrugModel drugID, Integer quantity) {
        this.pharmacyID = pharmacyID;
        this.drugID = drugID;
        this.quantity = quantity;
    }

    public PharmacyModel getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(PharmacyModel pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public DrugModel getDrugID() {
        return drugID;
    }

    public void setDrugID(DrugModel drugID) {
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
        return "DrugInPharmacyModel{" +
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DrugInPharmacyKey)) return false;
            DrugInPharmacyKey that = (DrugInPharmacyKey) o;
            return getPharmacyID().equals(that.getPharmacyID()) && getDrugID().equals(that.getDrugID());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getPharmacyID(), getDrugID());
        }
    }
}
