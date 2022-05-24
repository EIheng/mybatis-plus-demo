package com.example.app.controller;

import com.example.app.model.entity.Company;
import com.example.app.model.entity.Order;
import com.example.app.model.entity.Product;
import com.example.app.model.params.IdParam;
import com.example.app.model.vo.DataResult;
import com.example.app.service.CompanyService;
import com.example.app.service.OrderService;
import com.example.app.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 幕冬
 * @since 2022年05月24日
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private final ProductService productService;

    private final CompanyService companyService;

    public OrderController(OrderService orderService, ProductService productService, CompanyService companyService) {
        this.orderService = orderService;
        this.productService = productService;
        this.companyService = companyService;
    }

    public DataResult<String> getOrderVO(@RequestBody IdParam param) {
        // 1. 查询订单
        Order order = orderService.getById(param.getId());
        // 2. 查询其对应公司
        Product product = productService.getById(order.getProductId());
        // 3. 查询其对应产品
//        Company company = companyService.getById(order.getCompanyId());
        // 4. 组装 略.....
        return null;
    }

}
