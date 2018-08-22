package com.catpp.springboot.service.impl;

import com.catpp.springboot.mapper.SysUserMapper;
import com.catpp.springboot.pojo.SysUser;
import com.catpp.springboot.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public void save(SysUser sysUser) throws Exception {
        userMapper.insert(sysUser);
    }

    @Override
    public SysUser getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> searchList(SysUser sysUser) {
        return userMapper.select(sysUser);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Page<SysUser> searchPageList(SysUser sysUser, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> list = userMapper.select(sysUser);
        if (list instanceof Page) {
            Page<SysUser> result = (Page) list;

            return result;
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(SysUser sysUser) {
        userMapper.updateByPrimaryKey(sysUser);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
