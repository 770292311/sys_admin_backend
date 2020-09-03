package com.gsean.service;


import com.gsean.entity.Permission;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;


/**
* 通用 service 代码生成器
*
* @author GSean
*/
public interface PermissionService{

    int save(Permission permission);

    int updateById(Permission permission);

    Permission selectById(Long id);

    int deleteById(Long id);


}




