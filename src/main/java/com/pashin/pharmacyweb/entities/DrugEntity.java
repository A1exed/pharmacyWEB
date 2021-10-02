package com.pashin.pharmacyweb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SequenceGenerator(name = "drug_id_seq", sequenceName = "drug_drug_id_seq", allocationSize = 1)
@Entity
@Table(name = "drug", catalog = "pharmacy", schema = "public")
public class DrugEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "drug_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "drug_id")
    private Long drugID;

    @Column(name = "drug_name", length = 50, nullable = false)
    private String drugName;

    @Column(name = "form", length = 50, nullable = false)
    private String form;

    @Column(name = "manufacturer_name", length = 50, nullable = false)
    private String manufacturerName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drugID")
    private List<DrugInPharmacyEntity> drugInPharmacyList;

    public DrugEntity() {
    }

    public DrugEntity(String drugName, String form, String manufacturerName) {
        this.drugName = drugName;
        this.form = form;
        this.manufacturerName = manufacturerName;
    }

    public DrugEntity(String drugName, String form, String manufacturerName, DrugInPharmacyEntity...drugInPharmacy) {
        this.drugName = drugName;
        this.form = form;
        this.manufacturerName = manufacturerName;
        this.drugInPharmacyList = Stream.of(drugInPharmacy).collect(Collectors.toList());
        this.drugInPharmacyList.forEach(x -> x.setDrugID(this));
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

    public List<DrugInPharmacyEntity> getDrugInPharmacyList() {
        return drugInPharmacyList;
    }

    public void setDrugInPharmacyList(List<DrugInPharmacyEntity> drugInPharmacyList) {
        this.drugInPharmacyList = drugInPharmacyList;
    }

    @Override
    public String toString() {
        return "DrugEntity{" +
                "drugID=" + drugID +
                ", drugName='" + drugName + '\'' +
                ", form='" + form + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", drugInPharmacyList=" + drugInPharmacyList +
                '}';
    }
}
