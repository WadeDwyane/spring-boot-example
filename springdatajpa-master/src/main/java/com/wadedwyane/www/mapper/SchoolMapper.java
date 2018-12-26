package com.wadedwyane.www.mapper;


import com.wadedwyane.www.entity.SchoolEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Mapper
@EnableAutoConfiguration
public interface SchoolMapper {

    @Insert("insert into school(name, location, student_count) values (#{name}, #{location}, #{studentCount})")
    void insert(SchoolEntity entity);

    @Delete("delete from school where id = #{id}")
    void delete(long id);

    @Update("update school set name = #{name}, location = #{location}, student_count = #{studentCount} where id = #{id}")
    void update(SchoolEntity entity);

    @Select("select * from school where id = #{id}")
    SchoolEntity select(long id);




}
