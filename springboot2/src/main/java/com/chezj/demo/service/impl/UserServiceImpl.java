package com.chezj.demo.service.impl;

import com.chezj.demo.dao.UserMapper;
import com.chezj.demo.entity.User;
import com.chezj.demo.service.UserService;
import com.chezj.demo.util.ToJson;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bangsun
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String ShowDetailUserInfo(User user) {
        userMapper.selectByPrimaryKey(user.getId());
        return ToJson.ShowDetailInfo(userMapper.selectByPrimaryKey(user.getId()));
    }




}
