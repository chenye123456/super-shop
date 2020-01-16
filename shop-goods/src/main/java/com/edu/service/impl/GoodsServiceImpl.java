package com.edu.service;

import com.edu.pojo.GoodsPojo;
import com.edu.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IGoodsService;

import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    GoodsRepository goodsRepository;

    //推荐商品和促销产品查询展示
    @Override
    public List<GoodsPojo> findAllByGclass(int gclass) {
        return goodsRepository.findAllByGclass(gclass);
    }

    @Override
    public List<GoodsPojo> queryGoodsAll() {
        return null;
    }

    @Override
    public GoodsPojo findGoodsPojoByGid(int gid) {
        return goodsRepository.findGoodsPojoByGid(gid);
    }
}
