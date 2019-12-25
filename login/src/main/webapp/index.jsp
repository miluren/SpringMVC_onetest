<%--
  Created by IntelliJ IDEA.
  User: 28078
  Date: 2019/11/19
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        form{
            display: block;
            margin-top: 50px;
            width: 300px;
            margin: 0px auto;

        }
        form div{
            font-size: 40px;
            margin-bottom: 20px;
            text-align: center;
            letter-spacing: 5px;
            /*filter:alpha(opacity=50);*/
            opacity:0.7;
        }
    </style>
</head>
    <!-- ZUI 标准版压缩后的 CSS 文件 -->
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/css/zui.min.css">
    <!-- ZUI Javascript 依赖 jQuery -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/lib/jquery/jquery.js"></script>
    <!-- ZUI 标准版压缩后的 JavaScript 文件 -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/js/zui.min.js"></script>

<body>
<form   method="post" action="account/login">
    <div>Login</div>
    用户名:<input type="text" name="name" class="form-control" placeholder="用户名"><br/>
    密码:<input type="text" name="pwd" class="form-control" placeholder="密码">
        <input type="radio" name="auth" value="1"> 管理员
        <input type="radio" name="auth" value="0" checked> 普通用户
    <br/>
    <input id="login" type="button" value="登录"/>
    <input id="zhuce" type="button" value="注册"/>

    <a href="tup.jsp">跳转图片</a>


</form>

<script>
    $("#login").click(function (e) {

        $.ajax({
            url: "account/login",
            type: "post",
            data: {
                name: $("[name=name]").val(),
                pwd: $("[name=pwd]").val(),
                qx: $("[name=auth]:checked").val()
            },
            success: function(data) {
                if(data.code === 201) {
                    location.href = "ptyh.jsp";
                }else if(data.code === 200){
                    location.href ="gly.jsp？bookmessage";
                }
                else{
                    alert(data.message);
                }
            }
        });
    });
    $("#zhuce").click(function (e) {
        location.href = "zhuce.jsp";
    });
</script>
</body>
</html>
