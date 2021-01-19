package com.site.blog.controller.login;

import com.site.blog.constants.HttpStatusEnum;
import com.site.blog.constants.SessionConstants;
import com.site.blog.pojo.dto.Result;
import com.site.blog.service.TbSecUserService;
import com.site.blog.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TbSecUserService tbSecUserService;


    @RequestMapping("/insertUser")
    public String insertUser(Model model, String username, String password) {

        boolean insert = tbSecUserService.insert(username, password);

        if (!insert) {
            model.addAttribute("error", true);
        } else {
            model.addAttribute("success", true);
        }

        return "/login/register";
    }

    @GetMapping("/verifyPassword")
    @ResponseBody
    public Result verifyPassword(HttpSession session,String oldPwd) {

        String username = (String) session.getAttribute(SessionConstants.LOGIN_USER_NAME);


        boolean b = tbSecUserService.verifyPassword(username, oldPwd);

        if (b) {
            return ResultGenerator.getResultByHttp(HttpStatusEnum.OK);
        }
        return ResultGenerator.getResultByHttp(HttpStatusEnum.INTERNAL_SERVER_ERROR);
    }

}
