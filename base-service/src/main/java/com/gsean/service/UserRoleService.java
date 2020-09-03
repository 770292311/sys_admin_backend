package com.gsean.service;


import com.gsean.entity.UserRole;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;


/**
* 通用 service 代码生成器
*
* @author GSean
*/
public interface UserRoleService{

    int save(UserRole userRole);

    int updateById(UserRole userRole);

    UserRole selectById(Long id);

    int deleteById(Long id);


}




