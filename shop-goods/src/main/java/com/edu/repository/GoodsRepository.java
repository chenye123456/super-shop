package com.edu.repository;

import com.edu.pojo.GoodsPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsRepository extends JpaRepository<GoodsPojo,Integer> {
    //查询促销商品和推荐商品
    public List<GoodsPojo> findAllByGclass(int gclass);

    public List<GoodsPojo> findAll();
    //根据商品类别查询
    public List<GoodsPojo> findAllByGtype(int gtype);


    //根据gid查询
    public GoodsPojo findGoodsPojoByGid(int gid);




}
