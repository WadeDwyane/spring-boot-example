package com.wadedwyane.www.impl;

import com.mongodb.client.result.UpdateResult;
import com.wadedwyane.www.entity.Student;
import com.wadedwyane.www.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


@Component
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    public MongoTemplate mongoTemplate;

    //增加student
    @Override
    public void save(Student student) {
        mongoTemplate.save(student);
    }

    @Override
    public Student findStudentByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Student student = mongoTemplate.findOne(query, Student.class);
        return student;
    }

    @Override
    public long updateStudent(Student student) {
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update().set("name", student.getName()).set("age", student.getAge());
        UpdateResult result = mongoTemplate.updateFirst(query, update, Student.class);
        if (result != null) {
            return result.getMatchedCount();
        } else {
            return 0;
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Student.class);
    }
}
