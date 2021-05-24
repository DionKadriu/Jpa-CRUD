package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query theQuery = entityManager.createQuery(" from Employee");
        List<Employee> employeeList = theQuery.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        return  entityManager.find(Employee.class,id);
    }

    @Override
    public void save(Employee theEmployee) {
           Employee tempEmployee= entityManager.merge(theEmployee);
           theEmployee.setId(tempEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query= entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
