package com.example.demo3.response;



import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private   int code;
    private  boolean success;
    private  String errorMsg;
    private  T data;

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String message) {
        this.code = code;
        this.errorMsg = message;
    }

    public Result() {

    }

    public Result(int code, String message, Boolean success) {
        this.code = code;
        this.errorMsg = message;
        this.success = success;
    }

    public Result(int code, String message, Boolean success,T data) {
        this.code = code;
        this.errorMsg = message;
        this.success = success;
        this.data = data;
    }


    public Result(int code, String message, T data) {
        this.code = code;
        this.errorMsg = message;
        this.data = data;
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(ResStateEnum.SUCCESS, msg,true);
    }

    public static <T> Result<T> success(T data) {
        return new Result(ResStateEnum.SUCCESS, null, true,data);
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result<>(ResStateEnum.SUCCESS, msg,true, data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(ResStateEnum.ERROR, msg,false);
    }

    public static <T> Result<T> error(String msg, T data) {
        return new Result<>(ResStateEnum.ERROR, msg,false, data);
    }

    public static <T> Result<T> error(String msg, int code) {
        return new Result<>( code,msg,false);
    }
}
