package com.priyank.db.controller;
import com.priyank.db.exception.BusinessException;
import com.priyank.db.model.Employee;
import com.priyank.db.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController //In Spring, HTTP requests are handled by controllers, which are identified by the
// @RestController annotation.
public class EmployeeController {

    static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee/all")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/findbyname")
    public List<Employee> fetchDataByName(@Valid @RequestParam("name") String name){
        return employeeRepository.findByName(name);
    }

    /*@PostMapping("/updatemobile")
   public ResponseEntity<Employee> updateMobile(@RequestParam("employee_id") Integer employee_id, @RequestParam("mobile") long mobile) {
       Employee e = employeeRepository.findById(employee_id).get();
        e.setmobile(mobile);
        employeeRepository.save(e);
        return ResponseEntity.ok(e);
    }*/


    @DeleteMapping("/delete")
    public ResponseEntity< ?> deleteUser( @RequestParam("employee_id") Integer employee_id)
    {
        try {
            employeeRepository.deleteById(employee_id);
        }catch (IllegalArgumentException e) {
            throw new BusinessException("608","given employee id is null, please send some id to be deleted" + e.getMessage());
        }catch (Exception e) {
            throw new BusinessException("610","Something went wrong in Service layer while fetching all employees" + e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }

    @PostMapping(value = "/insert")
    public ResponseEntity<@Valid ?> persist(@Valid @RequestBody final Employee Employee) {
        employeeRepository.save(Employee);
        return ResponseEntity.ok(Employee.getEmployee_id());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}

