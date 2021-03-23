package com.xingying.shopping.mas.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 星荧虚拟商品交易系统的权限表和角色表的映射表
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@TableName(value = "PERMISSIONS_TO_ROLE",schema = "XINGYING_SHOP")
public class PermissionsToRole implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId(value = "PERMISSIONS_ID", type = IdType.INPUT)
    private Long permissionsId;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;

    public Long getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Long permissionsId) {
        this.permissionsId = permissionsId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "PermissionsToRole{" +
        "permissionsId=" + permissionsId +
        ", roleId=" + roleId +
        "}";
    }
}
