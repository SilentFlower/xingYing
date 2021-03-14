package com.xingying.shopping.master.web;

import java.io.Serializable;

/**
 * @author SiletFlower
 * 抽象返回实体
 * @date 2021/3/1 01:43:06
 * @description
 */
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = -7885201654334337223L;

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public ResultBean(ReturnCode returnCode) {
        this(returnCode, null);
    }

    public ResultBean(ReturnCode returnCode, T data) {
        this(returnCode.getCode(), returnCode.getMessage(), data);
    }

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultBean(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
