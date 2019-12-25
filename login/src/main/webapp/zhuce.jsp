<%--
  Created by IntelliJ IDEA.
  User: 28078
  Date: 2019/11/20
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        form{
            display: block;
            margin-top: 200px;
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
<form   method="post" action="account/login" enctype="multipart/form-data" id="uploadForm">
    <div id="head">注册用户</div>
    用户名:<input type="text" name="name" class="form-control" placeholder="用户名"><br/>
    密码:<input type="text" name="pwd" class="form-control" placeholder="密码"> <br/>

    <input id="zhuce" type="button" value="注册"/>
</form>
<script>
    $(function () {
        $("#zhuce").click(function (e) {
            var c=0;
            $.ajax({
                url:"account/save",
                type : "post",
                contentType: "application/json;charset=utf-8",
                data:JSON.stringify({
                    "name":$("[name=name]").val(),
                    "pwd" :$("[name=pwd]").val(),
                }),
                success: function (data) {
                    if(data.code === 401) {
                        alert(data.message);
                        location.href = "zhuce.jsp"
                    }else if (data.code == 405){
                        alert(data.message);
                        location.href = "zhuce.jsp"
                        c=1
                    }else{
                        alert(data.message);
                        location.href = "login.jsp";
                    }
                }
            });
        });

    });

</script>
</body>
</html>
