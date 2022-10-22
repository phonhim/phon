package com.example.phontest.Repository;

import com.example.phontest.Entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Long> {
//    @Query(value = "select * from tbl_employees a where  a.name= 'Him Phut'", nativeQuery = true)
//    List<Employee> findByName(String fname);
    @Query("SELECT m FROM Employee m WHERE m.name LIKE %:name%")
    List<Employee> findByName(@Param("name") String name);
}
