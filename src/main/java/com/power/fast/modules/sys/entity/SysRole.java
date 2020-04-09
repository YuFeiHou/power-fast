package com.power.fast.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.Serializable;

/**
 * 角色(SysRole)实体类
 *
 * @author makejava
 * @since 2020-04-09 14:32:41
 */
@Data
@TableName("sys_role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = -80062383999399121L;

    @TableId
    private String roleId;
    /**
    * 角色名称
    */
    @NotBlank(message="角色名称不能为空")
    private String roleName;
    /**
    * 备注
    */
    private String remark;
    /**
    * 创建者ID
    */
    private String createUserId;
    /**
    * 创建时间
    */
    private Date createTime;
}