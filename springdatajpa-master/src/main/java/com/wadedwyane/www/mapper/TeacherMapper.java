package com.wadedwyane.www.mapper;

import com.wadedwyane.www.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Mapper
@EnableAutoConfiguration
@Component
public interface TeacherMapper {
    void insert(Teacher teacher);

    void deleteTeacherById(long id);

    void updateTeacherById(Teacher teacher);

    Teacher selectTeacherById(long id);

}
