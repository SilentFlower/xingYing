package com.xingying.shopping.master.common.entitys.result;

/**
 * @author SiletFlower
 * 返回类型码
 * @date 2021/3/1 01:31:25
 * @description
 */
public enum  ReturnCode {
    ACTIVE_EXCEPTION(-99, "系统异常"),
    ACTIVE_FAILURE(0, "操作失败"),
    ACTIVE_SUCCESS(10000, "操作成功"),
    LOGIN_SUCCESS(10001, "登陆成功"),
    NOT_LOGGED_IN(11000, "未登录"),
    LOGIN_FAIL(11001, "登陆失败"),
    ERROR_AUTH(11002, "无权限"),
    ERROR_PARAMS_NOT_NULL(11003, "参数不能为空"),
    ERROR_PARAMS(11004, "参数不完整"),
    ERROR_DUPLICATE(11005, "重复操作"),
    ERROR_PARAMS_DECRYPT(11006, "参数无法解密"),
    ERROR_WRONG(11007, "用户无法使用此系统"),
    ERROR_RESOURCES(11008, "请求资源不存在"),
    ERROR_PARAMS_FORMAT(11009, "参数格式错误");
    /**
     * 返回类型码
     */
    private Integer Code;

    /**
     * 返回信息
     */
    private String message;

    ReturnCode(Integer code, String message) {
        Code = code;
        this.message = message;
    }

    public Integer getCode() {
        return Code;
    }

    public String getMessage() {
        return message;
    }
}
