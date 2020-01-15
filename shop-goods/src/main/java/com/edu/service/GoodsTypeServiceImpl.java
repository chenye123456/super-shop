package com.edu.service;

import com.edu.pojo.GoodsTypePojo;
import com.edu.repository.GoodsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IGoodsTypeService;

import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {
    @Autowired
    GoodsTypeRepository goodsTypeRepository;

    /**
     * 查询一级类别
     * @param pid
     * @return
     */
    @Override
    public List<GoodsTypePojo> queryGoodsTypeOne(int pid) {
        return goodsTypeRepository.findAllByPid(pid);
    }

    /**
     * 查询所有类别
     *
     * @return
     */
    @Override
    public List<GoodsTypePojo> queryGoodsTypeAll() {
        return goodsTypeRepository.findAll();
    }
}
