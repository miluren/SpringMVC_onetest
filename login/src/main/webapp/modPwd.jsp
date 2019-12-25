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
<form   method="post" action="account/login" enctype="multipart/form-data" id="modi">
    <div id="head">修改密码</div>
    旧密码:<input type="text" name="pwd" class="form-control" placeholder="旧密码"><br/>
    新密码:<input type="text" name="pwd1" class="form-control" placeholder="新密码"><br/>
    确认密码:<input type="text" name="pwd2" class="form-control" placeholder="确认密码"><br/>

    <input id="mod" type="button" value="确认修改"/>
    <a href="gly.jsp">返回</a>
</form>
<script>
    $(function () {
        $("#mod").click(function () {
            console.log($("#modi").find("input:first").val());
            if($("#modi").find("input:first").val() == ""){
                alert("请输入旧密码");
            }else if($("#modi").find("input:eq(1)").val() == ""){
                alert("请输入新密码");
            }else{
                if($("#modi").find("input:eq(1)").val() != $("#modi").find("input:eq(2)").val()){
                    alert("新密码确认密码输入不一致");
                }else{
                    $.ajax({
                       url:"account/Modifypwd",
                       type:"post",
                        contentType:"application/json;charset=utf-8",
                       data:JSON.stringify({
                           "oldpwd":$("input[name=pwd]").val(),
                           "newpwd":$("input[name=pwd1]").val(),
                           "surepwd":$("input[name=pwd2]").val()
                       }),
                        success:function (data) {
                            if(data.code == 200){
                                alert(data.message);
                                location.href = "gly.jsp";
                            }else if(data.code == 400){
                                alert(data.message);
                            }
                            else if(data.code == 405){
                                alert(data.message);
                            }
                            else {
                                alert(data.message);
                            }
                        }
                    });
                }
            }
        });

    });

</script>
</body>
</html>
