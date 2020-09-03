package com.gsean.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Table(name = "`t_user`")
@ApiModel(value = "用户信息")
public class TUser implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "用户id")
    private Long id;

    @Column(name = "`name`")
    @ApiModelProperty(value = "用户名称")
    private String name;

    @Column(name = "`email`")
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @Column(name = "`password`")
    @ApiModelProperty(value = "用户密码")
    private String password;

    @Column(name = "`is_deleted`")
    @ApiModelProperty(value = "用户状态")
    private Boolean isDeleted;


    @Column(name = "`create_time`")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @Column(name = "`modify_time`")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime modifyTime;


    private static final long serialVersionUID = 1L;
}