package com.pashin.pharmacyweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SequenceGenerator(name = "network_id_seq", sequenceName = "network_network_id_seq", allocationSize = 1)
@Entity
@Table(name = "network", catalog = "pharmacy", schema = "public")
public class NetworkModel implements Serializable {

    @Id
    @GeneratedValue(generator = "network_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "network_id")
    private Long networkID;

    @Column(name = "network_name", length = 100, nullable = false, unique = true)
    private String networkName;

    @Column(name = "phone_number", length = 50, nullable = false)
    private String phoneNumber;

    @Column(name = "owner", length = 150, nullable = false)
    private String owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "networkID")
    private List<PharmacyModel> pharmacyList;

    public NetworkModel() {
    }

    public NetworkModel(String networkName, String phoneNumber, String owner) {
        this.networkName = networkName;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public Long getNetworkID() {
        return networkID;
    }

    public void setNetworkID(Long networkID) {
        this.networkID = networkID;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<PharmacyModel> getPharmacyList() {
        return pharmacyList;
    }

    public void setPharmacyList(List<PharmacyModel> pharmacyList) {
        this.pharmacyList = pharmacyList;
    }

    @Override
    public String toString() {
        return "NetworkModel{" +
                "networkID=" + networkID +
                ", networkName='" + networkName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", pharmacyList=" + pharmacyList +
                '}';
    }
}
