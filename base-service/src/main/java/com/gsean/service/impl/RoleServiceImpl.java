package com.gsean.service.impl;


import com.gsean.dao.RoleMapper;
import com.gsean.entity.Role;
import com.gsean.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 通用 serviceImpl 代码生成器
*
* @author GSean
*/
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int save(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateById(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Role selectById(Long id) {
       return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        Role role = new Role();
//        role.setId(id).setIsDeleted(true).setModifyTime(LocalDateTime.now());
        return roleMapper.updateByPrimaryKeySelective(role);
    }



}




