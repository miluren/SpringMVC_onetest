<%--
  Created by IntelliJ IDEA.
  User: 28078
  Date: 2019/11/26
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<link rel="stylesheet" type="text/css" href="css/zui.min.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/zui.min.js"></script>
<body>
<div id="box" class="">
    <div class="col col-md-12" >
    <img src="img/login.jpg" />
    <span id="login">登录</span>
</div>
<div id="box2">
    <div class="login col-md-8"><img src="img/23.jpg" /></div>
    <div class="col-md-4">
        <div id="tushu">图书管理系统登录</div>
        <div class="input-control has-label-left">
            <input id="inputAccountExample2" name="name" type="text" class="form-control" >
            <label for="inputAccountExample2" class="input-control-label-left">用户名:</label>
        </div>
        <div class="input-control has-label-left has-label-right">
            <input id="inputPasswordExample2" name="pwd" type="password" class="form-control">
            <label for="inputPasswordExample2" class="input-control-label-left">密码:</label>
            <!--<label for="inputPasswordExample2" class="input-control-label-right text-right text-success">安全!!!</label>-->
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="radioOptionsExample" value="0" checked> 普通用户
            </label>
            <label>
                <input type="radio" name="radioOptionsExample" value="1"> 管理员
            </label>
        </div>

        <div class="deng">
            <button class="btn btn-primary" type="button" id = "login111">登录</button>
            <button class="btn btn-primary" type="button" id = "zhuce">注册</button>
        </div>
    </div>
</div>
</div>
</body>
<script>
    $("#login111").click(function(){
        $.ajax({
            url: "account/login",
            type:"post",
            contentType: "application/json;charset=utf-8",
            data:JSON.stringify({
                "name":$("[name=name]").val(),
                "pwd": $("[name=pwd]").val(),
                "qx" : $("input[name=radioOptionsExample]:checked").val()

            }),
            success:function(data){
                if(data.code === 201) {
                    new $.zui.Messager('普通用户登录成功', {
                        icon: 'bell', // 定义消息图标
                        type: 'success' // 定义颜色主题
                    }).show();
                    location.href = "ptyh.jsp";

                }else if(data.code === 200) {
                    location.href = "gly.jsp";
                }else if(data.code == 405){
                    alert("身份错误");
                }else if(data.code == 406){
                    alert("该用户已被禁用");
                } else{
                    new $.zui.Messager('账号或密码错误', {
                        icon: 'bell' ,// 定义消息图标
                        type: 'danger' // 定义颜色主题
                    }).show();
                }
            }
        });
    });
    $("#zhuce").click(function () {
        location.href = "zhuce.jsp";
    });


</script>
</html>

