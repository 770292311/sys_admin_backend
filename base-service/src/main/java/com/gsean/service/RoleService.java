package com.gsean.service;


import com.gsean.entity.Role;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;


/**
* 通用 service 代码生成器
*
* @author GSean
*/
public interface RoleService{

    int save(Role role);

    int updateById(Role role);

    Role selectById(Long id);

    int deleteById(Long id);


}




