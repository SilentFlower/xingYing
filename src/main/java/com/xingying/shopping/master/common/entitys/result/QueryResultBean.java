package com.xingying.shopping.master.common.entitys.result;

/**
 * @author SiletFlower
 * 查询的结果实体类
 * @date 2021/3/1 02:01:45
 * @description
 */
public class QueryResultBean<T> extends ResultBean {
    public QueryResultBean(ReturnCode returnCode) {
        super(returnCode);
    }

    public QueryResultBean(ReturnCode returnCode, T data) {
        super(returnCode, data);
    }

    public QueryResultBean(T data) {
        super(data);
    }

    public QueryResultBean(Integer code, String message) {
        super(code, message);
    }

    public QueryResultBean(Integer code, String message, T data) {
        super(code, message, data);
    }
}
