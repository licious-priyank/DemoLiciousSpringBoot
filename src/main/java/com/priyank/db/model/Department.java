package com.priyank.db.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity //@Entity annotation indicates that the class is a persistent Java class.
public class Department {

    @Id //@Id annotation is for the primary key.
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //@GeneratedValue annotation is used to define generation strategy for the primary key.
    @Column(name="dept_id") //@Column annotation is used to define the column in database that maps annotated field.
    private Integer dept_id;
    @NotBlank
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="is_active")
    private Integer is_active;

    public Department() {
    }

    public Integer getdept_id() {
        return dept_id;
    }

    public void setdept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Integer getis_active() {
        return is_active;
    }

    public void setisactive(Integer is_active) {
        this.is_active = is_active;
    }
}
