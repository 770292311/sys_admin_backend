package com.gsean.dao;

import com.gsean.entity.TUser;
import com.gsean.entity.UserPermissionResp;
import tk.mybatis.mapper.MyMapper;

import java.util.List;
import java.util.Map;

public interface TUserMapper extends MyMapper<TUser> {
    List<UserPermissionResp> selectUserPermission(Map<String,Object> map);
}