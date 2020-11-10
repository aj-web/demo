package com.chezj.demo.service.impl;

import com.chezj.demo.dao.UserMapper;
import com.chezj.demo.entity.User;
import com.chezj.demo.service.UserService;
import com.chezj.demo.util.ToJson;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bangsun
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;


    @Override
    public String showDetailUserInfo(int id) {
        return ToJson.showDetailInfo(userMapper.selectByPrimaryKey(id));
    }

    @Override
    public User selectUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public String addUser(User user) {
        return null;
    }
}
