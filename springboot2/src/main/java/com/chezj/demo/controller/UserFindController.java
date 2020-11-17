package com.chezj.demo.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONException;
import com.chezj.demo.constant.Status;
import com.chezj.demo.entity.User;
import com.chezj.demo.exception.ApiResponse;
import com.chezj.demo.exception.JsonException;
import com.chezj.demo.exception.PageException;
import com.chezj.demo.property.ApplicationProperty;
import com.chezj.demo.property.DeveloperProperty;
import com.chezj.demo.property.TestProperty;
import com.chezj.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 测试自定义接口抛出Json异常
     * @return
     * @throws JSONException
     */
    @GetMapping("getUserDetail")
    @ResponseBody
    public ApiResponse showDetailInfo() throws JSONException {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    /**
     * 读取属性文件钟的内容
     * @return
     */
    @GetMapping("/property")
    @ResponseBody
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty).set("testProperty",testProperty);
    }

    /**
     * Thymeleaf页面初始化显示
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/helloworld")
    public String helloWorld(Model model) throws Exception{
        model.addAttribute("mav","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return "example/hello";
    }

    /**
     * 测试页面异常
     * @return
     */
    @GetMapping("/page")
    public ModelAndView pageException(){
        throw new PageException(Status.UNKNOWN_ERROR);
    }

    /**
     * 主键插叙
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable("id") Integer id) throws Exception{
        return null;
    }

    /**
     * 主键查询，返回对象，Thymeleaf页面解析对象数据
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/Thy/{id}")
    public ModelAndView testThymeleaf(@PathVariable Integer id) throws Exception{
        User user1=userService.selectUser(id);
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("user",user1);
        return modelAndView;
    }

    /**
     * 简单页面测试
     * @param request
     * @return
     */
    @RequestMapping(value = "/addUserTest",method= RequestMethod.GET)
    public ModelAndView addUserTest(HttpServletRequest request){
        ModelAndView modelAndView =new ModelAndView("/example/index");
        modelAndView.addObject("mav",request.getParameter("username"));
        return modelAndView;
    }

    /**
     * 显示表单
     * @param user
     * @return
     */
    @GetMapping("/test")
    public String showForm(User user){
        return "/form";
    }

    /**
     * 显示结果页面
     * @return
     */
    @GetMapping("/results")
    public String results(){
        return "/results";
    }

    /**
     * 登录验证，结合Hibernate-validator对页面传入的参数进行检验，成功后
     * 重定向到结果页面，并将对象传入结果页面
     * @param user
     * @param bindingResult
     * @param attr
     * @return
     */
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
