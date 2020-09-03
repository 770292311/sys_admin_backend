package com.gsean.service;


import com.gsean.entity.TUser;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;


/**
* 通用 service 代码生成器
*
* @author GSean
*/
public interface TUserService{

    int save(TUser TUser);

    int updateById(TUser TUser);

    TUser selectById(Long id);

    int deleteById(Long id);


}




