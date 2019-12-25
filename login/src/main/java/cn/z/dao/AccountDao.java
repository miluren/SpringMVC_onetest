package cn.z.dao;

import cn.z.domain.Account;
import cn.z.domain.Book;
import cn.z.domain.XgAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    //登录
    @Select("select * from logintb where name = #{name} and pwd = #{pwd} ")
    public Account login(Account account);

    //注册用户
    @Insert("insert into logintb(name,pwd,qx) value( #{name},#{pwd},0)")
    public Integer save(Account account);
    //禁用
    @Update("update logintb set qx=2 where id=#{uid}")
    public Integer forbidden(Integer uid);
    //解除禁用
    @Update("update logintb set qx=0 where id=#{uid}")
    public Integer removeforbidden(Integer uid);

    //检查是否重复
    @Select("select count(*) from logintb where name = #{name}")
    public Integer checkname(Account account);

    //查找所有用户
    @Select("select * from logintb where name like CONCAT('%',#{name},'%')")
    public List<Account> findAll(Account account);

    //上下一页
    @Select("select * from logintb limit #{start},#{pagesize}")
    public List<Account> page(cn.z.Json.Select select);

    //查询所有用户  用于计算一共几页
    @Select("select count(*) from logintb")
    public Integer Allaccount();

    //修改密码
    @Update("update logintb set pwd = #{newpwd} where id = #{id}")
    public Integer Modifypwd(XgAccount xgAccount);
    //通过id查找用户

    //文件上传
    @Update("update logintb set  img = #{path}  where id=#{id}")
    public Integer upload(@Param("path") String path,@Param("id") Integer id);

}
