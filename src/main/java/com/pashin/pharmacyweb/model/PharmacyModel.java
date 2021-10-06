package com.pashin.pharmacyweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SequenceGenerator(name = "pharmacy_id_seq", sequenceName = "pharmacy_pharmacy_id_seq", allocationSize = 1)
@Entity
@Table(name = "pharmacy", catalog = "pharmacy", schema = "public")
public class PharmacyModel implements Serializable {

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
    private NetworkModel networkID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pharmacyID")
    private List<EmployeeModel> employeeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pharmacyID")
    private List<DrugInPharmacyModel> drugInPharmacyList;

    public PharmacyModel() {
    }

    public PharmacyModel(String address, Double rating, String phoneNumber, NetworkModel networkID) {
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

    public NetworkModel getNetworkID() {
        return networkID;
    }

    public void setNetworkID(NetworkModel networkID) {
        this.networkID = networkID;
    }

    public List<EmployeeModel> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeModel> employeeList) {
        this.employeeList = employeeList;
    }

    public List<DrugInPharmacyModel> getDrugInPharmacyList() {
        return drugInPharmacyList;
    }

    public void setDrugInPharmacyList(List<DrugInPharmacyModel> drugInPharmacyList) {
        this.drugInPharmacyList = drugInPharmacyList;
    }

    @Override
    public String toString() {
        return "PharmacyModel{" +
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
