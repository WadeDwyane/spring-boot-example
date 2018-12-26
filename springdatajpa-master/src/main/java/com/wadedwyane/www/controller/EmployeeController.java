package com.wadedwyane.www.controller;


import com.wadedwyane.www.entity.Address;
import com.wadedwyane.www.entity.Employee;
import com.wadedwyane.www.entity.PaperworkEntity;
import com.wadedwyane.www.entity.Project;
import com.wadedwyane.www.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AddressService addressService;

    @Autowired
    PaperworkService paperworkService;

    @Autowired
    ProjectService projectService;

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    public void insert(@RequestBody Employee employee) {
        Address address = new Address();
        address.setAddress("北京市海淀区中关村大街15号大街");
        employee.setAddress(address);
        addressService.saveAddress(address);
        employeeService.insertEmployee(employee);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteEmployeeById(@RequestParam(value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @RequestMapping(value = "/insertEmployee", method = RequestMethod.POST, consumes = "application/json")
    public void insertEmployee(@RequestBody Employee employee) {
        List<PaperworkEntity> paperworkEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PaperworkEntity paperworkEntity = new PaperworkEntity();
            paperworkEntity.setName("证书" + i);
            paperworkEntity.setAcquireTm("201" + i + "0" + i + "0" + i);
            paperworkEntity.setCertificationDept("部门" + i);
            paperworkService.save(paperworkEntity);
            paperworkEntities.add(paperworkEntity);
        }
        employee.setPaperworkEntities(paperworkEntities);

        Address address = new Address();
        address.setAddress("北京市朝阳区垡头路");
        employee.setAddress(address);
        addressService.saveAddress(address);
        employeeService.insertEmployee(employee);
    }

    @RequestMapping(value = "/insertEmPro", method = RequestMethod.POST)
    public void insertEmPro(@RequestParam(name = "name") String name) {
        for (int i = 0; i < 3; i++) {
            List<Employee> employees = new ArrayList<>();
            Employee employee = new Employee();
            employee.setName(name + "_" + i);
            employee.setSex((i / 2 == 0) ? "0" : "1");

            ArrayList<Project> projectList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                Project project = new Project();
                project.setName("project_" + j);
                projectList.add(project);
                project.setEmployees(employees);
                projectService.insertProject(project);
            }

            Address address = new Address();
            address.setAddress("北京市朝阳区垡头路_" + i);
            addressService.saveAddress(address);
            employee.setAddress(address);
            employee.setProjectList(projectList);
            employeeService.insertEmployee(employee);
        }
    }





}
