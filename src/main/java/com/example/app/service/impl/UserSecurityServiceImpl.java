package com.example.app.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.app.exception.ParamException;
import com.example.app.mapper.UserSecurityMapper;
import com.example.app.model.entity.UserSecurity;
import com.example.app.model.params.LoginParam;
import com.example.app.model.vo.TokenInfo;
import com.example.app.service.UserSecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserSecurityServiceImpl extends ServiceImpl<UserSecurityMapper, UserSecurity> implements UserSecurityService {

    public TokenInfo login(LoginParam param) {
        String username = param.getUsername();
        String password = param.getPassword();

        UserSecurity userSecurity = getOne(new QueryWrapper<UserSecurity>().eq("username", username));

        // 用户不存在、账号错误或密码错误
        if (userSecurity == null ||
                !userSecurity.getUsername().equals(username) ||
                !userSecurity.getPassword().equals(password)) {
            log.info("登录失败，参数：{}", param);
            throw new ParamException("登录失败，账号密码错误!");
        }

        StpUtil.login(userSecurity.getId());
        log.info("用户{} 登录成功！", userSecurity.getId());

        return new TokenInfo(StpUtil.getTokenName(), StpUtil.getTokenValue());
    }

}




