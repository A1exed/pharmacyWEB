package com.pashin.pharmacyweb.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_employee_id_seq", allocationSize = 1)
@Entity
@Table(name = "employee", catalog = "pharmacy", schema = "public")
public class EmployeeModel implements Serializable {

    @Id
    @GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private Long employeeID;

    @Column(name = "employee_name", length = 150, nullable = false)
    private String employeeName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "phone_number", length = 50, nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private PharmacyModel pharmacyID;

    public EmployeeModel() {
    }

    public EmployeeModel(String employeeName, String position, String phoneNumber, PharmacyModel pharmacyID) {
        this.employeeName = employeeName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.pharmacyID = pharmacyID;
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

    public PharmacyModel getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(PharmacyModel pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pharmacyID=" + pharmacyID +
                '}';
    }
}
