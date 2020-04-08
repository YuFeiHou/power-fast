package com.power.fast.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.Serializable;

/**
 * 系统用户(SysUser)实体类
 *
 * @author makejava
 * @since 2020-04-08 16:49:53
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 100114123149399719L;

    @TableId
    private String userId;
    /**
    * 用户名
    */
    @NotBlank(message="用户名不能为空")
    private String userName;
    /**
    * 密码
    */
    @NotBlank(message="密码不能为空")
    private String password;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 盐
    */
    private String salt;
    /**
    * 邮箱
    */
    @NotBlank(message="邮箱不能为空")
    @Email(message="邮箱格式不正确")
    private String email;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 状态  0：禁用   1：正常
    */
    private Integer status;
    /**
    * 创建者ID
    */
    private String createUserId;
    /**
    * 创建时间
    */
    private Date createTime;
}