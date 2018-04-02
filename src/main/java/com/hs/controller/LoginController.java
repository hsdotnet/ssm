package com.hs.controller;

import com.hs.service.UserService;
import com.hs.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, String username, String password) {
        Result<String> result = userService.login(response, username, password);
        return result;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        userService.logout(request, response);
        return "redirect:login";
    }
}
