package z.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器
@Controller
@RequestMapping(value = "/user")
public class HelloController {
    /**
     * //params表示指定限制请求参数,这里是uname,代表传过来就必须有uname参数。。headers表示指定限定请求消息头进浏览器按F12，再点击网络....method = {RequestMethod.GET}
     * @return
     */

    @RequestMapping(value = "/hello")//按住ctrl+鼠标左键点击。进入class。。作用上path=value
    public  String sayHello(String uname ,String pwd){
        System.out.println("hello StringMVC");
        System.out.println("用户名:"+uname);
        System.out.println("密码:"+pwd);
        return  "success";
    }

}
