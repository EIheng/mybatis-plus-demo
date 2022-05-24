package com.example.app.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@Data
@TableName(value = "order")
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单类型，为入库与出库
     */
    private Object orderType;

    /**
     * 订单状态
     */
    private String state;

    /**
     * 仓库id
     */
    private Integer repositoryId;

    /**
     * 公司名称，入库单为供应商，出库单为目的公司
     */
    private String companyName;

    /**
     * 货物id
     */
    private Integer productId;

    /**
     * 操作类型，如经销，加工
     */
    private String operation;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 购买单价
     */
    private BigDecimal price;

    /**
     * 注释
     */
    private String remarks;

}