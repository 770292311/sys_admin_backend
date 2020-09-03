package com.gsean;

import org.junit.Test;

/**
 * ProjectName：sys_admin_backend
 * ClassName：RedisClientTest
 * Description：TODO
 * Date：2020/9/1 14:39
 * Author：GSean
 * Version: 1.0
 */

public class RedisClientTest extends BaseWebApplicationTest{
    @Test
    public void testSave(){
        redisClient.set("test","testValue");
    }
}
