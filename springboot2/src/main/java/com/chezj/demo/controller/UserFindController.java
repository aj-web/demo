package com.chezj.demo.controller;

import com.chezj.demo.dao.UserMapper;
import com.chezj.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bangsun
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserFindController {
    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping("getUser")
    public String find(int id) {
        return userMapper.selectByPrimaryKey(id).toString();
    }

    @GetMapping("getUserDetail")
    public String ShowDetailInfo(int id) {
        return userService.ShowDetailUserInfo(userMapper.selectByPrimaryKey(id));
    }
}
