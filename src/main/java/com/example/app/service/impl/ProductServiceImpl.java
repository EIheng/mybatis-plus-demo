package com.example.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.app.mapper.ProductMapper;
import com.example.app.model.entity.Product;
import com.example.app.service.ProductService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}




