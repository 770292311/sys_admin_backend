package com.gsean.service.impl;


import com.gsean.dao.PermissionMapper;
import com.gsean.entity.Permission;
import com.gsean.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 通用 serviceImpl 代码生成器
*
* @author GSean
*/
@Service
public class PermissionServiceImpl implements PermissionService{

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public int save(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int updateById(Permission permission) {
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public Permission selectById(Long id) {
       return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        Permission permission = new Permission();
//        permission.setId(id).setIsDeleted(true).setModifyTime(LocalDateTime.now());
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }



}




