package cn.z.service;

import cn.z.Json.Bookmanage;
import cn.z.Json.Bookpage;
import cn.z.Json.PageSet;
import cn.z.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    //添加新书
    public Integer Addbook(Book book);

    //修改
    public Integer modBook(Book book);

    //删除图书
    public Integer delBook(Integer code);

    //查询图书
    public List<Book> findBook(String book);
    //查询并分页
    public List<Book> findBookFy( Bookpage bookpage);

    //得到所有的书籍
    public List<Book> allbooks();

    //分页
    public List<Book> bookpage(Bookpage bookpage);
    //分页1
    public List<Book> bookpage1(Bookpage bookpage);
    //查询
    public Integer findpagination(Bookpage bookpage);

    //查找一共几本图书
    public Integer findAll();

    //查找所有图书
    public List<Book> getAllbook();

    public List<Book> bookpage2(PageSet pageSet);

    //图片更改上传
    public Integer upload(String path,Integer id);

    //通过code 查找图书
    public Book findOneBook(Integer id);

}
