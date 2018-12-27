package com.wadedwyane.www.controller;

import com.wadedwyane.www.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("message", "www.wadedwyane.com");
        return "hello";
    }

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "www.wadedwyane.com");
        return "string";
    }

    @RequestMapping("/if")
    public String ifUnless(ModelMap modelMap) {
        modelMap.addAttribute("flag", "no");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "2018");
        map.addAttribute("pageId", "2018/12/25/spring");
        map.addAttribute("img", "http://t2.hddhhn.com/uploads/tu/201811/9999/b84485cb4d.jpg");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap modelMap) {
        modelMap.addAttribute("name", "wadedwyane");
        modelMap.addAttribute("age", 31);
        modelMap.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }

    public List<User> getUserList() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("wade dwyane " + i);
            user.setAge(20 + i);
            user.setSignature("this is my house " + i);
            list.add(user);
        }
        return list;
    }

}
