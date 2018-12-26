package com.wadedwyane.www.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @RequestMapping(value = "/")
    public String index() {
        return "Hello Docker";
    }



}
