package com.wadedwyane.www.impl;

import com.wadedwyane.www.entity.FootballPlayer;

public interface IFootballService {

    int add(FootballPlayer player);

    void delete(FootballPlayer player);

    void update(FootballPlayer player);

    FootballPlayer select(FootballPlayer player);

}


