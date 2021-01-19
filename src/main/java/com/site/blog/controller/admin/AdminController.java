package com.site.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.site.blog.constants.DeleteStatusEnum;
import com.site.blog.constants.HttpStatusEnum;
import com.site.blog.constants.SessionConstants;
import com.site.blog.constants.SysConfigConstants;
import com.site.blog.entity.*;
import com.site.blog.pojo.dto.Result;
import com.site.blog.service.*;
import com.site.blog.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @qq交流群 796794009
 * @qq 1320291471
 * @Description: 管理员controller
 * @date: 2019/8/24 9:43
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogInfoService blogInfoService;
    @Autowired
    private BlogTagService blogTagService;
    @Autowired
    private BlogCategoryService blogCategoryService;
    @Autowired
    private BlogCommentService blogCommentService;
    @Autowired
    private BlogConfigService blogConfigService;
    @Autowired
    private BlogLinkService blogLinkService;

    @Autowired
    private TbSecUserService tbSecUserService;


    /**
     * @Description: 返回个人信息界面
     * @Param: []
     * @return: java.lang.String
     * @date: 2019/8/24 15:02
     */
    @GetMapping("/v1/userInfo")
    public String gotoUserInfo(HttpSession session){
        //获取头像
        session.setAttribute(SessionConstants.AUTHOR_IMG, blogConfigService.getById(
                SysConfigConstants.SYS_AUTHOR_IMG.getConfigField()));

        return "adminLayui/userInfo-edit";
    }


    /**
     * @Description: 返回首页相关数据
     * @Param: [session]
     * @return: java.lang.String
     * @date: 2019/8/24 9:41
     */
    @GetMapping("/v1/index")
    public String index(HttpSession session) {
        session.setAttribute("categoryCount", blogCategoryService.count(
                new QueryWrapper<BlogCategory>().lambda().eq(BlogCategory::getIsDeleted,
                        DeleteStatusEnum.NO_DELETED.getStatus())
        ));
        session.setAttribute("blogCount", blogInfoService.count(
                new QueryWrapper<BlogInfo>().lambda().eq(BlogInfo::getIsDeleted,
                        DeleteStatusEnum.NO_DELETED.getStatus())
        ));
        session.setAttribute("linkCount", blogLinkService.count(
                new QueryWrapper<BlogLink>().lambda().eq(BlogLink::getIsDeleted,
                        DeleteStatusEnum.NO_DELETED.getStatus())
        ));
        session.setAttribute("tagCount", blogTagService.count(
                new QueryWrapper<BlogTag>().lambda().eq(BlogTag::getIsDeleted,
                        DeleteStatusEnum.NO_DELETED.getStatus())
        ));
        session.setAttribute("commentCount", blogCommentService.count(
                new QueryWrapper<BlogComment>().lambda().eq(BlogComment::getIsDeleted,
                        DeleteStatusEnum.NO_DELETED.getStatus())
        ));
        session.setAttribute("sysList",blogConfigService.list());
        return "adminLayui/index";
    }

    /**
     * @Description: 修改用户信息,成功之后清空session并跳转登录页
     * @Param: [session, newPwd, nickName]
     * @return: com.zhulin.blog.dto.Result
     * @date: 2019/8/25 11:06
     */
    @ResponseBody
    @PostMapping("/v1/userInfo")
    public Result<String> userInfoUpdate(HttpSession session,String userName, String newPwd,
                                 String nickName) {
        if (StringUtils.isEmpty(userName) ||StringUtils.isEmpty(newPwd) || StringUtils.isEmpty(nickName)) {
            return ResultGenerator.getResultByHttp(HttpStatusEnum.BAD_REQUEST);
        }

        SecUser secUser = new SecUser(userName,newPwd,"ROLE_USER");
        secUser.setNickName(nickName);

        if (tbSecUserService.updateUserInfo(secUser)) {
            //修改成功后清空session中的数据，前端控制跳转至登录页
            return ResultGenerator.getResultByHttp(HttpStatusEnum.OK,"/login");
        } else {
            return ResultGenerator.getResultByHttp(HttpStatusEnum.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @GetMapping("/v1/reload")
    public boolean reload(HttpSession session){
        Integer userId = (Integer) session.getAttribute(SessionConstants.LOGIN_USER_ID);
        return userId != null && userId != 0;
    }


}
