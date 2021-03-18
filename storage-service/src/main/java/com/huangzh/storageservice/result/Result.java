package com.huangzh.storageservice.result;

import lombok.Data;

@Data
public class Result<T> {

    private static final int SUCCESS = 1;

    private static final int FAIL = 1;

    private static final String SUCCESS_MSG = "请求成功";

    private static final String SUCCESS_FAIL = "请求失败";


    private String msg;

    private Integer code;

    private T data;

    public Result(String msg, Integer code, T data) {
        this.msg = SUCCESS_MSG;
        this.code = SUCCESS;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(SUCCESS_MSG, SUCCESS, data);
    }

    public static Result success() {
        return new Result(SUCCESS_MSG, SUCCESS, null);
    }

    public static Result fail() {
        return new Result(SUCCESS_FAIL, FAIL, null);
    }

    public static Result fail(String msg) {
        return new Result(msg, FAIL, null);
    }



}
