package z.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.domain.Accont;
import z.domain.User;

@Controller
@RequestMapping("/param")
public class paramsControler {

    @RequestMapping(value = "/testparam")
    public String param(String params){
        System.out.println("params");
        return "success";
    }
    /**
     *
     * 请求参数把数据封装到javaBean中
     * @return
     */
    @RequestMapping("/saveAccont")
    public String saveAccont(Accont accont){
        System.out.println("params");
        System.out.println(accont);
        return "success";
    }

    @RequestMapping("saveUser")
    public String saveUser(User user){
        System.out.println("params");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("testRequesetParam")
    public String testRequesetParam(@RequestParam("uname") String username){
        System.out.println("params");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/fanhui")
    public String testfanhui(){
        System.out.println("返回执行");
        return "success";
    }

}
