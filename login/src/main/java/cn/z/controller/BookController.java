package cn.z.controller;

import cn.z.Json.Bookmanage;
import cn.z.Json.Bookpage;
import cn.z.Json.PageSet;
import cn.z.Json.Select;
import cn.z.domain.Account;
import cn.z.domain.Book;
import cn.z.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@SessionAttributes(value = {"bookpage","name","list","bookmanage"})
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    //添加图书
    @RequestMapping("/Addbook")
    public @ResponseBody JSONResponse Addbook(@RequestBody Book book){
        JSONResponse jsonResponse = new JSONResponse();
        if(bookService.Addbook(book)==1){
            jsonResponse.setCode(200);
            jsonResponse.setMessage("添加图书成功");
        }else{
            jsonResponse.setCode(400);
            jsonResponse.setMessage("添加图书失败，请重试");
        }
        return  jsonResponse;
    }

    //修改图书
    @RequestMapping("/modBook")
    public @ResponseBody JSONResponse updatBook(@RequestBody Book book){
        JSONResponse jsonResponse = new JSONResponse();
        if(bookService.modBook(book)==1){
            jsonResponse.setCode(200);
            jsonResponse.setMessage("修改成功");
        }else{
            jsonResponse.setCode(500);
            jsonResponse.setMessage("修改失败");
        }

        return jsonResponse;
    }

    //删除图书
    @RequestMapping("/delBook")
    public @ResponseBody JSONResponse delBook(Integer bid){
        JSONResponse jsonResponse = new JSONResponse();
        if(bookService.delBook(bid)==1){
            jsonResponse.setCode(200);
            jsonResponse.setMessage("删除成功");
        }else{
            jsonResponse.setCode(500);
            jsonResponse.setMessage("删除失败");
        }
        return jsonResponse;
    }

    //查询图书 通过书名，作者，出版社
    @RequestMapping("/findBook")
    public @ResponseBody JSONResponse findBook(String name, HttpSession session, HttpServletRequest request){
        JSONResponse jsonResponse = new JSONResponse();
        session =request.getSession();
        session.setAttribute("name",name);
//        System.out.println(name);
        System.out.println(bookService.findBook(name));
        //获取所有查询的字段
        List<Book> list = bookService.findBook(name);
//        System.out.println(list.size());
        Bookpage bookpage = new Bookpage();
        bookpage.setName(name);
//        System.out.println(bookpage.getName());
        bookpage.setHerepage(1);
        bookpage.setStart(0);
        bookpage.setAllpages((list.size()+bookpage.getPagesize()-1)/bookpage.getPagesize());
        session.setAttribute("bookpage",bookpage);
        //把查询到的书进行分页.
        List<Book> bookfy = bookService.findBookFy(bookpage);
//        System.out.println(bookfy);
        jsonResponse.setFynum(bookfy.size());
        jsonResponse.setHerepage(bookpage.getHerepage());
        jsonResponse.setList(bookfy);
        jsonResponse.setCode(200);
        return jsonResponse;
    }


//登录时初始化book
    @RequestMapping("/getAllbook")
    public @ResponseBody JSONResponse getAllbook(Integer page, String name){
        JSONResponse response = new JSONResponse();
        // 分页对象, 包含page, start, perpage 修改page之后start会根据计算被修改
        Bookpage bookpage = new Bookpage();

        // 设置页数
        bookpage.setHerepage(page);
        bookpage.setName(name);
        // 查找所有的数据
        List<Book> books = bookService.bookpage1(bookpage);

        // 返回所有数据数量
        response.setTotal(bookService.findpagination(bookpage));
        response.setList(books);
        response.setHerepage(bookpage.getHerepage());

        return response;

    }

//图书管理分页
    @RequestMapping("/pagination")
    public @ResponseBody JSONResponse pagination(Integer page) {
        JSONResponse response = new JSONResponse();
        // 分页对象, 包含page, start, perpage 修改page之后start会根据计算被修改
        PageSet pageSet = new PageSet();
        // 设置页数
        pageSet.setPage(page);

        // 查找所有的数据
        List<Book> books = bookService.bookpage2(pageSet);

        // 返回所有数据数量
        response.setTotal(bookService.findAll());
        response.setList(books);

        return response;
    }
    //首页分页
    @RequestMapping("/pagination1")
    public @ResponseBody JSONResponse pagination1(Integer page,String name) {
        JSONResponse response = new JSONResponse();
        // 分页对象, 包含page, start, perpage 修改page之后start会根据计算被修改
        Bookpage bookpage = new Bookpage();

        // 设置页数
        bookpage.setHerepage(page);
        bookpage.setName(name);

        // 查找所有的数据
        List<Book> books = bookService.bookpage1(bookpage);

        // 返回所有数据数量
        response.setTotal(bookService.findpagination(bookpage));
        response.setList(books);

        return response;
    }

//上一页
    @RequestMapping("/uppage")
    public @ResponseBody JSONResponse uppage(HttpSession session){
        JSONResponse jsonResponse = new JSONResponse();
        Bookpage bookpage = (Bookpage) session.getAttribute("bookpage");
        if((bookpage.getHerepage()<2)){
            jsonResponse.setMessage("没有上一页");
            jsonResponse.setCode(404);
        }else{
            jsonResponse.setCode(200);
            jsonResponse.setMessage("上一页");
            bookpage.setHerepage(bookpage.getHerepage()-1);
            bookpage.setStart((bookpage.getHerepage()-1)*bookpage.getPagesize());
            //System.out.println(bookpage);
            List<Book> books = bookService.bookpage(bookpage);
            jsonResponse.setFynum(books.size());
            jsonResponse.setHerepage(bookpage.getHerepage());
            jsonResponse.setList(books);
        }
        return jsonResponse;
    }


    //上传文件
    @RequestMapping("upload")
    public @ResponseBody JSONResponse upload (Integer id , HttpServletRequest request, MultipartFile upload, HttpSession session) throws Exception {
        JSONResponse jsonResponse = new JSONResponse();
        //设置上传路径.文件的名字最好时用时间来命名
        String path = request.getSession().getServletContext().getRealPath("/bookImgs/");
        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        //获取文件上传的名字
        String filename = upload.getOriginalFilename();
        //把名字设置为唯一值)
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path, filename));
        //修改图片路径
        filename = "bookImgs/" + filename;

//        System.out.println(filename);
//        System.out.println("图片"+upload);

        if (bookService.upload(filename, id) == 1) {
            jsonResponse.setCode(200);
            jsonResponse.setMessage("修改图片成功");
            jsonResponse.setImg(bookService.findOneBook(id).getBook_img());

        } else {
            jsonResponse.setCode(404);
            jsonResponse.setMessage("修改图片失败");
        }
        return jsonResponse;

    }

}

