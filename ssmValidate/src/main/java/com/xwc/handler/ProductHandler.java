package com.xwc.handler;

import com.xwc.entity.Product;
import com.xwc.entity.ProductAdd;
import com.xwc.service.IProductService;
import com.xwc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xwc
 * @create 2020-05-07 13:18
 * @name ProductHandler
 * @description
 */
@Controller
@RequestMapping("/product")
public class ProductHandler {

    @Autowired
    IProductService productService;

    @RequestMapping("/findAll")
    @ResponseBody
    public AjaxResult findAllProduct() {
        List<Product> result = productService.findAllProduct();
        if(result != null) {
            return AjaxResult.success(result);
        } else {
            return AjaxResult.fail();
        }
    }

    @ResponseBody
    @RequestMapping("/insertProduct")
    public AjaxResult insertProduct(@Validated(value = ProductAdd.class) Product product, BindingResult bindingResult) {
        System.out.println(product);
        if(bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String,String> map = new HashMap<String, String>();
            for(FieldError errors:fieldErrors) {
                map.put(errors.getField()+"Errors",errors.getDefaultMessage());
            }
            return AjaxResult.failCheck(map);
        } else {
            Integer result = productService.insertProduct(product);
            if(result != 0) {
                return AjaxResult.success();
            } else {
                return AjaxResult.fail(product);
            }
        }
    }
}
