package com.priyank.db.repository;

import com.priyank.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//Creating a repository to interact with tables from the database.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where e.is_active = 1")
    //public List<Employee> findAll();

    public List<Employee> findByName(@Param("name") String name);

    public Optional<Employee> findById(@Param("employee_id") Integer employee_id);

    @Modifying
    @Query("update Employee e set e.mobile = :mobile where e.employee_id = :employee_id")
    public List<Employee> updateMobile(@Param("employee_id") Integer employee_id, @Param("mobile") long mobile);

    public Employee findByEmail(@Param("email") String email);

    @Modifying
    public void deleteById(@Param("employee_id") Integer employee_id);
}

//Now we can use JpaRepository’s methods: save(), findOne(),
// findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.
