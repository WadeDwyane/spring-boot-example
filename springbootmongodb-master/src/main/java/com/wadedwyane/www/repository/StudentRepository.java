package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.Student;

public interface StudentRepository {

    void save(Student student);

    Student findStudentByName(String name);

    long updateStudent(Student student);

    void deleteStudentById(Long id);

}


