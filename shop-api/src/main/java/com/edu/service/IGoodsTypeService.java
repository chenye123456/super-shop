package com.edu.service;

import com.edu.pojo.GoodsTypePojo;

import java.util.List;

public interface IGoodsTypeService {
    //根据pid查询一级类别
    public List<GoodsTypePojo> queryGoodsTypeOne(int pid);
    //根据pid查询所有类别
    public List<GoodsTypePojo> queryGoodsTypeAll();
    //根据pid查询二级类别
    public List<GoodsTypePojo> queryGoodsTypeTwo(int pid);
}
