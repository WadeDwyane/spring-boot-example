package com.wadedwyane.www.service;

import com.wadedwyane.www.entity.FootballPlayer;
import com.wadedwyane.www.impl.IFootballService;
import com.wadedwyane.www.mapper.FootballPlayerMapper;
import com.wadedwyane.www.mapper.FootballPlayerMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballService implements IFootballService {

    @Autowired
    FootballPlayerMapper mapper;

    @Override
    public int add(FootballPlayer footballPlayer) {
        return mapper.insert(footballPlayer);
    }

    @Override
    public void delete(FootballPlayer player) {
        mapper.delete(player);
    }

    @Override
    public void update(FootballPlayer player) {
        mapper.update(player);
    }

    @Override
    public FootballPlayer select(FootballPlayer player) {
        return mapper.select(player);
    }

    @Autowired
    FootballPlayerMapper1 mapper1;

    public void insertPlayer(FootballPlayer footballPlayer) {
        mapper1.insert(footballPlayer);
    }

    public void deletePlayer(long id) {
        mapper1.delete(id);
    }

    public void updatePlayer(FootballPlayer player) {
        mapper1.update(player);
    }

    public FootballPlayer selectPlayer(long id) {
        return mapper1.select(id);
    }

}
