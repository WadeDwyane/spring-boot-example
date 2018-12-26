package com.wadedwyane.www.controller;

import com.wadedwyane.www.entity.Teacher;
import com.wadedwyane.www.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherMapper teacherMapper;

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    public void insert(@RequestBody Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @RequestMapping(value = "/delete")
    public void deleteTeacherById(@RequestParam(value = "id")long id) {
        teacherMapper.deleteTeacherById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public void updateTeacherById(@RequestBody Teacher teacher) {
        teacherMapper.updateTeacherById(teacher);
    }

    @RequestMapping(value = "/selete")
    public Teacher seleteTeacherById(@RequestParam(value = "id") long id) {
        return teacherMapper.selectTeacherById(id);
    }


}
