package cn.z.dao;

import cn.z.Json.Bookmanage;
import cn.z.Json.Bookpage;
import cn.z.Json.PageSet;
import cn.z.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Repository
public interface BookDao {

    //添加新书
    @Insert("insert into booktb(book_name,author,book_press,book_price,book_img,book_date,book_content,book_type,book_isbn) values(#{book_name},#{author},#{book_press},#{book_price},#{book_img},#{book_date},#{book_content},#{book_type},#{book_isbn })")
    public Integer Addbook(Book book);

    //修改图书
    @Update("update booktb set book_isbn=#{book_isbn}, book_name = #{book_name} ,author = #{author} ,book_press = #{book_press},book_type=#{book_type}, book_price = #{book_price} , book_img=#{book_img} , book_date=#{book_date} , book_content=#{book_content} where book_code = #{book_code}")
    public Integer modBook(Book book);

    //删除图书
    @Delete("delete from booktb where book_code = #{book_code}")
    public Integer delBook(Integer book_code);

    //查找图书
    @Select("select * from booktb where book_name like concat('%',#{name},'%') or book_press like concat('%',#{name},'%') or author like concat('%',#{name},'%') ")
    public List<Book> findBook(String name);
    //查找图书翻页
    @Select("select * from booktb where book_name like concat('%',#{name},'%') or " +
            "book_press like concat('%',#{name},'%') or author like concat('%',#{name},'%')" +
            " limit #{start},#{pagesize}")
    public List<Book> findBookFy(Bookpage bookpage);

    //得到所有图书
    @Select("select * from booktb")
    public List<Book>  allbooks();
    //分页
    @Select("select * from booktb limit #{start},#{pagesize}")
    public List<Book> bookpage(Bookpage bookpage);

    //分页1模糊查询
    @Select("select * from booktb where book_name like concat('%',#{name},'%') or " +
            "book_press like concat('%',#{name},'%') or author like concat('%',#{name},'%')" +
            " limit #{start},#{pagesize}")
    public List<Book> bookpage1(Bookpage bookpage);

    //模糊查询数量
    @Select("select count(*) from booktb where book_name like concat('%',#{name},'%') or " +
            "book_press like concat('%',#{name},'%') or author like concat('%',#{name},'%')")
    public Integer findpagination(Bookpage bookpage);

    @Select("select * from booktb limit #{start},#{persize}")
    public List<Book> bookpage2(PageSet pageSet);

    //查找所有数据
    @Select("select count(*) from booktb ")
    public  Integer  findAll();

    //得到所有的图书
    @Select("select * from booktb")
    public List<Book> getAllbook();

    //文件上传
    @Update("update booktb set  book_img = #{path}  where book_code=#{id}")
    public Integer upload(@Param("path") String path,@Param("id") Integer id);

    //通过code 查找图书
    @Select("select * from booktb where book_code = #{id}")
    public Book findOneBook(Integer id);

}

