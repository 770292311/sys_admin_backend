package com.gsean.service.impl;


import com.gsean.dao.UserRoleMapper;
import com.gsean.entity.UserRole;
import com.gsean.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 通用 serviceImpl 代码生成器
*
* @author GSean
*/
@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int save(UserRole userRole) {
        return userRoleMapper.insert(userRole);
    }

    @Override
    public int updateById(UserRole userRole) {
        return userRoleMapper.updateByPrimaryKeySelective(userRole);
    }

    @Override
    public UserRole selectById(Long id) {
       return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        UserRole userRole = new UserRole();
//        userRole.setId(id).setIsDeleted(true).setModifyTime(LocalDateTime.now());
        return userRoleMapper.updateByPrimaryKeySelective(userRole);
    }



}




