package com.edu.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "shop_order")
public class OrderPojo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private String uaccount;
    private int gid;
    private String gimage;
    private String gname;
    private int gnum;
    private double gprice;
    private Date odate;
    private float gtotal;
    private String uname;
    private String uaddress;
    private String opaytype;
    private int opaystatus;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public float getGtotal() {
        return gtotal;
    }

    public void setGtotal(float gtotal) {
        this.gtotal = gtotal;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getOpaytype() {
        return opaytype;
    }

    public void setOpaytype(String opaytype) {
        this.opaytype = opaytype;
    }

    public int getOpaystatus() {
        return opaystatus;
    }

    public void setOpaystatus(int opaystatus) {
        this.opaystatus = opaystatus;
    }
}
