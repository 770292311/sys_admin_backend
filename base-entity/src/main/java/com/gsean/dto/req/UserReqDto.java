package com.gsean.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ProjectName：sys_admin_backend
 * ClassName：UserReqDto
 * Description：TODO
 * Date：2020/9/2 18:25
 * Author：GSean
 * Version: 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "用户请求体")
public class UserReqDto implements Serializable {
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "邮箱")
    private String email ;
}
