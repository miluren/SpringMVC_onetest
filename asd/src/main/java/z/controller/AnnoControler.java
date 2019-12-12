package z.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import z.domain.User;

import java.util.Date;
import java.util.Map;

/*
* 常用的注解
*
* */
@Controller
@SessionAttributes(value = {"meg"}) //把meg=笑笑存到session域中
public class AnnoControler {

    @RequestMapping("testRequesetBody")
    public String testRequesetParam(@RequestBody String body) {
        System.out.println("params");
        System.out.println(body);
        return "success";
    }

    /*
     * ModelAtrribute注解
     *
     * */
    @RequestMapping("testModelAtrribute")
    public String testModelAtrribute(@ModelAttribute("abc") User user) {
        System.out.println("测试");
        System.out.println(user);
        return "success";
    }
/*
    @ModelAttribute
    public void userModelAtrribute(String uname, Map<String, User> map) {
        //通过用户查询数据库(模拟)
//        相当于定义初始值
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        System.out.println("使用ModelAtrribute");
        System.out.println();
        map.put("abc", user);
    }


 */

    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("测试");
        //底层会储存到Requset域对象中
        model.addAttribute("meg","笑笑");
        return "success";
    }

    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes");
        //底层会储存到Requset域对象中
       // String meg = (String) model.getAttribute("meg");
        String meg = (String) modelMap.get("meg");
        System.out.println(meg);
        return "success";
    }

    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("getSessionAttributes");
        status.setComplete();
        System.out.println("删除");
        return "success";
    }

}
