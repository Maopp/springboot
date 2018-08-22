package com.catpp.springboot.controller;

import com.catpp.springboot.pojo.JsonResult;
import com.catpp.springboot.pojo.SysUser;
import com.catpp.springboot.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MybatisCRUDController {

    @Autowired
    private UserService userService;

    /**
     * 保存用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveUser")
    public JsonResult saveUser() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("张三");
        sysUser.setPassword("123qwe");

        userService.save(sysUser);
        return JsonResult.ok("保存成功");
    }

    /**
     * 根据id获取用户信息
     * @return
     */
    @RequestMapping("/getById")
    public JsonResult getById() {
        Integer id = 1;
        SysUser user = userService.getById(id);
        return JsonResult.ok(user);
    }

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping("/searchList")
    public JsonResult searchList() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("张三");
        List<SysUser> list = userService.searchList(sysUser);
        return JsonResult.ok(list);
    }

    /**
     * 分页获取用户信息
     * @return
     */
    @RequestMapping("/searchPageList")
    public JsonResult searchPageList() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("张三");
        Integer pageNum = 1;
        Integer pageSize = 2;
        Page<SysUser> sysUsers = userService.searchPageList(sysUser, pageNum, pageSize);
        return JsonResult.ok(sysUsers);
    }

    /**
     * 更新用户信息
     * @return
     */
    @RequestMapping("/update")
    public JsonResult update() {
        SysUser sysUser = new SysUser();
        sysUser.setId(1);
        sysUser.setUsername("zhangsan");
        userService.update(sysUser);
        return JsonResult.ok("修改成功");
    }

    /**
     * 删除用户信息
     * @return
     */
    @RequestMapping("/delete")
    public JsonResult delete() {
        Integer id = 1;
        userService.deleteById(id);
        return JsonResult.ok("删除成功");
    }
}
