package com.power.fast.modules.sys.controller;

import com.power.fast.modules.sys.service.SysCaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.MediaSize;
import javax.servlet.ServletOutputStream;
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
public class SysLoginController {

    @Autowired
    private SysCaptchaService sysCaptchaService;

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
}
