package com.xingying.shopping.mas.config.security.session;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SiletFlower
 * @date 2021/3/26 08:56:24
 * @description
 */
public class MySession {
    /**
     * 会话ID
     */
    private String id;

    /**
     * 创建时间
     */
    private long createTime = System.currentTimeMillis();

    /**
     * 最后访问时间
     */
    private long lastAccessedTime = createTime;

    /**
     * session存在时间 30分钟
     */
    private volatile long maxInactiveInterval = 30 * 60 * 1000;

    /**
     * 属性存储器
     */
    private ConcurrentHashMap<String, Object> attrs = new ConcurrentHashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    /**
     * 重置上次访问时间
     */
    void resetLastAccrssTime(){
        setLastAccessedTime(System.currentTimeMillis());
    }

    public long getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(long maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    public ConcurrentHashMap<String, Object> getAttrs() {
        return attrs;
    }

    public Object getAttrs(String key) {
        return attrs.get(key);
    }

    public void setAttrs(String key, Object attr) {
        this.attrs.put(key, attr);
    }

    public void removeAttrs(String key) {
        this.attrs.remove(key);
    }

    /**
     * 获取所有keys
     * @return
     */
    public Enumeration<String> getAttributeNames() {
        return attrs.keys();
    }

    /**
     * 作废session
     */
    public void invalidate() {
        attrs = null;
        maxInactiveInterval = -1;
    }
}
