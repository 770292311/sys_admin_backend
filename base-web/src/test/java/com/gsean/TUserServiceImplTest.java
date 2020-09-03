package com.gsean;

import com.alibaba.fastjson.JSON;
import com.gsean.entity.TUser;
import com.gsean.entity.UserPermissionResp;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProjectName：sys_admin_backend
 * ClassName：TUserServiceImplTest
 * Description：TODO
 * Date：2020/8/31 11:19
 * Author：GSean
 * Version: 1.0
 */
public class TUserServiceImplTest  extends BaseWebApplicationTest{

    @Test
    public void save() {
        TUser tUser = new TUser();
        tUser.setEmail("sdfsdf").setName("guo").setPassword("3423");
        tUserService.save(tUser);
    }


    @Test
    public void selectUserpermission(){
        Map<String,Object> map=new HashMap<>();
        map.put("userName","gsean");
        List<UserPermissionResp> userPermissionResps = tUserService.selectUserPermissions(map);
        System.out.println(JSON.toJSONString(userPermissionResps));
    }

}