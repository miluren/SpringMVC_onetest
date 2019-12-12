<%--
  Created by IntelliJ IDEA.
  User: 28078
  Date: 2019/11/10
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="testRequesetBody" method="post">

    用户姓名：<input type="text" name="uname"><br/>
    用户年龄：<input type="text" name="age"><br/>
    <input type="submit" value="提交">

</form>
<%--
<form action="testModelAtrribute" method="post">
测试ModelAtrribute<br>
    用户姓名：<input type="text" name="uname"><br/>
    用户年龄：<input type="text" name="age"><br/>
    <input type="submit" value="提交">

</form>
--%>


    <a href="testSessionAttributes">testSessionAttributes</a>
    <a href="getSessionAttributes">getSessionAttributes</a>
    <a href="delSessionAttributes">delSessionAttributes</a>


</body>
</html>
