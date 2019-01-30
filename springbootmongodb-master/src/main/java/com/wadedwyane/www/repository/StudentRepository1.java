package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository1 extends MongoRepository<Student, Long> {

    Student findStudentById(Long id);

    void deleteStudentById(Long id);
}
