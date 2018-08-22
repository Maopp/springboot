package com.catpp.springboot.service;

import com.catpp.springboot.pojo.SysUser;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {

    /**
     * 保存用户
     * @param sysUser
     * @throws Exception
     */
    void save(SysUser sysUser) throws Exception;

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    SysUser getById(Integer id);

    /**、
     * 查询用户列表
     * @param sysUser
     * @return
     */
    List<SysUser> searchList(SysUser sysUser);

    /**
     * 分页查询用户列表
     * @param sysUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<SysUser> searchPageList(SysUser sysUser, Integer pageNum, Integer pageSize);

    /**
     * 更新用户信息
     * @param sysUser
     */
    void update(SysUser sysUser);

    /**
     * 根据id删除用户信息
     * @param id
     */
    void deleteById(Integer id);
}
