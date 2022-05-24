package com.example.app.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "product")
@EqualsAndHashCode(callSuper = true)

public class Product extends BaseEntity {

    /**
     * 货物名称
     */
    private String name;

    /**
     * 产品类型
     */
    private String type;

}