package com.xwc.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xwc
 * @create 2020-05-07 12:50
 * @name Product
 * @description
 */
public class Product implements Serializable {

    private Integer pro_id;

    @NotNull(message = "商品名不能为空",groups = {ProductAdd.class})
    @Pattern(regexp = "^[a-zA-Z0-9\\u4E00-\\u9FA5]{2,10}$",message = "商品名称必须由2到10个数字字母中文构成",groups = {ProductAdd.class})
    private String pro_name;

    @NotNull(message = "商品描述不能为空",groups = {ProductAdd.class})
    @NotEmpty(message = "商品描述不能为空",groups = {ProductAdd.class})
    @Pattern(regexp = "^[a-zA-Z0-9，。\\u4E00-\\u9FA5\\s]{2,200}$",message = "商品描述必须由2到10个数字、字母、中文构成",groups = {ProductAdd.class})
    private String pro_desc;

    public Product() {
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", pro_desc='" + pro_desc + '\'' +
                '}';
    }
}
