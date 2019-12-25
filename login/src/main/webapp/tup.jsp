<%--
  Created by IntelliJ IDEA.
  User: 28078
  Date: 2019/11/25
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        img{
            display: block;
            width: 50px;
            height: 80px;
        }
    </style>
</head>
<script src="js/jquery.min.js"></script>
<body>
    <h3>Springmvc文件上传</h3>

    <form action="" method="post" enctype="multipart/form-data" id="uploadForm">
        选择文件：<br>
        <input type="file" name="upload" id="upload"/><br/>
        <input type="button" id="sc" value="上传" />
    </form>

    <p>图片显示</p>
    <img src="${imgpath}" alt="图片显示错误"/>
</body>
<script>
    $(function () {
        $("#sc").click(function () {
            // var file = $('#upload').get(0).files[0];
            // var formData = new FormData();
            // formData.append('upload',formData);

            var formData = new FormData($("#uploadForm")[0])  //创建一个forData
            formData.append('upload', $('#upload')[0].files[0]) //把file添加进去  name命名为img
            $.ajax({
               url:"account/upload",
               type:"post",
               data:formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                    location.href = "tup.jsp";
                }
            });
        });
    });
</script>
</html>
