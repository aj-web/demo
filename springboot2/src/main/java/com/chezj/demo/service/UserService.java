package com.chezj.demo.service;

import com.chezj.demo.entity.User;

/**
 * 自己写的方法
 * 复杂业务层处理
 * @author bangsun
 */

public interface UserService {

    /**
     * 主键查找用户
     * @param id
     * @return
     */
    String showDetailUserInfo(int id);

    /**
     * 主键查找用户
     * @param id
     * @return
     */
    User selectUser(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    String addUser(User user);
}
