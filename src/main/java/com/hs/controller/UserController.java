package com.hs.controller;

import com.hs.domain.User;
import com.hs.service.UserService;
import com.hs.vo.JqGridPagerVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public JqGridPagerVO<User> getUsers() {
        List<User> users = userService.selectList(null);
        return new JqGridPagerVO<>(users, 100, 1, 20);
    }
}
