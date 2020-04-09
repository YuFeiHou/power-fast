package com.power.fast.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户与角色对应关系(SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-04-09 14:48:41
 */
@Data
@TableName("sys_user_role")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 671449313013459316L;
    @TableId
    private String id;
    /**
    * 用户ID
    */
    private String userId;
    /**
    * 角色ID
    */
    private String roleId;
}