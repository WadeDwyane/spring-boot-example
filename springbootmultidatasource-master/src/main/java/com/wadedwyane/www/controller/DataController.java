package com.wadedwyane.www.controller;

import com.wadedwyane.www.entity.primary.Factory;
import com.wadedwyane.www.entity.primary.FactoryRepository;
import com.wadedwyane.www.entity.secondary.Good;
import com.wadedwyane.www.entity.secondary.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private GoodRepository goodRepository;

    @RequestMapping(value = "/insertFactoryAndGood", method = RequestMethod.POST)
    public void insertFactory(@RequestParam(name = "factoryName") String factoryName, @RequestParam(name = "address") String address,
                              @RequestParam(name = "name") String name, @RequestParam(name = "goodName") String goodName
    ) {
        factoryRepository.save(new Factory(factoryName, address));
        goodRepository.save(new Good(name, goodName));
    }

}
