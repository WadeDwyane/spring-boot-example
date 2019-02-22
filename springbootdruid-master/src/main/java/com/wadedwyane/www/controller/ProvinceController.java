package com.wadedwyane.www.controller;


import com.wadedwyane.www.entity.Province;
import com.wadedwyane.www.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/province")
public class ProvinceController {

    @Autowired
    ProvinceRepository provinceRepository;

    @RequestMapping(value = "/saveProvince", method = RequestMethod.GET)
    public String saveProvince(@RequestParam(name = "name") String name, @RequestParam(name = "introduce") String introduce) {
        Province province = new Province(name, introduce);
        provinceRepository.save(province);
        return "success";
    }

    @RequestMapping(value = "/deleteProvince", method = RequestMethod.GET)
    public String deleteProvince(int id) {
        provinceRepository.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "/updateProvince", method = RequestMethod.GET)
    public String updateProvince(int id, String name, String introduce) {
        Province province = new Province(id, name, introduce);
        provinceRepository.save(province);
        return "success";
    }

    @GetMapping(value = "/getCityById")
    public Province getProvinceById(@RequestParam(name = "id") int id) {
        Province province = provinceRepository.findById(id).get();
        return province;
    }
}
