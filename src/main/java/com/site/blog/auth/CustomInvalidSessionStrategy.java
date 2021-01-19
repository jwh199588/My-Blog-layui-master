package com.site.blog.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: jiawenhao
 * @Date: 2021/1/19 09:45
 * @Description:  当session无效的时候处理（如过期）
 * @see
 * @since 2.0
 */
@Component
public class CustomInvalidSessionStrategy implements InvalidSessionStrategy {

    private final Log logger = LogFactory.getLog(getClass());

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String requestURI = request.getRequestURI();
        logger.error("this session is invalid,so redirect to the new uri '" + requestURI +"'");

        //创建新的会话
        request.getSession();

        //如果当前页面没有处于session的情况下，那么session失效不会产生影响
        //但是如果是需要登陆的页面失效，那么会跳转到需要登陆的页面
		redirectStrategy.sendRedirect(request, response, requestURI);
    }
}
