package com.xingying.shopping.mas.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 星荧虚拟商品交易系统的用户表
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-16
 */
@TableName(value = "USER",schema = "XINGYING_SHOP")
public class User implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "USER_ID", type = IdType.INPUT)
    private BigDecimal userId;

    /**
     * 账户
     */
    @TableField("ACCOUNT")
    private String account;

    /**
     * 密码
     */
    @TableField("PASSWORDS")
    private String passwords;

    /**
     * 密码加密混淆盐值
     */
    @TableField("PASSWORDS_SALT")
    private String passwordsSalt;

    /**
     * 昵称
     */
    @TableField("NICK_NAME")
    private String nickName;

    /**
     * 真名
     */
    @TableField("REAL_NAME")
    private String realName;

    /**
     * 启用标志 0 停用 1启用
     */
    @TableField("ENABLED")
    private Integer enabled;

    /**
     * 删除标志 0 未删除 1已删除
     */
    @TableField("DELETED")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField("DATA_CREATE_TIME")
    private LocalDateTime dataCreateTime;

    /**
     * 性别
     */
    @TableField("SEX")
    private String sex;


    public BigDecimal getUserId() {
            return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getAccount() {
            return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswords() {
            return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getPasswordsSalt() {
            return passwordsSalt;
    }

    public void setPasswordsSalt(String passwordsSalt) {
        this.passwordsSalt = passwordsSalt;
    }

    public String getNickName() {
            return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
            return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getEnabled() {
            return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getDeleted() {
            return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDataCreateTime() {
            return dataCreateTime;
    }

    public void setDataCreateTime(LocalDateTime dataCreateTime) {
        this.dataCreateTime = dataCreateTime;
    }

    public String getSex() {
            return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", account=" + account +
        ", passwords=" + passwords +
        ", passwordsSalt=" + passwordsSalt +
        ", nickName=" + nickName +
        ", realName=" + realName +
        ", enabled=" + enabled +
        ", deleted=" + deleted +
        ", dataCreateTime=" + dataCreateTime +
        ", sex=" + sex +
        "}";
    }
}