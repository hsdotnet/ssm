package com.hs.controller;

import com.hs.service.UserService;
import com.hs.vo.LoginUserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        LoginUserVO loginUser = userService.getLoginUserByToken(request);
        model.addAttribute("loginUser", loginUser);
        return "index";
    }
}
