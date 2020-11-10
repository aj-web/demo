package com.chezj.demo.controller;

import cn.hutool.core.lang.Dict;
import com.chezj.demo.constant.Status;
import com.chezj.demo.entity.User;
import com.chezj.demo.exception.PageException;
import com.chezj.demo.property.ApplicationProperty;
import com.chezj.demo.property.DeveloperProperty;
import com.chezj.demo.property.TestProperty;
import com.chezj.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author bangsun
 */
@Controller
@Log
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

    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable("id") Integer id) throws Exception{
        return null;
    }

    @GetMapping("/Thy/{id}")
    public ModelAndView testThymeleaf(@PathVariable Integer id) throws Exception{
        User user1=userService.selectUser(id);
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("user",user1);
        Session session=new Session();

        return modelAndView;
    }

    @RequestMapping(value = "/addUserTest",method= RequestMethod.GET)
    public ModelAndView addUserTest(HttpServletRequest request){
        ModelAndView modelAndView =new ModelAndView("/example/index");
        modelAndView.addObject("mav",request.getParameter("username"));
        return modelAndView;
    }


    @GetMapping("/test")
    public String showForm(User user){
        return "/form";
    }

    @GetMapping("/results")
    public String results(){
        User user = new User();

        return "/results";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid User user, BindingResult bindingResult, RedirectAttributes attr){
        //前端验证失败后，将错误信息封装成对象组装仔bindingResult
        if (bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                error.getDefaultMessage();
                return "/form";
            }
        }
        attr.addFlashAttribute("user",user);
        return "redirect:/results";
    }
}
