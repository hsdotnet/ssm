package com.hs.controller;

import com.hs.domain.User;
import com.hs.service.UserService;
import com.hs.vo.JqGridPagerVO;
import com.hs.vo.PagerVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public JqGridPagerVO<User> getJqGridData(PagerVO pager, String username) {
        return userService.getJqGridData(pager, username);
    }
}
