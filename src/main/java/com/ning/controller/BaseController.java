package com.ning.controller;


import com.ning.domain.User;
import com.ning.serviceimpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/*There must be a Controller annotation or the application will doesn't work .*/
@Controller
public class BaseController {
    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private static final String ADDVIEW = "add";
    private static final String TEST = "test";
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        logger.debug("[Welcome counter :{}", counter);
        return VIEW_INDEX;//返回index.jsp
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcome(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[Welcome counter :{}", counter);
        return VIEW_INDEX;//返回index.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password) {
    //验证传递过来的参数是否正确，否则返回到登陆页面。
        if (this.checkParams(new String[]{username, password})) {
            System.out.println("success");
            //指定要返回的页面为succ.jsp
            ModelAndView mav = new ModelAndView("succ");
            //将参数返回给页面
            mav.addObject("username", username);
            mav.addObject("password", password);
            return mav;
        }
        System.out.println("error");
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return ADDVIEW;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        User user =new User();
        user.setId(1);
        user.setAge(23);
        userService.put(user);
        return TEST;
    }

    /***
     * 验证参数是否为空
     * @param params
     * @return
     */
    private boolean checkParams(String[] params){
        for(String param:params){
            if(param==""||param==null||param.isEmpty()){
                return false;
            }
        }
        return true;
    }
}

