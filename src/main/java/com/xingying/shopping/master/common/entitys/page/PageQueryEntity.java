package com.xingying.shopping.master.common.entitys.page;

import java.io.Serializable;

/**
 * @author SiletFlower
 * 分页查询实体
 * @date 2021/3/1 01:28:48
 * @description
 */
public class PageQueryEntity<T> implements Serializable {
    /**
     * 页数
     */
    private Integer pageSize;

    /**
     * 每页大小
     */
    private Integer pageNumber;

    /**
     * 查询数据
     */
    private T data;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
