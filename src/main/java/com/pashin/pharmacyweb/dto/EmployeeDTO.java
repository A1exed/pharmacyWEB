package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

    private Long employeeID;

    private String employeeName;

    private String position;

    private String phoneNumber;

    private PharmacyDTO pharmacy;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeID, String employeeName, String position, String phoneNumber, PharmacyDTO pharmacy) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.pharmacy = pharmacy;
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

    public PharmacyDTO getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyDTO pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pharmacy=" + pharmacy +
                '}';
    }
}
