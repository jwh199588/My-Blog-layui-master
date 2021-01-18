package com.site.blog.config;

import com.site.blog.constants.UploadConstants;
import com.site.blog.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyBlogWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * @Description: 重写addResourceHandlers映射文件路径
     * @Param: [registry]
     * @return: void
     * @date: 2019/8/7 9:06
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/authorImg/**").addResourceLocations("file:" + UploadConstants.UPLOAD_AUTHOR_IMG);
        registry.addResourceHandler("/articleImg/**").addResourceLocations("file:" + UploadConstants.FILE_UPLOAD_DIC);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login/index");

        // 新增注册页面
        registry.addViewController("/sign").setViewName("login/register");

        registry.addViewController("/admin/v1/welcome").setViewName("adminLayui/welcome");//返回welcome界面
    }
}
