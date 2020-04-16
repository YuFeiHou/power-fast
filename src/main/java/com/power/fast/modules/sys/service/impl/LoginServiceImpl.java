package com.power.fast.modules.sys.service.impl;
import com.power.fast.constant.HttpStatus;
import com.power.fast.modules.sys.entity.SysUser;
import com.power.fast.modules.sys.from.SysLoginForm;
import com.power.fast.modules.sys.service.LoginService;
import com.power.fast.modules.sys.service.SysCaptchaService;
import com.power.fast.modules.sys.service.SysUserService;
import com.power.fast.modules.sys.service.SysUserTokenService;
import com.power.fast.util.AjaxResult;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fei
 * @title: LoginServiceImpl
 * @projectName power-fast
 * @description: 用户登录实现
 * @date 2020/4/9 17:41
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysCaptchaService sysCaptchaService;
    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 用户登录
     *
     * @param sysLoginForm
     * @return
     */
    @Override
    public AjaxResult login(SysLoginForm sysLoginForm) {
        //获取验证码
        boolean captcha = sysCaptchaService.validate(sysLoginForm.getCaptcha(), sysLoginForm.getUuid());
        if (!captcha) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "验证码输入错误!");
        }

        //获取用户信息
        SysUser user = sysUserService.queryByUserName(sysLoginForm.getUsername());

        //账号不存在、密码错误
        if (!user.getPassword().equals(new Sha256Hash(sysLoginForm.getPassword(), user.getSalt()).toHex())) {
            return AjaxResult.error(HttpStatus.USER_PASSWORD_ERROR,"账号或密码不正确");
        }

        //账号锁定
        if (user.getStatus() == 0) {
            return AjaxResult.error(HttpStatus.USERNAME_LOCK,"账号已被锁定,请联系管理员！");
        }

        //生成token并且存入redis中;
        String token = sysUserTokenService.createToken(user.getUserId());

        return AjaxResult.success("token",token);
    }
}
