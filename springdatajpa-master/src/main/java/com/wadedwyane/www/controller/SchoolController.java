package com.wadedwyane.www.controller;


import com.wadedwyane.www.entity.SchoolEntity;
import com.wadedwyane.www.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/school")
public class SchoolController {

    @Autowired
    SchoolMapper schoolMapper;

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    public void insert(@RequestBody SchoolEntity schoolEntity) {
        schoolMapper.insert(schoolEntity);
    }

    @RequestMapping(value = "/delete")
    public void delete(@RequestParam(value = "id")long id) {
        schoolMapper.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public void update(@RequestBody SchoolEntity schoolEntity) {
        schoolMapper.update(schoolEntity);
    }

    @RequestMapping(value = "/select")
    public SchoolEntity select(@RequestParam(value = "id")long id){
        return schoolMapper.select(id);
    }



}
