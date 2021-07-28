package com.priyank.db.model;

        import javax.persistence.*;

@Entity //@Entity annotation indicates that the class is a persistent Java class.
public class Department {

    @Id //@Id annotation is for the primary key.
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //@GeneratedValue annotation is used to define generation strategy for the primary key.
    @Column(name="DeptID") //@Column annotation is used to define the column in database that maps annotated field.
    private Integer DeptID;
    @Column(name="Name")
    private String Name;
    @Column(name="Description")
    private String Description;
    @Column(name="IsActive")
    private Integer IsActive;

    public Department() {
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer DeptID) {
        this.DeptID = DeptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Integer getIsActive() {
        return IsActive;
    }

    public void setIsActive(Integer IsActive) {
        this.IsActive = IsActive;
    }
}