package com.priyank.db.model;

import com.priyank.db.validators.IsInteger;
import com.priyank.db.validators.IsLong;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //@Entity annotation indicates that the class is a persistent Java class.
public class Employee {

    @Id // @Id annotation is for the primary key.
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //@GeneratedValue annotation is used to define generation strategy for the primary key.
    // GenerationType.AUTO means Auto Increment field.
    @Column(name="employee_id") //@Column annotation is used to define the column in database that maps annotated field.
    private Integer employee_id;
    @NotNull
    @Column(name="name")
    private String name;
    @NotNull
    @IsLong
    @Min(value = (long)7e9)
    @Max(value = (long)1e10 - 1)
    @Column(name="mobile")
    private long mobile;
    @NotNull
    @Email
    @Column(name="email")
    private String email;
    @Min(value = 25000)
    @IsInteger
    @Column(name="salary")
    private Integer salary;
    @Column(name="doj")
    private Integer doj;
    @Column(name="degree")
    private String degree;
    @Column(name="address")
    private String address;
    @Column(name="is_active")
    private String is_active;
    @NotNull
    @Column(name="dept_id")
    private Integer dept_id;

    public Employee() {
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public long getmobile() {
        return mobile;
    }

    public void setmobile(long mobile) {
        this.mobile = mobile;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public Integer getsalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getdoj() {
        return doj;
    }

    public void setdoj(Integer doj) {
        this.doj = doj;
    }

    public String getdegree() {
        return degree;
    }

    public void setdegree(String degree) {
        this.degree = degree;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getis_active() {
        return is_active;
    }

    public void setis_active(String is_active) {
        this.is_active = is_active;
    }

    public Integer getdept_id() {
        return dept_id;
    }

    public void setdept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
}
