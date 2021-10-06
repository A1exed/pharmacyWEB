package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class PharmacyDTO implements Serializable {

    private Long pharmacyID;

    private String address;

    private Double rating;

    private String phoneNumber;

    private Long networkID;

    private String networkName;

    public PharmacyDTO() {
    }

    public PharmacyDTO(Long pharmacyID, String address, Double rating, String phoneNumber, Long networkID, String networkName) {
        this.pharmacyID = pharmacyID;
        this.address = address;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.networkID = networkID;
        this.networkName = networkName;
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

    @Override
    public String toString() {
        return "PharmacyDTO{" +
                "pharmacyID=" + pharmacyID +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", networkID=" + networkID +
                ", networkName='" + networkName + '\'' +
                '}';
    }
}
