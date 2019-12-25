package cn.z.service.AccountServiceImpl;

import cn.z.Json.Select;
import cn.z.dao.AccountDao;
import cn.z.domain.Account;
import cn.z.domain.Book;
import cn.z.domain.XgAccount;
import cn.z.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountServic")
public class AccountServiceImpl implements AccountService {

    @Autowired private AccountDao accountDao;

    @Override
    public Account login(Account account) {
        System.out.println("用户登录... ");
        return  accountDao.login(account);
    }

    @Override
    public Integer save(Account account) {
        System.out.println("注册");
        return accountDao.save(account);
    }

    public Integer forbidden(Integer uid){
        System.out.println("禁用");
        return accountDao.forbidden(uid);
    }

    @Override
    public Integer removeforbidden(Integer uid) {
        System.out.println("解除禁用");
        return accountDao.removeforbidden(uid);
    }


    @Override
    public Integer checkname(Account account) {
        System.out.println("检查是否重复");
        return accountDao.checkname(account);
    }

    public List<Account> findM(Account account) {
        System.out.println("模糊查询");
        return accountDao.findAll(account);
    }

    @Override
    public List<Account> page(Select select) {
        System.out.println("上下分页");
        return accountDao.page(select);
    }

    @Override
    public Integer Allaccount() {
        return accountDao.Allaccount();
    }

    @Override
    public Integer Modifypwd(XgAccount xgAccount) {
        return accountDao.Modifypwd(xgAccount);
    }

    @Override
    public Integer upload(String path ,Integer id) {
        System.out.println("上传图片");
        return accountDao.upload(path,id);
    }


}
