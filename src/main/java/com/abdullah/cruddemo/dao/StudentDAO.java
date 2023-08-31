package com.abdullah.cruddemo.dao;

import java.util.List;

import com.abdullah.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    List<Student> findByFirstName(String firstName);
    Student updateFirstNameById(Integer id,String firstName);
    Student updateLastNameById(Integer id, String lastName);
    void update(Student theStudent);
    void deleteById(Integer id);
    void deleteByLastName(String lastName);
   // void deleteAll();

}
