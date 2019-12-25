package cn.z.domain;

import java.io.Serializable;

public class Account {

    private int id;
    private  String name ;
    private  String pwd;
    private  Integer qx;
    private  String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getQx() {
        return qx;
    }

    public void setQx(Integer qx) {
        this.qx = qx;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", qx=" + qx +
                ", img='" + img + '\'' +
                '}';
    }
}
