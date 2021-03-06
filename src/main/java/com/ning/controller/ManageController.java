package com.ning.controller;

import com.alibaba.druid.util.StringUtils;
import com.ning.domain.*;
import com.ning.mapper.BlogSubtypeMapper;
import com.ning.serviceimpl.BlogServiceImpl;
import com.ning.serviceimpl.ManageService;
import com.ning.utils.CommonUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ning on 10/23/15.
 */
@Controller
public class ManageController extends BaseController{

    private static final String PAGE_MANAGE="manage";
    private static final String LOGIN="login";
    private static final String UNAUTHORIZED="unauthorized";
    private static final String BLOGMANAGE="blog_manage";
    private static final String CATEGARYMANAGE="categary_manage";
    private static final String LOGOUT="logoutsucc";
    private static final String ADDUSER="add_user";

    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private ManageService manageService;


    @RequiresRoles("admin")
    @RequestMapping(value = "manage",method= RequestMethod.GET)
     public String base(Model model){
        return PAGE_MANAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLoginForm(HttpServletRequest request, Model model) {

        String errorClassName = (String) request.getAttribute("shiroLoginFailure");
        String authticationError = null;
        if (UnknownAccountException.class.getName().equals(errorClassName)) {
            authticationError = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
            authticationError = "用户名/密码错误";
        } else if (errorClassName != null) {
            authticationError = "未知错误：" + errorClassName;
        }
        model.addAttribute("error", authticationError);
        return "login";
    }

    @RequestMapping(value = "/logoutsucc",method= RequestMethod.GET)
    public String logout(Model model){
        return "redirect:/index";
    }

    @RequestMapping(value = "/unauthorized",method= RequestMethod.GET)
    public String unauthorized(Model model){
        return UNAUTHORIZED;
    }

    @RequestMapping(value = "blogManage",method= RequestMethod.POST)
    public ModelAndView blogManage(String blogseach){
        ModelAndView mv=new ModelAndView(BLOGMANAGE);
        BlogSearchVO searchVO=new BlogSearchVO();
        List<BlogContent> blogList=null;
        if(!StringUtils.isEmpty(blogseach)){
            if(CommonUtils.isNumeric(blogseach)){
                searchVO.setId(Long.valueOf(blogseach));
            }else{
                searchVO.setTitle(blogseach);
            }
            blogList=blogService.getBlogList(page,searchVO);
        }else{
            blogList=blogService.getBlogList(page,searchVO);
        }

        if (blogList != null && blogList.size() > 0) {
            this.setDisplayPageBar(true);
        } else {
            blogList = null;
            this.setDisplayPageBar(false);
        }
        mv.addObject("displayPageBar",displayPageBar);
        mv.addObject("page",page);
        mv.addObject("blogList",blogList);
        mv.addObject("blogseach",blogseach);
        return mv;
    }

    @RequestMapping(value = "categoryManage",method= RequestMethod.GET)
    public ModelAndView getCategoryList(){
        ModelAndView mv=new ModelAndView(CATEGARYMANAGE);
        BlogSearchVO searchVO=new BlogSearchVO();
        List<BlogSubtype> category=null;

        category= blogService.getSubtypeList(0);

        if (category != null && category.size() > 0) {
            this.setDisplayPageBar(true);
        } else {
            category = null;
            this.setDisplayPageBar(false);
        }
        mv.addObject("displayPageBar",displayPageBar);
        mv.addObject("page",page);
        mv.addObject("category",category);
        return mv;
    }

    @RequestMapping(value = "addUser",method= RequestMethod.GET)
    public String addUser(){
        return ADDUSER;
    }

    @RequestMapping(value = "createUser",method= RequestMethod.POST,  headers="Accept=application/json")
    public @ResponseBody Object createUser(User user, HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap<String, Object>();
        if (user != null) {
            if (manageService.createUser(user) > 0) {
                map.put("msg", "成功");
            } else {
                map.put("msg", "失败");
            }
        }
        return map;
    }


}
