package com.wadedwyane.www;


import com.wadedwyane.www.entity.Student;
import com.wadedwyane.www.impl.StudentRepositoryImpl;
import com.wadedwyane.www.repository.StudentRepository1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoDBTest {

    @Autowired
    StudentRepositoryImpl studentRepository;

    @Autowired
    StudentRepository1 repository1;

    @Test
    public void saveStudent(){
        Student student = new Student();
        student.setId(1l);
        student.setName("小明");
        student.setAge("18");
        studentRepository.save(student);
    }

    @Test
    public void findStudentById(){
        Student student = studentRepository.findStudentByName("小明");
        System.out.println(student.toString());
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(1l);
        student.setName("张大明");
        student.setAge("28");
        studentRepository.updateStudent(student);
    }

    @Test
    public void delete() {
        studentRepository.deleteStudentById(1l);
    }

    //测试增加Student的操作
    @Test
    public void insert() {
        Student student = new Student();
        student.setId(2l);
        student.setName("小军");
        student.setAge("21");
        repository1.save(student);
    }

    //测试查找Student的操作
    @Test
    public void findStudent() {
        Student student = repository1.findStudentById(2l);
        System.out.println(student.toString());
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId(2l);
        student.setName("胡小军");
        student.setAge("30");
        repository1.save(student);
    }

    @Test
    public void deleteStudent() {
        repository1.deleteStudentById(2l);
    }
}
