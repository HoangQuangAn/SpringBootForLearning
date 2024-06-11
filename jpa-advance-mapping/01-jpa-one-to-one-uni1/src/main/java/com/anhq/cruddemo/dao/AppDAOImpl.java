package com.anhq.cruddemo.dao;

import com.anhq.cruddemo.entity.Instructor;
import com.anhq.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Transactional
    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Instructor tempInstructor= entityManager.find(Instructor.class, id);
        if (tempInstructor == null){
            throw new RuntimeException("Cannot find Instructor!!!");
        }
        entityManager.remove(tempInstructor);
    }

    @Override
    @Transactional
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail tempInstructorDetail= entityManager.find(InstructorDetail.class, id);
        if(tempInstructorDetail==null){
            throw new RuntimeException("Cannot find Instructor Detail with id = "+id);
        }
        entityManager.remove(tempInstructorDetail);
    }
}
