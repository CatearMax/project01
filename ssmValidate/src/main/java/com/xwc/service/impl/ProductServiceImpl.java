package com.xwc.service.impl;

import com.xwc.entity.Product;
import com.xwc.mapper.ProductMapper;
import com.xwc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xwc
 * @create 2020-05-07 13:16
 * @name ProductServiceImpl
 * @description
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }

    @Override
    public Integer insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }
}
