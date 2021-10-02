package com.pashin.pharmacyweb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SequenceGenerator(name = "network_id_seq", sequenceName = "network_network_id_seq", allocationSize = 1)
@Entity
@Table(name = "network", catalog = "pharmacy", schema = "public")
public class NetworkEntity implements Serializable {

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
    private List<PharmacyEntity> pharmacyList;

    public NetworkEntity() {
    }

    public NetworkEntity(String networkName, String phoneNumber, String owner) {
        this.networkName = networkName;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public NetworkEntity(String networkName, String phoneNumber, String owner, PharmacyEntity...pharmacies) {
        this.networkName = networkName;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
        this.pharmacyList = Stream.of(pharmacies).collect(Collectors.toList());
        this.pharmacyList.forEach(x -> x.setNetworkID(this));
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

    public List<PharmacyEntity> getPharmacyList() {
        return pharmacyList;
    }

    public void setPharmacyList(List<PharmacyEntity> pharmacyList) {
        this.pharmacyList = pharmacyList;
    }

    @Override
    public String toString() {
        return "NetworkEntity{" +
                "networkID=" + networkID +
                ", networkName='" + networkName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", pharmacyList=" + pharmacyList +
                '}';
    }
}
