package com.wadedwyane.www.mapper;

import com.wadedwyane.www.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Mapper
@EnableAutoConfiguration
public interface StudentMapper {

    @Select("select * from student where id = #{id}")
    @Result(javaType = StudentEntity.class)
    StudentEntity queryStudentById(long id);
}
