package service;

import com.edu.pojo.GoodsPojo;

import java.util.List;

public interface IGoodsService {
    public List<GoodsPojo> queryGoodsAll();

    //根据gid查询
    public GoodsPojo findGoodsPojoByGid(int gid);
    public List<GoodsPojo> findAllByGclass(int gclass);
}
