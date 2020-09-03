package com.gsean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ProjectName：sys_admin_backend
 * ClassName：UserPermissionResp
 * Description：TODO
 * Date：2020/9/3 14:55
 * Author：GSean
 * Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class UserPermissionResp implements Serializable {
    private Long id;
    private String name;
    private Long roleId;
    private String roleName;
    private Long permissionId;
    private String enName;
    private String url;
}
