package com.xingying.shopping.master.common.entitys.result;

/**
 * @author SiletFlower
 * 增删改的结果实体类
 * @date 2021/3/1 02:02:00
 * @description
 */
public class OperationResultBean<T> extends ResultBean {

    public OperationResultBean(ReturnCode returnCode) {
        super(returnCode);
    }

    public OperationResultBean(ReturnCode returnCode, T data) {
        super(returnCode, data);
    }

    public OperationResultBean(T data) {
        super(data);
    }

    public OperationResultBean(Integer code, String message) {
        super(code, message);
    }

    public OperationResultBean(Integer code, String message, T data) {
        super(code, message, data);
    }
}
