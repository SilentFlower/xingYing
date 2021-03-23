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
 * 星荧虚拟商品交易网站的权限表
 * </p>
 *
 * @author zhaoweihao
 * @since 2021-03-21
 */
@TableName(value = "PERMISSIONS",schema = "XINGYING_SHOP")
public class Permissions implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 权限表ID
     */
    @TableId(value = "PERMISSIONS_ID", type = IdType.INPUT)
    private Long permissionsId;

    /**
     * 资源名
     */
    @TableField("PERMISSIONS_NAME")
    private String permissionsName;

    /**
     * 功能类别;0代表系统，1无uri的文件夹菜单，2代表有uri的实际菜单，3代表按钮，4代表其他(既不是按钮也不是菜单的系统api)
     */
    @TableField("PERMISSIONS_TYPE")
    private Integer permissionsType;

    /**
     * 资源的uri
     */
    @TableField("PERMISSIONS_URI")
    private String permissionsUri;

    /**
     * 资源拼音输入码
     */
    @TableField("PERMISSIONS_PINYIN_CODE")
    private String permissionsPinyinCode;

    /**
     * 路径深度，默认0代表根节点
     */
    @TableField("PATH_DEEP")
    private Integer pathDeep;

    /**
     * 当前节点是否是叶子节点，0代表不是，1代表是叶子
     */
    @TableField("LEAF_NODE")
    private Integer leafNode;

    /**
     * 状态标识，默认1正常，2停用，3删除
     */
    @TableField("DATA_STATUS")
    private Integer dataStatus;

    /**
     * 数据创建时间
     */
    @TableField("DATA_CREATE_TIME")
    private LocalDateTime dataCreateTime;

    /**
     * 资源id路径描述符，利用该字段可解决多级查询问题
     */
    @TableField("PATH_DESCRIPTOR")
    private String pathDescriptor;

    /**
     * 父id,单级查询利用此字段可快速返回
     */
    @TableField("INLINE_FATHER_ID")
    private BigDecimal inlineFatherId;


    public Long getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Long permissionsId) {
        this.permissionsId = permissionsId;
    }

    public String getPermissionsName() {
            return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public Integer getPermissionsType() {
            return permissionsType;
    }

    public void setPermissionsType(Integer permissionsType) {
        this.permissionsType = permissionsType;
    }

    public String getPermissionsUri() {
            return permissionsUri;
    }

    public void setPermissionsUri(String permissionsUri) {
        this.permissionsUri = permissionsUri;
    }

    public String getPermissionsPinyinCode() {
            return permissionsPinyinCode;
    }

    public void setPermissionsPinyinCode(String permissionsPinyinCode) {
        this.permissionsPinyinCode = permissionsPinyinCode;
    }

    public Integer getPathDeep() {
            return pathDeep;
    }

    public void setPathDeep(Integer pathDeep) {
        this.pathDeep = pathDeep;
    }

    public Integer getLeafNode() {
            return leafNode;
    }

    public void setLeafNode(Integer leafNode) {
        this.leafNode = leafNode;
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

    public String getPathDescriptor() {
            return pathDescriptor;
    }

    public void setPathDescriptor(String pathDescriptor) {
        this.pathDescriptor = pathDescriptor;
    }

    public BigDecimal getInlineFatherId() {
            return inlineFatherId;
    }

    public void setInlineFatherId(BigDecimal inlineFatherId) {
        this.inlineFatherId = inlineFatherId;
    }

    @Override
    public String toString() {
        return "Permissions{" +
        "permissionsId=" + permissionsId +
        ", permissionsName=" + permissionsName +
        ", permissionsType=" + permissionsType +
        ", permissionsUri=" + permissionsUri +
        ", permissionsPinyinCode=" + permissionsPinyinCode +
        ", pathDeep=" + pathDeep +
        ", leafNode=" + leafNode +
        ", dataStatus=" + dataStatus +
        ", dataCreateTime=" + dataCreateTime +
        ", pathDescriptor=" + pathDescriptor +
        ", inlineFatherId=" + inlineFatherId +
        "}";
    }
}
