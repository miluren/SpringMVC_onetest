<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 28078
  Date: 2019/11/22
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="css/gly.css">
<link rel="stylesheet" type="text/css" href="css/zui.min.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/zui.min.js"></script>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <ul class="nav nav-tabs">
        <li class="active"><a data-tab href="#tabContent1">首页</a></li>
        <li><a data-tab href="#tabContent2">用户管理</a></li>
        <li><a data-tab href="#tabContent3">图书管理</a></li>
    </ul>
</nav>
<a id="logout" class="col-xs-2" >退出</a>
<div class="row content">
    <div class="col col-md-2" ></div>
    <div class="tab-content">
        <div class="col col-md-8 content1 tab-pane active" id="tabContent1" >
            <div class="yonghu">
                <div class="yonghu1">
                    <img class="yonghuhead" src= "${Yh.img}" />
                    <form action="" method="post" enctype="multipart/form-data" id="uploadForm">
                        <input type="file" name="upload" id="upload"/>
                        <input type="button" id="gofile" value="更改头像" />
                    </form>
                </div>
                <div class="yonghu2">
                    <div class="uname">用户名：</div>
                    <div class="uname2">${Yh.name}</div>
                    <div class="password"><input type="button" class="btn" value="修改密码"/></div>
                </div>
                <div class="yonghu3">
                    <div class="yonghu3-1">
                        <input class="inputSearchExample1 form-control search-input" type="search"placeholder="搜索">
                        <button>搜索</button>
                    </div>
                </div>
            </div>
            <div class="book1 col-md-6">
                <div class="col-md-12" style="border: gainsboro 1px solid">
                    <div class="col-md-5 book1-1" >
                        <img src="img/23.jpg"/>
                        <span class="price">价格：</span>
                    </div>
                    <div class="col-md-7 book1-2" >
                        <div  class="col col-md-12 book-name">书名:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12  book-author">作者:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12 book-press">出版社:</div>
                        <span class="book-name-content col-md-12"></span>
                        <button class="leibie">类别:</button>
                    </div>
                    <div class="col-md-12 book1-3" >
                        <div class="col col-md-12 book1-3-head" >内容:</div>
                        <div class="col col-md-12 book1-3-content"></div>
                    </div>
                </div>
            </div>
            <div class="book2 col-md-6">
                <div class="col-md-12" style="border: gainsboro 1px solid">
                    <div class="col-md-5 book1-1" >
                        <img src="img/23.jpg"/>
                        <span class="price">价格：</span>
                    </div>
                    <div class="col-md-7 book1-2" >
                        <div  class="col col-md-12 book-name">书名:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12  book-author">作者:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12 book-press">出版社:</div>
                        <span class="book-name-content col-md-12"></span>
                        <button class="leibie">类别:</button>
                    </div>
                    <div class="col-md-12 book1-3" >
                        <div class="col col-md-12 book1-3-head" >内容:</div>
                        <div class="col col-md-12 book1-3-content"></div>
                    </div>
                </div>
            </div>
            <div class="book3 col-md-6">
                <div class="col-md-12" style="border:  gainsboro 1px solid;">
                    <div class="col-md-5 book1-1" >
                        <img src="img/23.jpg"/>
                        <span class="price">价格：</span>
                    </div>
                    <div class="col-md-7 book1-2" >
                        <div  class="col col-md-12 book-name">书名:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12  book-author">作者:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12 book-press">出版社:</div>
                        <span class="book-name-content col-md-12"></span>
                        <button class="leibie">类别:</button>
                    </div>
                    <div class="col-md-12 book1-3" >
                        <div class="col col-md-12 book1-3-head" >内容:</div>
                        <div class="col col-md-12 book1-3-content"></div>
                    </div>
                </div>
            </div>
            <div class="book4 col-md-6">
                <div class="col-md-12" style="border: gainsboro 1px solid;">
                    <div class="col-md-5 book1-1" >
                        <img src="img/23.jpg"/>
                        <span class="price">价格：</span>
                    </div>
                    <div class="col-md-7 book1-2" >
                        <div  class="col col-md-12 book-name">书名:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12  book-author">作者:</div>
                        <span class="book-name-content col-md-12"></span>
                        <div class="col col-md-12 book-press">出版社:</div>
                        <span class="book-name-content col-md-12"></span>
                        <button class="leibie">类别:</button>
                    </div>
                    <div class="col-md-12 book1-3" >
                        <div class="col col-md-12 book1-3-head" >内容:</div>
                        <div class="col col-md-12 book1-3-content"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-12 bottom">
                <div class="page col-md-4">
                    <button value="0">上一页</button>
                    <span class="here">1</span><span> / </span><span class="all">1</span>
                    <button value="1">下一页</button>
                </div>
            </div>
        </div>
        <div class="col col-md-8 content2 tab-pane" id="tabContent2" >
            <table class="table">
                <caption>用户设置</caption>
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>pwd</th>
                    <th>qx</th>
                    <th>img</th>
                    <th>禁用</th>
                </tr>
                </thead>
                <tbody id="tbody">

                </tbody>
            </table>
            <div>
                <button id="previous">上一页</button>
                <span id="updown">1</span>
                <button id="nextpage">下一页</button>
            </div>
        </div>
        <div class="col col-md-8 content3 tab-pane" id="tabContent3" >
            <table class="table col-md-12 ctable">
                <caption>图书操作</caption>
                <thead>
                <tr>
                    <th width='80px' >book_code</th>
                    <th width='120px'>book_isbn</th>
                    <th width='120px'  >book_name</th>
                    <th width='120px' >author</th>
                    <th width='120px' >book_type</th>
                    <th width='120px' >出版社</th>
                    <th width='120px' >价格</th>
                    <th width='120px' >图片</th>
                    <th width='120px' >日期</th>
                    <th width='120px' >内容</th>
                    <th width='120px' >操作</th>
                </tr>
                </thead>
                <tbody id="tbody1">
                </tbody>
                <tr><td colspan="10"><button class="addbook">增加图书</button></td></tr>
                <tfoot id="tfoot">

                </tfoot>
            </table>
            <div>
                <ul id="myPager" class="pager" data-ride="pager"
                    data-page="1"
                    data-max-nav-count="4" data-elements="prev_icon,page_of_total_text,next_icon"></ul>
            </div>
        </div>
    </div>

    <div class="col col-md-12"></div>
</div>
<div class="name"></div>
<div id="foot">
    &copy;版权所有盗版必究，软件一班张晓清
</div>

<form action="" method="post" enctype="multipart/form-data" id="bookImgForm">
    <input type="file" name="upload" id="bookImg"/>
</form>

<script src="js/gly.js"></script>
</body>
</html>
