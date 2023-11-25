package com.dev2prod.manytomany.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev2prod.manytomany.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByEmpId(Long empId);
}
