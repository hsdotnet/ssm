package com.hs.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hs.domain.User;
import com.hs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg", "Index");

        User user = new User();
        user.setUsername("todo");
        user.setPassword("123456");
        user.setRealname("todo");
        user.setCreateby("admin");
        user.setCreatetime(new Date());
        userService.insert(user);

        Page<User> page = new Page<User>(1, 2);
        page = userService.selectUserPage(page);
        System.out.println(page);

        return "index";
    }
}
