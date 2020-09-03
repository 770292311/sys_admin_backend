package com.gsean.controller;

import com.gsean.domain.Result;
import com.gsean.dto.req.UserReqDto;
import com.gsean.entity.TUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProjectName：myspringboot
 * ClassName：UserController
 * Description：TODO
 * Date：2020/6/30 14:22
 * Author：GSean
 * Version: 1.0
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户管理")
public class UserController {
    @GetMapping()
    @ApiOperation(value = "获取用户列表")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public Result<List<TUser>> userList() {
        return Result.success(null);
    }

    @PostMapping()
    @ApiOperation(value = "新增用户")
    @RequiresPermissions(value = {"user:add"})
    public Result userAdd(@RequestBody UserReqDto userReqDto) {
        return Result.success();
    }

    @PutMapping()
    @ApiOperation(value = "更新用户")
    @RequiresPermissions(value = {"user:update"})
    public Result userUpdate(@RequestBody UserReqDto userReqDto) {
        return Result.success();
    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "删除用户")
    @RequiresPermissions(value = {"user:del"})
    public Result userDelete(@PathVariable Long id) {
        return Result.success();
    }

}
