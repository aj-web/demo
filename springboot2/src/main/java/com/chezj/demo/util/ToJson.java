package com.chezj.demo.util;

import com.chezj.demo.entity.User;
import net.sf.json.JSONObject;

public class ToJson {

    public static String ShowDetailInfo(User user) {
        JSONObject jsonpObject= JSONObject.fromObject(user);
        String str = jsonpObject.toString();
        return str;
    }
}
