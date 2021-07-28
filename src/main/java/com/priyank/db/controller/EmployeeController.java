package com.priyank.db.controller;
import com.priyank.db.exception.BusinessException;
import com.priyank.db.exception.ControllerException;


        import java.util.*;
        import org.springframework.http.*;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PatchMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;


        import com.priyank.db.model.Employee;

        import com.priyank.db.service.EmployeeService;
        import com.priyank.db.repository.EmployeeRepository;

@RestController //In Spring, HTTP requests are handled by controllers, which are identified by the
// @RestController annotation.
public class EmployeeController {

    static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

    @Autowired ////@Autowired to inject EmployeeService bean to local variable.
    private EmployeeService employeeService;
    @Autowired //@Autowired to inject EmployeeRepository bean to local variable.
    private EmployeeRepository employeeRepository;



    // displaying list of all employees
    @GetMapping("/employees") //Annotation for Get HTTP method
    public List<Employee> getAllEmployee(){

       return employeeService.getAllEmployees();
    }

    // displaying employee by id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    //updating employee by id
    @PutMapping("/employees/{EmployeeID}")
    public void updateEmployee(@RequestBody Employee e, @PathVariable Integer EmployeeID){
        employeeService.updateEmployee(e, EmployeeID);
    }

    // deleting all employees
    @DeleteMapping("/employees")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }

    // inserting employee
    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        try {
            Employee employeeSaved = employeeService.addEmployee(employee);
            return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
        }catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            ControllerException ce = new ControllerException("611","Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }
    /* @GetMapping("/employees")
   public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String title) {
        List<Employee> employees = new ArrayList<Employee>();


        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }

       else return (ResponseEntity<List<Employee>>) employeeService.getAllEmployees();
    }*/
}

