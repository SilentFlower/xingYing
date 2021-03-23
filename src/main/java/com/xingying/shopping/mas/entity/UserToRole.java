package com.xingying.shopping.mas.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户与角色的映射表
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@TableName(value = "USER_TO_ROLE",schema = "XINGYING_SHOP")
public class UserToRole implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "USER_ID", type = IdType.INPUT)
    private Long userId;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserToRole{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
