package com.priyank.db.repository;

import com.priyank.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Creating a repository to interact with tables from the database.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

//Now we can use JpaRepository’s methods: save(), findOne(),
// findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.