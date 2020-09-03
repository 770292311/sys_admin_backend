package com.gsean;

import com.gsean.config.redis.RedisClient;
import com.gsean.service.impl.TUserServiceImpl;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProjectName：sys_admin_backend
 * ClassName：BaseWebApplicationTest
 * Description：TODO
 * Date：2020/8/31 11:14
 * Author：GSean
 * Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class BaseWebApplicationTest {
    @Autowired
    protected TUserServiceImpl tUserService;
    @Autowired
    protected RedisClient redisClient;


    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(TUserServiceImplTest.class);//运行所有测试类
        Result result = JUnitCore.runClasses(RedisClientTest.class);//运行所有测试类
        for(Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        if(result.wasSuccessful()){
            System.out.println("Both Tests finished successfully...");
        }
    }

}