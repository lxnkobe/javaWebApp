package com.ning.controller;

import com.ning.domain.BlogCategory;
import com.ning.domain.BlogContent;
import com.ning.domain.BlogSubtype;
import com.ning.domain.BlogTag;
import com.ning.serviceimpl.BlogServiceImpl;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * Created by ning on 15-10-25.
 */


@Controller
public class BlogController extends BaseController {
    @Autowired
    private BlogServiceImpl blogService;

    private static final String ADDBLOG = "add_blog";
    private static final String BLOGTAGSLIST = "blog_tags_list";
    private static final String BLOGDETAIL = "blog_detail";
    private static final String BLOGSTATISTICS = "blog_statistics";
    private static final String ABOUT = "about";


    private List<BlogTag> tagsList;
    private List<BlogCategory> cateList;
    private List<BlogContent> similarBlogList;
    private Map<String, Object> map;
    private BlogContent blog;

    @RequiresRoles("admin")
    @RequestMapping(value = "/addblog", method = RequestMethod.GET)
    public ModelAndView blogCategoryView() {
        cateList = blogService.getCateList();
        ModelAndView modelAndView = new ModelAndView(ADDBLOG);
        modelAndView.addObject("cateList", cateList);
        modelAndView.addObject("update", false);
        return modelAndView;
    }

    @RequestMapping(value = "/tagslist", method = RequestMethod.GET)
    public ModelAndView blogTagList() {
        tagsList = blogService.getTagList();
        ModelAndView modelAndView = new ModelAndView(BLOGTAGSLIST);
        modelAndView.addObject("tagsList", tagsList);
        return modelAndView;
    }

    @RequestMapping(value = "/blogTrend", method = RequestMethod.GET)
    public ModelAndView blogTrend(){
        List<BlogContent> list = blogService.getBestList();
        Long[] idList =new Long[5];
        Long[] countList =new Long[5];
        for(int i=0;i<list.size();i++){
            idList[i]=list.get(i).getId();
            countList[i]=list.get(i).getVisitCount();
        }
        ModelAndView modelAndView = new ModelAndView(BLOGSTATISTICS);
        modelAndView.addObject("idList", idList);
        modelAndView.addObject("countList", countList);
        return modelAndView;
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return ABOUT;
    }

    @RequestMapping(value = "/getSublist", method = RequestMethod.GET)
    public void getSublist(HttpServletRequest request,HttpServletResponse response) {
        Integer cateId =Integer.valueOf(request.getParameter("cateId").toString());
        List<BlogSubtype> list = blogService.getSubtypeList(cateId);
        ajax(response,Status.success,list);
        return;
    }

    @RequestMapping(value = "/createblog", method = RequestMethod.POST,  headers="Accept=application/json")
    public  @ResponseBody Object createBlog(BlogContent blog, HttpServletRequest request, HttpServletResponse response) {
        map = new HashMap<String, Object>();
        if (blog != null) {
            if (blogService.createBlog(blog) > 0) {
                map.put("msg", "成功");
            } else {
                System.out.println("失败");
                map.put("msg", "失败");
            }
        }
        return map;
    }
    @RequestMapping(value = "/deleteblog", method = RequestMethod.POST,  headers="Accept=application/json")
    public  @ResponseBody Object deteleBlog(BlogContent blog, HttpServletRequest request, HttpServletResponse response) {
        String id =request.getParameter("id");
        map = new HashMap<String, Object>();
        if (blog != null) {
            if (blogService.deleteBlog(Long.valueOf(id)) > 0) {
                System.out.println("成功删除");
                map.put("msg", "成功删除");
            } else {
                System.out.println("失败");
                map.put("msg", "删除失败");
            }
        }
        return map;
    }

    @RequestMapping(value = "/blogdetail", method = RequestMethod.GET)
    public ModelAndView blogDetail(HttpServletRequest request) {
        String id = request.getParameter("id").toString();
        if (id != null && (!id.isEmpty())) {
            blog = blogService.getBlogbyId(Long.valueOf(id));
        }
        blog.setVisitCount(blog.getVisitCount() + 1);
        blogService.updateBlog(blog);
        similarBlogList=blogService.getSimilarList(blog.getId(),blog.getTags());
        ModelAndView mv = new ModelAndView(BLOGDETAIL);
        mv.addObject("blog", blog);
        mv.addObject("similarBlogList", similarBlogList);
        return mv;
    }

    @RequestMapping(value = "/updateBlog", method = RequestMethod.GET)
    public ModelAndView getBlog(HttpServletRequest request) {
        String id = request.getParameter("id").toString();
        if (id != null && (!id.isEmpty())) {
            blog = blogService.getBlogbyId(Long.valueOf(id));
        }
        cateList = blogService.getCateList();
        ModelAndView mv = new ModelAndView(ADDBLOG);
        mv.addObject("blog", blog);
        mv.addObject("cateList", cateList);
        mv.addObject("update", true);
        return mv;
    }

    @RequestMapping(value = "/updateBlog", method = RequestMethod.POST,  headers="Accept=application/json")
    public  @ResponseBody Object updateBlog(BlogContent blog, HttpServletRequest request, HttpServletResponse response) {
        map = new HashMap<String, Object>();
        if (blog != null) {
            if (blogService.updateBlog(blog) > 0) {
                map.put("msg", "成功");
            } else {
                System.out.println("失败");
                map.put("msg", "失败");
            }
        }
        return map;
    }


    public List<BlogTag> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<BlogTag> tagsList) {
        this.tagsList = tagsList;
    }

    public List<BlogCategory> getCateList() {
        return cateList;
    }

    public void setCateList(List<BlogCategory> cateList) {
        this.cateList = cateList;
    }

    public BlogContent getBlog() {
        return blog;
    }

    public void setBlog(BlogContent blog) {
        this.blog = blog;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
