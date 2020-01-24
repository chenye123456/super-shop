package com.edu.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shop_goods")
public class GoodsPojo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gid;    //商品id
    private String gname;   //商品名
    private String gimage;  //图片
    private double gprice; //价格
    private int gstock; //库存
    private int gtype; //商品类型
    private int gclass; //0.推荐商品1.促销商品
    //private int pageNum; //当前页
    //private int pageSize; //显示多少条记录
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }



    public int getGtype() {
        return gtype;
    }

    public void setGtype(int gtype) {
        this.gtype = gtype;
    }

    public int getGstock() {
        return gstock;
    }

    public void setGstock(int gstock) {
        this.gstock = gstock;
    }

    public int getGclass() {
        return gclass;
    }

    public void setGclass(int gclass) {
        this.gclass = gclass;
    }
}
