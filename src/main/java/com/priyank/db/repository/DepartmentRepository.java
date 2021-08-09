package com.priyank.db.repository;
import com.priyank.db.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public List<Department> findByName(@Param("name") String name);
    public Optional<Department> findById(@Param("dept_id") Integer dept_id);
    @Modifying
    public void deleteById(@Param("Id") Integer Id);
}
