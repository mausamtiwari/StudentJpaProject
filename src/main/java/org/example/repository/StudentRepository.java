package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Student;

public class StudentRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_pu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction;


    public StudentRepository() {
        this.transaction = entityManager.getTransaction();
    }

    public Student add(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

    public Student find(long id) {
        return entityManager.find(Student.class, id);
    }

    public Student update(Student student) {
        Student studentToUpdate = find(student.getId());
        entityManager.getTransaction().begin();
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        entityManager.persist(studentToUpdate);
        transaction.commit();
        return studentToUpdate;
    }

    public void delete(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}
