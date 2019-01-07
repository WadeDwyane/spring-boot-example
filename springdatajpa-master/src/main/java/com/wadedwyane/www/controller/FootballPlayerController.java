package com.wadedwyane.www.controller;


import com.wadedwyane.www.entity.FootballPlayer;
import com.wadedwyane.www.service.FootballService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/footballplayer")
public class FootballPlayerController {

    @Autowired
    FootballService footballService;

    @RequestMapping("/add")
    public int add(@Param(value = "name") String name, @Param(value = "age") int age) {
        FootballPlayer player = new FootballPlayer();
        player.setAge(age);
        player.setName(name);
        return footballService.add(player);
    }

    @RequestMapping("/delete")
    public void delete(@Param(value = "name") String name) {
        FootballPlayer player = new FootballPlayer();
        player.setName(name);
        footballService.delete(player);
    }

    @RequestMapping("/update")
    public void update(@Param(value = "id") long id,
                       @Param(value = "name") String name,
                       @Param(value = "age") int age) {
        FootballPlayer player = new FootballPlayer();
        player.setId(id);
        player.setAge(age);
        player.setName(name);
        footballService.update(player);
    }

    @RequestMapping("/select")
    public FootballPlayer select(@Param(value = "id") long id) {
        FootballPlayer player = new FootballPlayer();
        player.setId(id);
        return footballService.select(player);
    }

    @RequestMapping("/insertPlayer")
    public void insertPlayer(@Param(value = "name") String name, @Param(value = "age") int age) {
        FootballPlayer player = new FootballPlayer();
        player.setAge(age);
        player.setName(name);
        footballService.insertPlayer(player);
    }

    @RequestMapping("/deletePlayer")
    public void deletePlayer(@Param(value = "id") long id) {
        footballService.deletePlayer(id);
    }

    @RequestMapping("/updatePlayer")
    public void updatePlayer(@Param(value = "id") long id,
                             @Param(value = "name") String name,
                             @Param(value = "age") int age) {
        FootballPlayer player = new FootballPlayer();
        player.setId(id);
        player.setAge(age);
        player.setName(name);
        footballService.updatePlayer(player);
    }

    @RequestMapping("/selectPlayer")
    public FootballPlayer selectPlayer(@Param(value = "id") long id) {
       return footballService.selectPlayer(id);
    }

}
