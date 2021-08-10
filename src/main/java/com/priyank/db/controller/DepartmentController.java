package com.priyank.db.controller;

import com.priyank.db.model.Department;
import com.priyank.db.repository.DepartmentRepository;
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
import java.util.Optional;

@RestController //@RestController annotation is used to define a controller
// and to indicate that the return value of the methods should be be bound to the web response body.
public class DepartmentController {

    static final Logger logger  = LogManager.getLogger(DepartmentController.class.getName());

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = "/department/all")
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @PostMapping(value = "/department/insert")
    public ResponseEntity<@Valid Department> persist(@Valid @RequestBody final Department department) {
        departmentRepository.save(department);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/department/findbyname")
    public List<Department> fetchDataByName(@Valid @RequestParam("name") String name){
        return departmentRepository.findByName(name);
    }


    @DeleteMapping("department/delete")
    public ResponseEntity<?> deleteUser(@RequestParam("dept_id") Integer dept_id){
        Optional<Department> o = departmentRepository.findById(dept_id);
        if(o.isPresent()) {
            Department e = o.get();
            e.setis_active("Deactivated");
            departmentRepository.save(e);
            return ResponseEntity.ok(e.getdept_id());
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
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
