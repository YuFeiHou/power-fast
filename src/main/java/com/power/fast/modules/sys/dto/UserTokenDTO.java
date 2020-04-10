package com.power.fast.modules.sys.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户Token，存储在redis中
 *
 * @author fei
 */
@Data
public class UserTokenDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * token
     */
    private String token;
    /**
     * 过期时间
     */
    private Date expireTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
