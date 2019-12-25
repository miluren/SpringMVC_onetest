package cn.z.controller;

import cn.z.domain.Account;
import cn.z.domain.Book;

import java.util.List;

public class JSONResponse {

    private Integer code;
    private String message;
    private Integer fynum;//统计一页有多少本书
    private Integer herepage;//表示当前书的页数
    private String img;//设置登录用户的头像路径
    private List<Book> list;//存储书本信息
    private List<Account> accounts;//存储用户信息
    private List<Book> lists; //图书馆里
    private Integer h1;
    private Integer accountpage;//用户当前页
    private Integer total;      // 书籍总数

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getFynum() {
        return fynum;
    }

    public void setFynum(Integer fynum) {
        this.fynum = fynum;
    }

    public Integer getHerepage() {
        return herepage;
    }

    public void setHerepage(Integer herepage) {
        this.herepage = herepage;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getAccountpage() {
        return accountpage;
    }

    public void setAccountpage(Integer accountpage) {
        this.accountpage = accountpage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Book> getLists() {
        return lists;
    }

    public void setLists(List<Book> lists) {
        this.lists = lists;
    }

    public Integer getH1() {
        return h1;
    }

    public void setH1(Integer h1) {
        this.h1 = h1;
    }

    @Override
    public String toString() {
        return "JSONResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", fynum=" + fynum +
                ", herepage=" + herepage +
                ", img='" + img + '\'' +
                ", list=" + list +
                ", accounts=" + accounts +
                ", lists=" + lists +
                ", h1=" + h1 +
                ", accountpage=" + accountpage +
                '}';
    }
}
