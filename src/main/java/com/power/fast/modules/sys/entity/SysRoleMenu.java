package com.power.fast.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色与菜单对应关系(SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-04-09 14:38:31
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = -72305100575653693L;
    @TableId
    private String id;
    /**
    * 角色ID
    */
    private String roleId;
    /**
    * 菜单ID
    */
    private String menuId;
}