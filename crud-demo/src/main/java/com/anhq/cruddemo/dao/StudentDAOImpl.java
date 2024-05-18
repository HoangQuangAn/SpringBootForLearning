package com.anhq.cruddemo.dao;

import com.anhq.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        TypedQuery<Student> query= entityManager.createQuery("FROM Student ORDER BY firstName", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByFirstname(String firstName) {
        TypedQuery<Student> query= entityManager.createQuery("FROM Student WHERE firstName=:theData ORDER BY firstName", Student.class);
        query.setParameter("theData",firstName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student= entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberRowDeleted= entityManager.createQuery("delete from Student ").executeUpdate();
        return numberRowDeleted;
    }

}
