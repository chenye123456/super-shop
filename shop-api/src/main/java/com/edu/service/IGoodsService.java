package com.edu.service;

import com.edu.pojo.GoodsPojo;

import java.util.List;

public interface IGoodsService {
    public List<GoodsPojo> queryGoodsAll();
    //根据商品类别查询
    public List<GoodsPojo> findAllByGtype(int gtype);
    //根据gid查询
    public GoodsPojo findGoodsPojoByGid(int gid);
    public List<GoodsPojo> findAllByGclass(int gclass);


}
