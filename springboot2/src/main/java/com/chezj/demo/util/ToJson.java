package com.chezj.demo.util;

import com.chezj.demo.entity.User;
import net.sf.json.JSONObject;
/**
 * @Method 工具类
 * @Author Administrator
 * @Version  1.0
 * @Description
 * @param null
 * @Return 
 * @Exception 
 * @Date 2020/9/6 
 */
public class ToJson {
    public static String ShowDetailInfo(User user) {
        JSONObject jsonpObject= JSONObject.fromObject(user);
        String str = jsonpObject.toString();
        return str;
    }
}
