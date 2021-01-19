package com.site.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.site.blog.entity.SecUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhulin
 * @since 2021-01-14
 */
public interface TbSecUserService extends IService<SecUser> {

    SecUser findOneTbSecUser(String username);

    boolean insert(String username, String password);

    boolean verifyPassword(String username, String password);

    boolean updateUserInfo(SecUser secUser);
}
