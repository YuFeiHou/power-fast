package com.power.fast.modules.sys.controller;

import com.power.fast.constant.HttpStatus;
import com.power.fast.modules.sys.from.SysLoginForm;
import com.power.fast.modules.sys.service.LoginService;
import com.power.fast.modules.sys.service.SysCaptchaService;
import com.power.fast.modules.sys.service.SysUserTokenService;
import com.power.fast.modules.sys.shiro.AuthFilter;
import com.power.fast.util.AjaxResult;
import com.power.fast.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author fei
 * @title: SysLoginController
 * @projectName power-fast
 * @description: 登录接口
 * @date 2020/4/8 17:20
 */
@Api(description = "用户登录")
@RestController
@RequestMapping("/sys")
public class SysLoginController extends BaseController {

    @Autowired
    private SysCaptchaService sysCaptchaService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private SysUserTokenService sysUserTokenService;


    /**
     * 验证码
     */
    @GetMapping(value = "/captcha.jpg", produces = MediaType.IMAGE_JPEG_VALUE)
    @ApiOperation("获取验证码")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ResponseBody
    @CrossOrigin
    public AjaxResult login(@RequestBody SysLoginForm form) throws IOException {
        //校验表单数据
        checkLoginForm(form);
        //登录验证
        return loginService.login(form);
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    @ApiOperation("退出登录")
    public AjaxResult logout(HttpServletRequest httpRequest) {
        //获取token
        String token = sysUserTokenService.getRequestToken(httpRequest);
        //提出登录
        sysUserTokenService.logout(token);

        return AjaxResult.success("退出登录成功！");
    }

    /**
     * 校验表单数据
     */
    public AjaxResult checkLoginForm(SysLoginForm sysLoginForm) {
        if (StringUtils.isEmpty(sysLoginForm.getUsername())) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "请输入用户名!");
        }

        if (StringUtils.isEmpty(sysLoginForm.getPassword())) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "请输入密码!");
        }

        if (StringUtils.isEmpty(sysLoginForm.getCaptcha())) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "请输入验证码!");
        }

        if (StringUtils.isEmpty(sysLoginForm.getUuid())) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "请输入Uuid!");
        }
        return AjaxResult.success("from表单数据正确");
    }


}
