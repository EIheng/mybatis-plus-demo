package com.example.app.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.example.app.model.params.LoginParam;
import com.example.app.model.vo.DataResult;
import com.example.app.model.vo.TokenInfo;
import com.example.app.service.UserSecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 幕冬
 * @since 2022年01月21日
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserSecurityService userSecurityService;

    public AuthController(UserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

    /**
     * 登录
     * @param param 登录表单
     * @return token信息
     */
    @PostMapping("/login")
    public DataResult<TokenInfo> login(@RequestBody LoginParam param) {
        return DataResult.ok(userSecurityService.login(param));
    }

    /**
     * 是否登录
     * @return 是否登录
     */
    @PostMapping("/is-login")
    public DataResult<Boolean> isLogin() {
        return StpUtil.isLogin() ? DataResult.ok("用户已登录", true) : DataResult.error("用户未登录", false);
    }

    /**
     * 获取token信息
     * @return token信息
     */
    @SaCheckLogin
    @PostMapping("/token-info")
    public DataResult<TokenInfo> tokenInfo() {
        return DataResult.ok(new TokenInfo(StpUtil.getTokenName(), StpUtil.getTokenValue()));
    }

    /**
     * 登出
     * @return 信息
     */
    @SaCheckLogin
    @PostMapping("/logout")
    public DataResult<Object> logout() {
        int userId = StpUtil.getLoginIdAsInt();
        log.info("用户 {} 登出", userId);
        StpUtil.logout();
        return DataResult.ok();
    }

}
