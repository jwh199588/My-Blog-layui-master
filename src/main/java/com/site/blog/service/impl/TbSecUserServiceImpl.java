package com.site.blog.service.impl;

import com.site.blog.entity.SecUser;
import com.site.blog.dao.TbSecUserMapper;
import com.site.blog.service.TbSecUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhulin
 * @since 2021-01-14
 */
@Service
public class TbSecUserServiceImpl extends ServiceImpl<TbSecUserMapper, SecUser> implements TbSecUserService {

    @Autowired
    private TbSecUserMapper tbSecUserMapper;

    @Override
    public SecUser findOneTbSecUser(String username) {
        SecUser secUser = tbSecUserMapper.selectById(username);
        return secUser;
    }

    @Override
    public boolean insert(String username,String password) {

        SecUser userInfo = tbSecUserMapper.selectById(username);
        if(userInfo == null){
            SecUser secUser = new SecUser(username,new BCryptPasswordEncoder().encode(password),"ROLE_USER");

            tbSecUserMapper.insert(secUser);
            return true;
        }
        return false;

    }
}
