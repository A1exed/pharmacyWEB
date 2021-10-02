package com.pashin.pharmacyweb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SequenceGenerator(name = "pharmacy_id_seq", sequenceName = "pharmacy_pharmacy_id_seq", allocationSize = 1)
@Entity
@Table(name = "pharmacy", catalog = "pharmacy", schema = "public")
public class PharmacyEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "pharmacy_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "pharmacy_id")
    private Long pharmacyID;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "network_id")
    private NetworkEntity networkID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pharmacyID")
    private List<EmployeeEntity> employeeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pharmacyID")
    private List<DrugInPharmacyEntity> drugInPharmacyList;

    public PharmacyEntity() {
    }

    public PharmacyEntity(String address, Double rating, String phoneNumber) {
        this.address = address;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
    }

    public PharmacyEntity(String address, Double rating, String phoneNumber, NetworkEntity networkID) {
        this.address = address;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.networkID = networkID;
    }

    public Long getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(Long pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public NetworkEntity getNetworkID() {
        return networkID;
    }

    public void setNetworkID(NetworkEntity networkID) {
        this.networkID = networkID;
    }

    public List<EmployeeEntity> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeEntity> employeeList) {
        this.employeeList = employeeList;
    }

    public List<DrugInPharmacyEntity> getDrugInPharmacyList() {
        return drugInPharmacyList;
    }

    public void setDrugInPharmacyList(List<DrugInPharmacyEntity> drugInPharmacyList) {
        this.drugInPharmacyList = drugInPharmacyList;
    }

    @Override
    public String toString() {
        return "PharmacyEntity{" +
                "pharmacyID=" + pharmacyID +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", networkID=" + networkID +
                ", employeeList=" + employeeList +
                ", drugInPharmacyList=" + drugInPharmacyList +
                '}';
    }
}
