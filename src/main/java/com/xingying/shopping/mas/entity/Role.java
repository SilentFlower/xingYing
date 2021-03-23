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
 * 星荧虚拟商品交易系统角色表
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@TableName(value = "ROLE",schema = "XINGYING_SHOP")
public class Role implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "ROLE_ID", type = IdType.INPUT)
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 状态标识，默认1正常，2停用，3删除
     */
    @TableField("DATA_STATUS")
    private Integer dataStatus;

    /**
     * 创建日期
     */
    @TableField("DATA_CREATE_TIME")
    private LocalDateTime dataCreateTime;

    /**
     * 角色创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
            return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getDataStatus() {
            return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public LocalDateTime getDataCreateTime() {
            return dataCreateTime;
    }

    public void setDataCreateTime(LocalDateTime dataCreateTime) {
        this.dataCreateTime = dataCreateTime;
    }

    public String getCreatedBy() {
            return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        ", dataStatus=" + dataStatus +
        ", dataCreateTime=" + dataCreateTime +
        ", createdBy=" + createdBy +
        "}";
    }
}
