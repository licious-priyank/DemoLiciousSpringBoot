package com.priyank.db.model;

import javax.persistence.*;
import javax.validation.constraints.*;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/
@Entity //@Entity annotation indicates that the class is a persistent Java class.
public class Employee {

    @Id // @Id annotation is for the primary key.
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //@GeneratedValue annotation is used to define generation strategy for the primary key.
    // GenerationType.AUTO means Auto Increment field.
    @Column(name="employee_id") //@Column annotation is used to define the column in database that maps annotated field.
    private Integer employee_id;
    @NotBlank(message="Name is mandatory")
    @Column(name="name")
    private String name;
    @NotNull
    @Size(min = 10, max = 10, message="Number should have 10 digits")
    @Column(name="mobile")
    private Integer mobile;
    @Email
    @NotBlank
    @Column(name="email")
    private String email;
    @NotNull
    @Column(name="dept_id")
    private Integer dept_id;
    @NotNull
    @Column(name="salary")
    private Integer salary;
    @Column(name="doj")
    private Integer doj;
    @NotNull
    @Column(name="degree")
    private String degree;
    @NotNull
    @Column(name="address")
    private String address;
    @NotNull
    @Column(name="is_active")
    private Integer is_active;

    public Employee() {
    }

    public Integer getEmployeeID() {
        return employee_id;
    }

    public void setEmployeeID(Integer EmployeeID) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer Mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = email;
    }

    public Integer getDeptID() {
        return dept_id;
    }

    public void setDeptID(Integer DeptID) {
        this.dept_id = dept_id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer Salary) {
        this.salary = Salary;
    }

    public Integer getDOJ() {
        return doj;
    }

    public void setDOJ(Integer DOJ) {
        this.doj = doj;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String Degree) {
        this.degree = degree;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = address;
    }

    public Integer getIsActive() {
        return is_active;
    }

    public void setIsActive(Integer IsActive) {
        this.is_active = is_active;
    }
}
