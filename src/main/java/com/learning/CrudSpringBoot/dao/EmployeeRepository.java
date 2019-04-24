package com.learning.CrudSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.CrudSpringBoot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
