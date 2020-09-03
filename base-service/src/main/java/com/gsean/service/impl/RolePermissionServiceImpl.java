package com.gsean.service.impl;


import com.gsean.dao.RolePermissionMapper;
import com.gsean.entity.RolePermission;
import com.gsean.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 通用 serviceImpl 代码生成器
*
* @author GSean
*/
@Service
public class RolePermissionServiceImpl implements RolePermissionService{

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int save(RolePermission rolePermission) {
        return rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public int updateById(RolePermission rolePermission) {
        return rolePermissionMapper.updateByPrimaryKeySelective(rolePermission);
    }

    @Override
    public RolePermission selectById(Long id) {
       return rolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        RolePermission rolePermission = new RolePermission();
//        rolePermission.setId(id).setIsDeleted(true).setModifyTime(LocalDateTime.now());
        return rolePermissionMapper.updateByPrimaryKeySelective(rolePermission);
    }



}




