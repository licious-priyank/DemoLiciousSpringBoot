package com.priyank.db.service;

import java.util.List;

import com.priyank.db.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.priyank.db.model.Department;
@Service // To indicate that they're holding the business logic.
public class DepartmentService {

    @Autowired //@Autowired to inject DepartmentRepository bean to local variable.
    private DepartmentRepository departmentRepository;


    // fetching all department
    public List<Department> getAllDepartments(){
        List<Department> depts = (List<Department>)departmentRepository.findAll();
        return depts;
    }

    // fetching department by id
    public Department getDepartment(int id){
        return departmentRepository.findById(id).get();}

    // inserting department
    public void addDepartment(Department d) {
        departmentRepository.save(d);
    }

    // updating department by id
    public void updateDepartment(Department d, int id){
        if(id == d.getDeptID()) {
            departmentRepository.save(d); }
    }

    // deleting all departments
    public void deleteAllDepartment(){
        departmentRepository.deleteAll();
    }

    // deleting department by id
    public void deleteDepartmentByID(int DeptID){
        departmentRepository.deleteById(DeptID);
    }

    //patching/updating status IsActive using Patch
    public void patchDepartment(Department d, int id) {
        if(id == d.getDeptID()) {
           departmentRepository.save(d);
        }
    }
}
