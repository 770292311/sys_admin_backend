/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.gsean.domain;

import com.gsean.enums.HttpReturnEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 消息对象
 * @author langhsu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -1491499610244557029L;

    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    /**
     * 状态码 0: success, -1: error
     */
    private int code;

    /**
     * 提示消息
     */
    private String message;

    /**
     * 结果数据
     */
    private T data;


    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return success("操作成功", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(Result.SUCCESS, message, data);
    }

    public static <T> Result<T> successMessage(String message) {
        return success(message, null);
    }

    public static <T> Result<T> failure(String message) {
        return failure(Result.ERROR, message);
    }

    public static <T> Result<T> failure(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> failure(HttpReturnEnum httpReturnEnum) {
        return new Result<>(httpReturnEnum.getCode(), httpReturnEnum.getMsg(), null);
    }

    public boolean isOk() {
        return code == SUCCESS;
    }

}
