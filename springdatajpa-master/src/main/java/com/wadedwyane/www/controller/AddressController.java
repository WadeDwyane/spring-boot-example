package com.wadedwyane.www.controller;

import com.wadedwyane.www.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/address")
public class AddressController  {

    @Autowired
    AddressRepository addressRepository;

}
