package com.abdullah.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abdullah.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Transactional
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:theData",
                Student.class);
        theQuery.setParameter("theData", firstName);
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public Student updateFirstNameById(Integer id, String newFirstName) {
        Student student = entityManager.find(Student.class, id);
        student.setFirstName(newFirstName);
        return entityManager.merge(student);

    }

    @Transactional
    @Override
    public Student updateLastNameById(Integer id, String newLastName) {
        Student student = entityManager.find(Student.class, id);
        student.setLastName(newLastName);
        return entityManager.merge(student);
    }

    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        Student studentToDelete = entityManager.find(Student.class, id);
        entityManager.remove(studentToDelete);
    }

    @Transactional
    @Override
    public void deleteByLastName(String lastName) {
        Query theQuery = entityManager.createQuery("DELETE FROM Student WHERE lastName=:theData");
        theQuery.setParameter("theData", lastName);
        theQuery.executeUpdate();
    }

    // @Transactional
    // @Override
    // public void updateLastNameOfAllStudents(String lastName) {
    // TypedQuery theQuery = entityManager.createQuery("UPDATE Student SET
    // lastName=:theData", Student.class);
    // theQuery.setParameter("theData", lastName);
    // theQuery.executeUpdate();

    // }

}
