package com.chezj.demo.dao;

import com.chezj.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
/**
 * @description:用户基本功能
 * @author: bangsun
 * @date: 2020/11/10 18:05
 No such property: code for class: Script1
 * @return:
 */
public interface UserMapper {
    /**
     * 主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 主键查找
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 查找所有
     * @return
     */
    List<User> selectAll();

    /**
     * 主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}