package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

    private Long employeeID;

    private String employeeName;

    private String position;

    private String phoneNumber;

    private Long pharmacyID;

    private String networkName;

    private String pharmacyAddress;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeID, String employeeName, String position, String phoneNumber, Long pharmacyID, String networkName, String pharmacyAddress) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.pharmacyID = pharmacyID;
        this.networkName = networkName;
        this.pharmacyAddress = pharmacyAddress;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(Long pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pharmacyID=" + pharmacyID +
                ", networkName='" + networkName + '\'' +
                ", pharmacyAddress='" + pharmacyAddress + '\'' +
                '}';
    }
}
