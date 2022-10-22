package com.example.phontest.Service.impl;

import com.example.phontest.Entity.Employee;
import com.example.phontest.Repository.EmployeeCrudRepository;
import com.example.phontest.Repository.EmployeeRepository;
import com.example.phontest.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeCrudRepository employeeCrudRepository;

    public EmployeeImpl(EmployeeRepository employeeRepository, EmployeeCrudRepository employeeCrudRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCrudRepository = employeeCrudRepository;
    }

    @Override
    public List<Employee> findAllEmployeeBySearch(String searchKey){
           return employeeCrudRepository.findByName(searchKey);
    }
    @Override
    public List<Employee>getAllEmployees() {

        return employeeRepository.findAll();
    }
    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateClassRoom(Employee employee) {
        return null;
    }

    @Override
    public void  deleteEmployeeId(int id) {

        employeeRepository.deleteById(id);
    }

}
