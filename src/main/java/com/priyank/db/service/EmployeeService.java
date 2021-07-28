package com.priyank.db.service;
import com.priyank.db.exception.BusinessException;


        import java.util.List;

        import com.priyank.db.repository.EmployeeRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import com.priyank.db.model.Employee;

// employee service class
@Service // To indicate that they're holding the business logic.
public class EmployeeService {

    @Autowired //@Autowired to inject EmployeeRepository bean to local variable.
    private EmployeeRepository employeeRepository;

    // fetching all employees
    public List<Employee> getAllEmployees(){
        List<Employee> emps = (List<Employee>)employeeRepository.findAll();
        return emps;
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }

    // updating employee by id
    public void updateEmployee(Employee emp, int EmployeeID){
        if(EmployeeID == emp.getEmployeeID()) {
            employeeRepository.save(emp);
        }
    }

    // deleting all employees
    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    public Employee addEmployee(Employee employee) {
        if(employee.getName().isEmpty() || employee.getName().length() == 0 ) {
            throw new BusinessException("601","Please send proper name, It blank");
        }
        try {
            Employee savedEmployee = employeeRepository.save(employee);
            return savedEmployee;
        }catch (IllegalArgumentException e) {
            throw new BusinessException("602","given employee is null");
        }catch (Exception e) {
            throw new BusinessException("603","Something went wrong in Service layer while saving the employee");
        }
    }

    /*//patching/updating status IsActive using patch
    public void patchEmployee(Employee emp, int id) {
        if(id == emp.getEmployeeID()) {
            employeeRepository.save(emp);
        }
    }*/

    // inserting employee
    /*public Employee addEmployee(Employee e) {
        Employee savedEmployee = employeeRepository.save(e);
        return savedEmployee;
    }*/
}
