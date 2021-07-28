package com.priyank.db.model;

import javax.persistence.*;
/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/

@Entity //@Entity annotation indicates that the class is a persistent Java class.
public class Employee {

    @Id // @Id annotation is for the primary key.
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //@GeneratedValue annotation is used to define generation strategy for the primary key.
    // GenerationType.AUTO means Auto Increment field.
    @Column(name="EmployeeID") //@Column annotation is used to define the column in database that maps annotated field.
    private Integer EmployeeID;
    @Column(name="Name")
    private String Name;
    @Column(name="Mobile")
    private Integer Mobile;
    @Column(name="Email")
    private String Email;
    @Column(name="DeptID")
    private Integer DeptID;
    @Column(name="Salary")
    private Integer Salary;
    @Column(name="DOJ")
    private Integer DOJ;
    @Column(name="Degree")
    private String Degree;
    @Column(name="Address")
    private String Address;
    @Column(name="IsActive")
    private Integer IsActive;

    public Employee() {
    }

    public Integer getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Integer EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getMobile() {
        return Mobile;
    }

    public void setMobile(Integer Mobile) {
        this.Mobile = Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer DeptID) {
        this.DeptID = DeptID;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer Salary) {
        this.Salary = Salary;
    }

    public Integer getDOJ() {
        return DOJ;
    }

    public void setDOJ(Integer DOJ) {
        this.DOJ = DOJ;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Integer getIsActive() {
        return IsActive;
    }

    public void setIsActive(Integer IsActive) {
        this.IsActive = IsActive;
    }
}