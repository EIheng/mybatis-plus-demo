package com.example.app.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@TableName(value = "repository")
@EqualsAndHashCode(callSuper = true)
public class Repository extends BaseEntity {

    /**
     * 产品id
     */
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer num;

}