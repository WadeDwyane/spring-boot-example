package com.wadedwyane.www.controller;

import com.wadedwyane.www.entity.User;
import com.wadedwyane.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//注意:此处的注解不能使用RestController
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "")
    public String index() {
//        return "redirect:/list"; 这里是有问题的
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<User> list = userService.getUserList();
        model.addAttribute("users", list);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/user/list";
    }
}
