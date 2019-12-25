package cn.z.test;


import cn.z.dao.AccountDao;
import cn.z.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class usertest {

    @Test
    public void  logintest() throws Exception {
        //加载mybatis配置
        InputStream in = Resources.getResourceAsStream("applicationContext.xml");
        //创建SqlSessionFactiry对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();

        AccountDao dao = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("zhang");
        account.setPwd("123");
        System.out.println(account);
        //关闭资源
        session.close();
        in.close();

    }
}
