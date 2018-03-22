package com.hs.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hs.domain.User;
import com.hs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg", "Index");

        List<User> users = userService.selectUsers("a", "a");

        System.out.println(users);

        return "index";
    }
}
