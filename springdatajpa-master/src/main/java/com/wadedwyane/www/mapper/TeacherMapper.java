package com.wadedwyane.www.mapper;

import com.wadedwyane.www.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Mapper
@EnableAutoConfiguration
public interface TeacherMapper {
    void insert(Teacher teacher);

    void deleteTeacherById(long id);

    void updateTeacherById(Teacher teacher);

    Teacher selectTeacherById(long id);

}
