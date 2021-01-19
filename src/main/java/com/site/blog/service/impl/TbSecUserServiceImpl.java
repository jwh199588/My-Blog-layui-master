package com.site.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.site.blog.dao.TbSecUserMapper;
import com.site.blog.entity.SecUser;
import com.site.blog.service.TbSecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhulin
 * @since 2021-01-14
 */
@Service
public class TbSecUserServiceImpl extends ServiceImpl<TbSecUserMapper, SecUser> implements TbSecUserService {

    @Autowired
    private TbSecUserMapper tbSecUserMapper;


    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    @Override
    public SecUser findOneTbSecUser(String username) {
        SecUser secUser = tbSecUserMapper.selectById(username);
        return secUser;
    }

    @Override
    public boolean insert(String username, String password) {

        SecUser userInfo = tbSecUserMapper.selectById(username);
        if (userInfo == null) {
            SecUser secUser = new SecUser(username, new BCryptPasswordEncoder().encode(password), "ROLE_USER");

            tbSecUserMapper.insert(secUser);
            return true;
        }
        return false;

    }

    @Override
    public boolean verifyPassword(String username, String password) {
        SecUser userInfo = tbSecUserMapper.selectById(username);
        if (userInfo == null) {
            return false;
        }

        return passwordEncoder.matches(password, userInfo.getPassword());
    }

    @Override
    public boolean updateUserInfo(SecUser secUser) {

        secUser.setPassword(passwordEncoder.encode(secUser.getPassword()));
        tbSecUserMapper.updateById(secUser);
        return true;
    }
}
