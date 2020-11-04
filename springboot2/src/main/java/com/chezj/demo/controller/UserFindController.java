package com.chezj.demo.controller;

import cn.hutool.core.lang.Dict;
import com.chezj.demo.constant.Status;
import com.chezj.demo.exception.PageException;
import com.chezj.demo.property.ApplicationProperty;
import com.chezj.demo.property.DeveloperProperty;
import com.chezj.demo.property.TestProperty;
import com.chezj.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bangsun
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserFindController {
    private final UserService userService;
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;
    private final TestProperty testProperty;

    @GetMapping("getUserDetail")
    public String showDetailInfo(int id) {
        return userService.showDetailUserInfo(id);
    }

    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty).set("testProperty",testProperty);
    }

    @RequestMapping("/helloworld")
    public String helloWorld(Model model) throws Exception{
        model.addAttribute("mav","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return "example/hello";
    }

    @GetMapping("/page")
    public ModelAndView pageException(){
        throw new PageException(Status.UNKNOWN_ERROR);
    }



}
