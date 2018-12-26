package com.wadedwyane.www.controller;


import com.wadedwyane.www.entity.StudentEntity;
import com.wadedwyane.www.mapper.StudentMapper;
import com.wadedwyane.www.repository.StudentRepository;
import com.wadedwyane.www.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
//@RequestMapping(value = "/login")
@RequestMapping({"/login", "/home"})
@RestController
@Component
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<StudentEntity> findAllStudents() {
        return (List<StudentEntity>) studentRepository.findAll();
    }

    @GetMapping(value = "/delete")
    public int deleteStudentById(@RequestParam(value = "id") long id) {
        studentRepository.deleteById(id);
        return 1;
    }

    @GetMapping(value = "/student")
    public StudentEntity findStudentById(@RequestParam(value = "id") Long id) {
        return studentRepository.findById(id).get();
    }

    @GetMapping(value = "/insert")
    public void insertOneStudent(@RequestParam(value = "name") String name) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setAge(20);
        studentEntity.setRank(19);
        studentEntity.setScore(19);
        studentEntity.setRemark1("111111");
        studentRepository.save(studentEntity);
    }

    @RequestMapping(value = "/insertStudent", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity insertStudent(@RequestBody StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<StudentEntity> findOnById(@PathVariable(value = "id") Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        HttpStatus status = null == studentEntity ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(studentEntity, status);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @PostMapping(value = "/selectStudent")
    @ResponseBody
    public List<StudentEntity> findStudents(@RequestParam Integer count, @RequestParam Integer sex) {
        return studentRepository.findStudentEntitiesByAgeAndSex(count, sex);
    }

    @PostMapping(value = "/queryStudent")
    public Page<StudentEntity> findStudents(@RequestParam(value = "page") Integer page,
                                            @RequestParam(value = "pageSize") Integer pageSize,
                                            StudentEntity entity) {
        return studentService.findStudents(page, pageSize, entity);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public StudentEntity queryStudentById() {
        return studentMapper.queryStudentById(1L);
    }

    public Page<StudentEntity> queryStudent() {
        int page = 1;
        int pageSize = 20;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, pageSize, sort);
        return studentRepository.findAll(pageable);
    }
}
