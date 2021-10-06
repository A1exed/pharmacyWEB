package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class NetworkDTO implements Serializable {

    private Long networkID;

    private String networkName;

    private String phoneNumber;

    private String owner;

    public NetworkDTO() {
    }

    public NetworkDTO(Long networkID, String networkName, String phoneNumber, String owner) {
        this.networkID = networkID;
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

    @Override
    public String toString() {
        return "NetworkDTO{" +
                "networkID=" + networkID +
                ", networkName='" + networkName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
