package com.itcro.ssm.controller;

import com.itcro.ssm.dao.IUserDao;
import com.itcro.ssm.domain.Product;
import com.itcro.ssm.domain.Role;
import com.itcro.ssm.domain.UserInfo;
import com.itcro.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";

    }


    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id",required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }




    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username='tom'")
    public String save(UserInfo userInfo) throws Exception {
       userService.save(userInfo);
       return "redirect:findAll.do";
    }


}
