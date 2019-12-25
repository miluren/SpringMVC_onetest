package cn.z.controller;

import cn.z.Json.Bookpage;
import cn.z.Json.Select;
import cn.z.Json.Bookmanage;
import cn.z.domain.Account;
import cn.z.domain.XgAccount;
import cn.z.service.AccountService;
import cn.z.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
//普通用户，所有书书，所有用户
@SessionAttributes(value = {"Yh",  "accounts","bookpage","select"})
//放到session域对象中，让它能够在页面中取值
@RequestMapping("/account")
public class AccountController {

    //自动装配
@Autowired
    private AccountService accountService;
@Autowired
    private BookService bookService;

    public AccountController() {
    }

    //登录
    @RequestMapping("/login")
    public @ResponseBody JSONResponse login(@RequestBody Account account,HttpSession session,HttpServletRequest request){
        JSONResponse response = new JSONResponse();
        Account Yh = accountService.login(account);

        session = request.getSession();
//        System.out.println(Yh);

        if(Yh == null) {
            response.setCode(404);
            response.setMessage("账户密码输入错误!");
        }else {
            if(Yh.getQx() != account.getQx() && Yh.getQx()!= 2){
                response.setCode(405);
                response.setMessage("身份错误错误!");
            }else if(account.getQx() == 0 && Yh.getQx()==0){
                response.setCode(201);
                response.setMessage("普通用户登录成功");
                session.setAttribute("Yh",Yh);
            }else if(account.getQx() == 1 && Yh.getQx() == 1){
                Select select = new Select();
                select.setAllpages((accountService.Allaccount()+select.getPagesize()-1) / select.getPagesize());

                List<Account> accounts = accountService.page(select);
                session.setAttribute("Yh",Yh);
                session.setAttribute("accounts", accounts);
                session.setAttribute("select", select);

                response.setCode(200);
                response.setMessage("管理员登录成功");

            }else if(account.getQx() == 0 && Yh.getQx() == 2){
                response.setCode(406);
                response.setMessage("用户已禁用");
            }
        }
        return response;
    }

    @RequestMapping("/logout")
    public @ResponseBody JSONResponse logout(HttpSession session, SessionStatus status){
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setCode(200);
        session.removeAttribute("Yh");
        status.setComplete();
        return jsonResponse;
    }

//初始化用户的信息
    @RequestMapping("/account")
    public @ResponseBody JSONResponse account(HttpServletRequest request,  HttpSession session){
       JSONResponse jsonResponse = new JSONResponse();
        Select select = new Select();
        select.setAllpages((accountService.Allaccount()+select.getPagesize()-1) / select.getPagesize());
        List<Account> accounts = accountService.page(select);
        jsonResponse.setAccounts(accounts);
        session.setAttribute("select", select);
        jsonResponse.setAccountpage(select.getHerepages());
       return jsonResponse;
    }

//注册

    @RequestMapping("/save")
    public @ResponseBody JSONResponse save(@RequestBody Account account){
        JSONResponse jsonResponse = new JSONResponse();
        int c = accountService.checkname(account);
//        System.out.println("检查");
        if (c==0){
            if(accountService.save(account)==1){
                jsonResponse.setCode(200);
                jsonResponse.setMessage("注册成功");
            }else{
                jsonResponse.setCode(405);
                jsonResponse.setMessage("注册失败");
            }

        }else{
            jsonResponse.setCode(401);
            jsonResponse.setMessage("注册失败,用户名重复");
        }
        return jsonResponse;
    }

// 禁用
    @RequestMapping("/forbidden")
    public @ResponseBody JSONResponse forbidden(Integer id){
        JSONResponse jsonResponse = new JSONResponse();;
        if(accountService.forbidden(id)==1){
            jsonResponse.setCode(200);
            jsonResponse.setMessage("禁用成功");
        }else{
            jsonResponse.setCode(404);
            jsonResponse.setMessage("禁用失败");
        }

        return jsonResponse;
    }
    // 解除禁用
    @RequestMapping("/removeforbidden")
    public @ResponseBody JSONResponse removeforbidden(Integer id){
        JSONResponse jsonResponse = new JSONResponse();
        if(accountService.removeforbidden(id)==1){
            jsonResponse.setCode(200);
            jsonResponse.setMessage("解除禁用成功");
        }else{
            jsonResponse.setCode(404);
            jsonResponse.setMessage("解除禁用失败");
        }

        return jsonResponse;
    }

