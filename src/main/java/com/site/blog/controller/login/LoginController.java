package com.site.blog.controller.login;

import com.site.blog.entity.SecUser;
import com.site.blog.service.TbSecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

//https://www.cnblogs.com/charlypage/p/9320515.html
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TbSecUserService tbSecUserService;

    @RequestMapping("/insertUser")
    public String insertUser(Model model, String username, String password){

        boolean insert = tbSecUserService.insert(username, password);

        if(!insert){
            model.addAttribute("error",true);
        }else {
            model.addAttribute("success",true);
        }

        return "/login/register";
    }

}
