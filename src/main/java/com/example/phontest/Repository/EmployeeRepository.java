package com.example.phontest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.phontest.Entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    @Query("from Employee a where a.name= :fname")
    List<Employee> findAllEmployeeBySearch(String fname);
    // List<Employee> findAllEmployeeBySearch(String param1);

//    @Query("from Product where name like :keyword%")
//
//    public List<Product> startsWith(@Param("keyword") String keyword);
}
