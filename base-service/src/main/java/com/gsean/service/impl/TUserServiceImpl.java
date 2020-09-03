package com.gsean.service.impl;


import com.gsean.dao.TUserMapper;
import com.gsean.entity.TUser;
import com.gsean.entity.UserPermissionResp;
import com.gsean.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* 通用 serviceImpl 代码生成器
*
* @author GSean
*/
@Service
public class TUserServiceImpl implements TUserService{

    @Resource
    private TUserMapper TUserMapper;

    @Override
    public int save(TUser TUser) {
        return TUserMapper.insert(TUser);
    }

    @Override
    public int updateById(TUser TUser) {
        return TUserMapper.updateByPrimaryKeySelective(TUser);
    }

    @Override
    public TUser selectById(Long id) {
       return TUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        TUser TUser = new TUser();
//        TUser.setId(id).setIsDeleted(true).setModifyTime(LocalDateTime.now());
        return TUserMapper.updateByPrimaryKeySelective(TUser);
    }


    public TUser selectByUserName(String userName) {
        TUser tUser = new TUser();
        tUser.setName(userName).setIsDeleted(false);
        return TUserMapper.selectOne(tUser);
    }


    public List<UserPermissionResp> selectUserPermissions(Map<String,Object> map){
        map.put("isDeleted",false);
        return TUserMapper.selectUserPermission(map);
    }






}




