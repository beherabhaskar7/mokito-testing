package com.springboot.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.payment.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
