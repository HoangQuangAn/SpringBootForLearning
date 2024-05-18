package com.anhq.cruddemo.dao;

import com.anhq.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByFirstname(String firstName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();
}
