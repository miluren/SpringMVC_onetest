package cn.z.service.BookServiceImpl;

import cn.z.Json.Bookmanage;
import cn.z.Json.Bookpage;
import cn.z.Json.PageSet;
import cn.z.dao.BookDao;
import cn.z.domain.Book;
import cn.z.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired BookDao bookDao;

    //添加新书
    @Override
    public Integer Addbook(Book book) {
        return bookDao.Addbook(book);
    }

    //修改
    @Override
    public Integer modBook(Book book) {
        return bookDao.modBook(book);
    }

    //删除图书
    @Override
    public Integer delBook(Integer code) {
        return bookDao.delBook(code);
    }

    //查询图书
    @Override
    public List<Book> findBook(String book) {
        return bookDao.findBook(book);
    }
//查询图书并分页
    @Override
    public List<Book> findBookFy( Bookpage bookpage) {
        return bookDao.findBookFy(bookpage);
    }

    @Override
    public List<Book> allbooks() {
        return bookDao.allbooks();
    }


    @Override
    public List<Book> bookpage(Bookpage bookpage) {
        return bookDao.bookpage(bookpage);
    }

    @Override
    public List<Book> bookpage1(Bookpage bookpage) {
        return bookDao.bookpage1(bookpage);
    }

    @Override
    public Integer findpagination(Bookpage bookpage) {
        return bookDao.findpagination(bookpage);
    }

    @Override
    public Integer findAll() {
        return bookDao.findAll();
    }

    @Override//得到所有的图书
    public List<Book> getAllbook() {
        return bookDao.getAllbook();
    }

    @Override
    public List<Book> bookpage2(PageSet pageSet) {
        return bookDao.bookpage2(pageSet);
    }

    @Override
    public Integer upload(String path ,Integer id) {
        System.out.println("图片更改上传");
        return bookDao.upload(path,id);
    }

    @Override
    public Book findOneBook(Integer id) {
        System.out.println("查找一个书，通过code");
        return bookDao.findOneBook(id);
    }
}
