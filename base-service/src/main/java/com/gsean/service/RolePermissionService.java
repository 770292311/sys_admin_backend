package com.gsean.service;


import com.gsean.entity.RolePermission;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;


/**
* 通用 service 代码生成器
*
* @author GSean
*/
public interface RolePermissionService{

    int save(RolePermission rolePermission);

    int updateById(RolePermission rolePermission);

    RolePermission selectById(Long id);

    int deleteById(Long id);


}




