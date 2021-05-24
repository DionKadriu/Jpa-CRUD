package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    //define the field entity manager
        private final EntityManager entityManager;

    @Autowired
    public  EmployeeDAOHibernateImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        //get the current hibernate session
        Session  currentSession= entityManager.unwrap(Session.class);

        //create a query

        Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
        //execute the query with the list

        //return the results
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        //get the current session
Session currentSession= entityManager.unwrap(Session.class);
        //get the employee

        //return the employee
        return currentSession.get(Employee.class,id);
    }

    @Override
    public void save(Employee theEmployee) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        javax.persistence.Query theQuery= currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",id);
        theQuery.executeUpdate();

    }
}