    //查找
    @RequestMapping("/findMohu")
    public @ResponseBody JSONResponse findM(@RequestBody Account account){
        JSONResponse jsonResponse = new JSONResponse();
        List<Account> list = accountService.findM(account);
        if(list.size() == 0){
            jsonResponse.setCode(405);
            jsonResponse.setMessage("没有查询到该用户!");
        }else {
            jsonResponse.setCode(200);
            jsonResponse.setMessage("查询以下用户");
        }

        return jsonResponse;
    }
//下一页
    @RequestMapping("/nextpage")
    public @ResponseBody JSONResponse nextpage(HttpServletRequest request , HttpSession session){
        Select select = new Select();
        select = (Select) session.getAttribute("select");
        JSONResponse jsonResponse = new JSONResponse();
        if(select.getAllpages()<(select.getHerepages()+1)){
            jsonResponse.setMessage("没有下一页");
            jsonResponse.setCode(404);
        }else {
            jsonResponse.setCode(200);
            select.setHerepages(select.getHerepages() + 1);
            select.setStart((select.getHerepages() - 1) * select.getPagesize());
            List<Account> accounts = accountService.page(select);
            jsonResponse.setAccounts(accounts);
        }
        jsonResponse.setAccountpage(select.getHerepages());
        return jsonResponse;
    }

//上一页
    @RequestMapping("/previous")
    public @ResponseBody JSONResponse previous(HttpServletRequest request , HttpSession session){
        Select select = new Select();
        select = (Select) session.getAttribute("select");
        JSONResponse jsonResponse = new JSONResponse();
        if(select.getHerepages()<2){
            jsonResponse.setMessage("没有上一页");
            jsonResponse.setCode(404);
        }else {
            jsonResponse.setCode(200);
            select.setHerepages(select.getHerepages() - 1);
            select.setStart((select.getHerepages() - 1) * select.getPagesize());
            List<Account> accounts = accountService.page(select);
            jsonResponse.setAccounts(accounts);
        }
        jsonResponse.setAccountpage(select.getHerepages());
        return jsonResponse;
    }

//修改密码
    @RequestMapping("/Modifypwd")
    public @ResponseBody JSONResponse Modifypwd(@RequestBody XgAccount xgAccount , HttpServletRequest request){
        HttpSession session = request.getSession();
        JSONResponse jsonResponse = new JSONResponse();
        //((ArrayList)session.getAttribute("list")).get(0);
        Account account = (Account) session.getAttribute("Yh");
        if (xgAccount.getOldpwd().equals(account.getPwd())) {
            xgAccount.setId(account.getId());
            if (xgAccount.getNewpwd().equals(xgAccount.getSurepwd())) {
//                System.out.println(accountService.Modifypwd(xgAccount));
                if(accountService.Modifypwd(xgAccount)==1) {
                    jsonResponse.setCode(200);
                    jsonResponse.setMessage("修改成功");
                }else{
                    jsonResponse.setCode(400);
                    jsonResponse.setMessage("修改失败");
                }
            } else {
                jsonResponse.setCode(405);
                jsonResponse.setMessage("两次密码输入不一致");
            }
        }else {
            jsonResponse.setCode(404);
            jsonResponse.setMessage("旧密码输入错误");
        }

        return jsonResponse;
    }

    //上传文件
    @RequestMapping("upload")
    public @ResponseBody JSONResponse upload (HttpServletRequest request, MultipartFile upload,HttpSession session) throws Exception {
        JSONResponse jsonResponse = new JSONResponse();
        //设置上传路径.文件的名字最好时用时间来命名
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        //获取文件上传的名字
        String filename = upload.getOriginalFilename();
        //把名字设置为唯一值)
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));
        //修改图片路径
        filename = "uploads/"+filename;

//        System.out.println(filename);

        Account account = new Account();
        account = (Account) session.getAttribute("Yh");
        int id = account.getId();
//        System.out.println("路过3");
        //往数据库添加img路径
        if(accountService.upload(filename,id)==1){
            jsonResponse.setCode(200);
            jsonResponse.setMessage("修改图片成功");
            request.getSession().removeAttribute("Yh");

            jsonResponse.setImg(accountService.login(account).getImg());
        }else{
            jsonResponse.setCode(404);
            jsonResponse.setMessage("修改图片失败");
        }

        return jsonResponse;
    }

}
