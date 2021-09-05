package com.itcro.ssm.service;

import com.itcro.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    //查询所有的产品信息
    List<Product> findAll() throws Exception;

    //产品添加
    void save(Product product) throws Exception;
}
