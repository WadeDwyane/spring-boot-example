package com.wadedwyane.www.mapper;

import com.wadedwyane.www.entity.FootballPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Mapper
@EnableAutoConfiguration
@Component
public interface FootballPlayerMapper1 {

    void insert(FootballPlayer footballPlayer);

    void delete(long id);

    void update(FootballPlayer footballPlayer);

    FootballPlayer select(long footballPlayer);

}
