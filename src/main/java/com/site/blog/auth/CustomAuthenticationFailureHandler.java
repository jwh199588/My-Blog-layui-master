package com.site.blog.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: jiawenhao
 * @Date: 2021/1/14 14:15
 * @Description:
 * @see
 * @since 2.0
 */

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) {
        response.setContentType("application/json;charset=utf-8");
        if (exception instanceof SessionAuthenticationException){
            try {
                response.getWriter().write("用户已在其它地方登录，禁止当前登录...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}