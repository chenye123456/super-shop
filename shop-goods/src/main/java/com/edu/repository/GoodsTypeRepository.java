package com.edu.repository;

import com.edu.pojo.GoodsTypePojo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsTypeRepository extends JpaRepository<GoodsTypePojo,Integer> {
    //根据pid 查询商品类别
    public List<GoodsTypePojo> findAllByPid(int pid);

    //查询所有商品类别
    public List<GoodsTypePojo> findAll();

}
