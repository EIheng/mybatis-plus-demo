package com.example.app.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@TableName(value = "company")
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {

    /**
     * 公司名称
     */
    private String name;
}