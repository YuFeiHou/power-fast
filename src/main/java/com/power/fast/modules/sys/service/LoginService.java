package com.power.fast.modules.sys.service;

import com.power.fast.modules.sys.from.SysLoginForm;
import com.power.fast.util.AjaxResult;

/**
 * @author fei
 * @title: LoginService
 * @projectName power-fast
 * @description: 用户登录接口
 * @date 2020/4/9 17:40
 */
public interface LoginService {
    /**
     * 用户登录
     *
     * @param sysLoginForm
     * @return
     */
    AjaxResult login(SysLoginForm sysLoginForm);
}
