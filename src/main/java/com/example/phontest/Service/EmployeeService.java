package com.example.phontest.Service;

import com.example.phontest.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee>getAllEmployees();
    List<Employee> findAllEmployeeBySearch(String key);

    Employee saveEmployee(Employee employee);
    Employee editEmployee(Employee employee);
    Employee updateClassRoom(Employee employee);

    void deleteEmployeeId(int id);
}
