package com.example.app.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "user_security")
@EqualsAndHashCode(callSuper = true)
public class UserSecurity extends BaseEntity {


    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}