package com.xwc.mapper;

import com.xwc.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xwc
 * @create 2020-05-07 13:13
 * @name ProductMapper
 * @description
 */
public interface ProductMapper {

    @Select("select * from product")
    public List<Product> findAllProduct();

    @Insert("insert into product (pro_name,pro_desc) values(#{pro_name},#{pro_desc})")
    public Integer insertProduct(Product product);


}
