package com.learning.CrudSpringBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.CrudSpringBoot.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager thEntityManager) {
		entityManager = thEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		Query theQuery = entityManager.createQuery("from Employee");

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Employee employee = entityManager.find(Employee.class, theId);

		return employee;
	}

	@Override
	public void save(Employee thEmployee) {

		Employee dbEmployee = entityManager.merge(thEmployee);

		thEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();

	}

}
