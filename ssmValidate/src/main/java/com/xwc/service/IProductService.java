package com.xwc.service;

import com.xwc.entity.Product;

import java.util.List;

/**
 * @author xwc
 * @create 2020-05-07 13:16
 * @name IProductService
 * @description
 */
public interface IProductService {

    public List<Product> findAllProduct();

    public Integer insertProduct(Product product);
}
