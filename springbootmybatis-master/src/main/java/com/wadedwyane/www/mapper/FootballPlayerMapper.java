package com.wadedwyane.www.mapper;

import com.wadedwyane.www.entity.FootballPlayer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FootballPlayerMapper {

    @Insert("insert into footballplayer (name, age) values(#{name}, #{age})")
    int insert(FootballPlayer player);

    @Delete("delete from footballplayer where name = #{name}")
    void delete(FootballPlayer player);

    @Update("update footballplayer set name = #{name}, age = #{age} where id = #{id}")
    void update(FootballPlayer player);

    @Select("select * from footballplayer where id = #{id}")
    FootballPlayer select(FootballPlayer footballPlayer);

}
