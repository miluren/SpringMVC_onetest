package cn.z.service;

import cn.z.Json.Select;
import cn.z.domain.Account;
import cn.z.domain.Book;
import cn.z.domain.XgAccount;

import java.util.List;

public interface AccountService {

    //登录
    public Account login(Account account);

    //注册
    public Integer save(Account account);
//禁用
    public Integer forbidden(Integer uid);
    //解除禁用
    public Integer removeforbidden(Integer uid);

    //检查
    public  Integer checkname(Account account);

    //查诈
    public List<Account> findM(Account account);

    //上下一页
    public  List<Account> page(Select select);
    //查询所有用户
    public  Integer Allaccount();

    //修改密码
    public Integer Modifypwd(XgAccount xgAccount);

    //文件上传
    public Integer upload(String path,Integer id);

}
