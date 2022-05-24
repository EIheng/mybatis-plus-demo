package com.example.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.app.model.entity.UserSecurity;
import com.example.app.model.params.LoginParam;
import com.example.app.model.vo.TokenInfo;

public interface UserSecurityService extends IService<UserSecurity> {
    TokenInfo login(LoginParam param);
}
