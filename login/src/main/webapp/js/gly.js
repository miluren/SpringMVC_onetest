var signbookCode='';
var signthat='';
var data= '';
function setbookmessage(ec,data,i){
    // console.log(data.book_img)
     $(ec).find("img").attr("src",data.book_img);
    $(ec).find("span").eq(0).text("价格:"+data.book_price);
    $(ec).find("span").eq(1).text(data.book_name);
    $(ec).find("span").eq(2).text(data.author);
    $(ec).find("span").eq(3).text(data.book_press);
    $(ec).find("div").eq(8).text(data.book_content);
    $(ec).find("button").text(data.book_type);

    //修改书的图片

    $(ec).find('img').prop("onclick",null).off("click");
    $(ec).find('img').click(function () {
        signbookCode = data.book_code;
        signthat = $(this);
        console.log('书本图片')
        $("#bookImg").click();
    })



}



$("#bookImg").off().on("change", function () {
    var formData = new FormData($("#bookImgForm")[0]);  //创建一个forData
    console.log('得到的书本id'+signbookCode)
    formData.append('upload', $('#bookImg')[0].files[0]); //把file添加进去  name命名为img
    formData.append('id',signbookCode);
    $.ajax({
        url:"book/upload",
        type:"post",
        data:formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        // mimeType:"multipart/form-data",
        success: function (data) {
            if(data.code==200){
                alert("修改成功");
                signthat.prop("src",data.img);
                // $(".yonghuhead").attr("src",data.img);
            }
        }
    });
})
//用户初始化
function userInitialize(){
    $.ajax({
        url:"account/account",
        type:"post",
        success:function (data) {
            // console.log(data);
            if(data == 401) {
                alert("您没有登陆 ");
                location.href = "login.jsp"
            }
            //登录时初始化参数
            new $.zui.Messager('管理员登录成功', {
                icon: 'bell', // 定义消息图标
                type: 'success' // 定义颜色主题
            }).show();
            //第一种：动态创建表格的方式，使用拼接html的方式 （推荐）
            dynamic(data);

        }
    });
}
//动态表格参数 ->> 静态
function dynamic(data){
    //第一种：动态创建表格的方式，使用拼接html的方式 （推荐）
    var html = "";
    for( var i = 0; i < data.accounts.length; i++ ) {
        var auth = "普通用户";
        var permissions = "未禁用";
        html += "<tr>";
        html +=     "<td>" + data.accounts[i].id + "</td>";
        html +=     "<td>" + data.accounts[i].name +"</td>";
        html +=     "<td>" + data.accounts[i].pwd + "</td>";
        if(data.accounts[i].qx == 1) {
            auth = "管理员"
        }
        html +=     "<td>" + auth + "</td>";
        html +=     "<td>" + data.accounts[i].img + "</td>";
        if(data.accounts[i].qx== 2){
            permissions = "禁用中";
        }
        html +=     "<td><button>" + permissions + "</button><td/>";
        html += "</tr>";
    }
    $("#tbody").html(html);
    //禁用用户
    $("#tbody").find("button").click(function () {
        var id = $(this).parent().parent().find("td:first").text();
        if($(this).text()=="未禁用"){
            if(confirm("是否禁用")) {
                var that = this;
                $.ajax({
                    url: "account/forbidden",
                    type: "post",
                    data: {
                        id: id
                    },
                    success: function (data) {
                        if (data.code == 200) {
                            alert(data.message);
                            $(that).text("禁用中");
                        } else {
                            alert(data.message);
                        }
                    }
                });
            }
        }else{
            if(confirm("是否解除禁用")) {
                var that = this;
                $.ajax({
                    url: "account/removeforbidden",
                    type: "post",
                    data: {
                        id: id
                    },
                    success: function (data) {
                        if (data.code == 200) {
                            alert(data.message);
                            $(that).text("未禁用");
                        } else {
                            alert(data.message);
                        }
                    }
                });
            }
        }
    });
}
//确定图书
function surebook(parent,that){
    var book_code1 = parent.find("td:first").text();
    var book_isbn1 = parent.find("input:first").val();
    var book_name1 = parent.find("input:eq(1)").val();
    var author1 = parent.find("input:eq(2)").val();
    var book_type1 = parent.find("input:eq(3)").val();
    var book_press1 = parent.find("input:eq(4)").val();
    var book_price1 = parent.find("input:eq(5)").val();
    var book_img1 = parent.find("input:eq(6)").val();
    var book_date1 = parent.find("input:eq(7)").val();
    var book_content1 = parent.find("input:eq(8)").val();
    $.ajax({
        url:"book/modBook",
        type:"post",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({
            "book_code":book_code1,
            "book_isbn":book_isbn1,
            "book_name":book_name1,
            "author":author1,
            "book_type":book_type1,
            "book_press":book_press1,
            "book_price":book_price1,
            "book_img":book_img1,
            "book_date":book_date1,
            "book_content":book_content1

        }),
        success:function (data) {
            if(data.code == 200){
                alert(data.message);
                parent.find("td:eq(1)").text(book_isbn1);
                parent.find("td:eq(2)").text(book_name1);
                parent.find("td:eq(3)").text(author1);
                parent.find("td:eq(4)").text(book_type1);
                parent.find("td:eq(5)").text(book_press1);
                parent.find("td:eq(6)").text(book_price1);
                parent.find("td:eq(7)").text(book_img1);
                parent.find("td:eq(8)").text(book_date1);
                parent.find("td:eq(9)").text(book_content1);
                $(that).text("修改");
                Feny(1,"");
                pagi(1);
            }else{
                alert(data.message);
            }
        }
    });
}
//图书管理界面
function dynamicbook(data) {
    var html1 = "";
    for( var i = 0; i < data.list.length; i++ ) {
        html1 += "<tr>";
        html1 +=     "<td style='width: 200px;height:80px;display: inline-block'>" + data.list[i].book_code + "</td>";
        html1 +=     "<td >" + data.list[i].book_isbn +"</td>";
        html1 +=     "<td class='col-md-1'>" + data.list[i].book_name + "</td>";
        html1 +=     "<td class='col-md-1'>" + data.list[i].author + "</td>";
        html1 +=     "<td width='100px'>" + data.list[i].book_type + "</td>";
        html1 +=     "<td width='120px'>" + data.list[i].book_press + "</td>";
        html1 +=     "<td  width='200px'>" + data.list[i].book_price + "</td>";
        html1 +=     "<tdstyle='overflow: hidden;width:120px;height: 60px;height:120px; text-overflow: ellipsis; white-space: nowrap;display: inline-block;'>" + data.list[i].book_img + "</td>";
        html1 +=     "<td width='120px'>" + data.list[i].book_date + "</td>";
        html1 +=     "<td style='overflow: hidden;width:200px; text-overflow: ellipsis;height:80px; white-space: nowrap;display: inline-block;'>" + data.list[i].book_content + "</td>";
        html1 +=     "<td width='120px'><button class='btn-danger'>删除</button><button class='btn-primary'>修改</button><td/>";
        html1 += "</tr>";
    }
    $("#tbody1").html(html1);
    $("#updown1").text(data.h1);

    //把图书图片上传的按钮设为隐藏
    $("#bookImgForm").css('display',"none");
    //删除图书
    $("#tbody1").find("button").click(function () {
        var parent = $(this).parent().parent();
        var id = $(this).parent().parent().find("td:first").text();
        var that = this;
        if ($(this).text()=="删除"){
            if (confirm("是否删除")){
                var that = this;
                $.ajax({
                    url:"book/delBook",
                    type:"post",
                    data:{
                        bid:id
                    },
                    success:function (data) {
                        if (data.code==200){
                            alert(data.message);
                            pagi(1);
                            Feny(1,"");
                        }else{
                            alert(data.message);
                        }
                    }
                });

            }//修改
        }else if($(this).text()=="修改"){
            var book_isbn = parent.find("td:eq(1)").text();
            var book_name = parent.find("td:eq(2)").text();
            var author = parent.find("td:eq(3)").text();
            var book_type = parent.find("td:eq(4)").text();
            var book_press = parent.find("td:eq(5)").text();
            var book_price = parent.find("td:eq(6)").text();
            var book_img = parent.find("td:eq(7)").text();
            var book_date = parent.find("td:eq(8)").text();
            var book_content = parent.find("td:eq(9)").text();

            var $isbn1 = $("<input type='text' style='width: 120px' value="+ book_isbn +">");
            var $name = $("<input type='text' style='width: 120px' value="+ book_name +">");
            var $author = $("<input type='text' style='width: 120px' value="+ author +">");
            var $type = $("<input type='text' style='width: 100px' value="+ book_type +">");
            var $press = $("<input type='text' style='width: 120px' value="+ book_press +">");
            var $price = $("<input type='text' style='width: 120px' value="+ book_price +">");
            var $img = $("<input type='text' style='width: 120px' value="+ book_img +">");
            var $date = $("<input type='date' style='width: 120px' value="+ book_date +">");
            var $content = $("<input type='text' value="+ book_content +">");
            parent.find("td:eq(1)").empty().append($isbn1);
            parent.find("td:eq(2)").empty().append($name);
            parent.find("td:eq(3)").empty().append($author);
            parent.find("td:eq(4)").empty().append($type);
            parent.find("td:eq(5)").empty().append($press);
            parent.find("td:eq(6)").empty().append($price);
            parent.find("td:eq(7)").empty().append($img);
            parent.find("td:eq(8)").empty().append($date);
            parent.find("td:eq(9)").empty().append($content);
            $(this).text("确定");
        }else{
            surebook(parent,that)
        }
    });
}
// 手动进行初始化
var options = {
    page: 1,
    recTotal: 100,
    recPerPage: 5,
    onPageChange: function(state, oldState) {
        pagi(state.page);
    }
};
$('#myPager').pager(options);
//调用zui的分页插件绑定到ajax事件上
function pagi(page) {
    $.ajax({
        url: "book/pagination?page=" + page,
        success: function(data) {
            dynamicbook(data);
            // console.log(data);
            // console.log(data.total);
            var myPager = $('#myPager').data('zui.pager');
            myPager.set({
                recTotal: data.total
            });

        }
    });
}

function Feny(page,name){
    $.ajax({
        url:"book/getAllbook?page="+page+"&name="+name,
        type:"post",
        success:function (data) {
            var i;
            var j;
            for(j=0;j<4;j++){
                $(".book"+(j+1)).attr("style","display:block;");//显示div
            }
            console.log(data);
            //alert(data.data.list[1].book_img);
            // console.log(data.list.length+"  datalength")
            for(i=0;i<data.list.length;i++){
                setbookmessage(".book"+(i+1),data.list[i],i);

            }
            if(i<4){
                for(j=data.list.length;j<4;j++){
                    $(".book"+(j+1)).attr("style","display:none;");//隐藏div
                }
            }
            // console.log(data);
            $(".here").text(data.herepage);
            $(".all").text(parseInt((data.total+3)/4));
            if($(".here").text()==1){
                $(".page").find("button:first").attr("disabled", "disabled");
            }else{
                $(".page").find("button:first").attr("disabled", false);
            }
            if($(".here").text()== $(".all").text()){
                $(".page").find("button:last").attr("disabled", "disabled");
            }else{
                $(".page").find("button:last").attr("disabled", false);
            }
        }

    });
}


$(function () {
    //设置用户初始化
    userInitialize();

    //隐藏文件上传的文件
    $("#upload").css("display","none");
    //设置content1上下页
    // var name = $(".name").text();
    // var page = $(".here").text();
    $(".yonghu2").find("input").click(function(){
        location.href = "modPwd.jsp";
    });
    Feny(1,"");

    $("#logout").click(function(){
        $.ajax({
            url:"account/logout",
            type:"post",
            success:function (data) {
                if(data.code==200){
                    location.href="login.jsp";
                }
            }
        });
    });

    //下
    $(".page").find("button:last").click(function () {
        var page = $(".here").text();
        var name = $(".name").text();
        // console.log(page+"111"+name);
        Feny((Number(page)+1),name);
    })
    //下
    $(".page").find("button:first").click(function () {
        var page = $(".here").text();
        var name = $(".name").text();
        console.log(page+"111"+name);
        Feny((Number(page)-1),name);
    })
    //搜索
    $(".yonghu3").find("button").click(function(){
       $(".name").text($(".yonghu3").find("input").val());
       var name = $(".name").text();
       Feny(1,name)
    });
 //   var name=$(".page").find("button").text();//搜索字符串
//更改头像
    $("#gofile").on("click", function () {
        $("#upload").click();
    });
    $("#upload").on("change", function () {
        var formData = new FormData($("#uploadForm")[0]);  //创建一个forData
        formData.append('upload', $('#upload')[0].files[0]); //把file添加进去  name命名为img
        $.ajax({
            url:"account/upload",
            type:"post",
            data:formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            // mimeType:"multipart/form-data",
            success: function (data) {
                if(data.code==200){
                    alert("修改成功");
                    $(".yonghu1").find("img").prop("src",data.img);
                    // $(".yonghuhead").attr("src",data.img);
                }
            }
        });
    });
    //设置图书

    // 第一次执行
    pagi(1);

//用户下一页
    $("#nextpage").click(function () {
        $.ajax({
           url:"account/nextpage",
            type:"post",
            success:function (data) {
               if (data.code==200){
                   dynamic(data);//设置动态表格数据
                   $("#updown").text(data.accountpage);
               }
               else {
                   alert(data.message);
               }
            }
        });
    });
//设置用户上一页
    $("#previous").click(function () {
        $.ajax({
            url:"account/previous",
            type:"post",
            success:function (data) {
                if (data.code==200){
                    dynamic(data);//设置动态表格数据
                    $("#updown").text(data.accountpage);
                }
                else {
                    alert(data.message);
                }
            }
        });
    });
    // 添加图书
    $(".addbook").click(function () {
        var html1 = "";
        html1 += "<tr>";
        html1 +=     "<td width='20px'>id</td>";
        html1 +=     "<td width='120px'><input type='text'></td>";
        html1 +=     "<td width='120px'><input type='text'></td>";
        html1 +=     "<td width='120px'><input type='text'></td>";
        html1 +=     "<td width='100px'><input type='text'></td>";
        html1 +=     "<td width='120px'><input type='text'></td>";
        html1 +=     "<td width='120px'><input type='text'></td>";
        html1 +=     "<td width='120px'><input type='text'></td>";
        html1 +=     "<td width='120px'><input type='date'></td>";
        html1 +=     "<td width='120px'><input type='text'></td>";
        html1 +=     "<td width='120px'><button class='btn-danger'>取消</button><button class='btn-primary'>确认</button><td/>";
        html1 += "</tr>";
        $("#tfoot").html(html1);
        $(".addbook").attr("disabled","disabled");
        $("#tfoot").find("button:first").click(function () {
            $(this).parent().parent().remove();
            console.log("取消");
            $(".addbook").removeAttr("disabled");
        });
        $("#tfoot").find("button:eq(1)").click(function () {

            var that = this ;
            var parent = $(this).parent().parent();
            var book_isbn = parent.find("input:first").val();
            var book_name = parent.find("input:eq(1)").val();
            var author = parent.find("input:eq(2)").val();
            var book_type = parent.find("input:eq(3)").val();
            var book_press = parent.find("input:eq(4)").val();
            var book_price = parent.find("input:eq(5)").val();
            var book_img = parent.find("input:eq(6)").val();
            var book_date = parent.find("input:eq(7)").val();
            var book_content = parent.find("input:eq(8)").val();
            $.ajax({
                url:"book/Addbook",
                type:"post",
                contentType:"application/json;charset=utf-8",
                data:JSON.stringify({
                    "book_isbn":book_isbn,
                    "book_name":book_name,
                    "author":author,
                    "book_type":book_type,
                    "book_press":book_press,
                    "book_price":book_price,
                    "book_img":book_img,
                    "book_date":book_date,
                    "book_content":book_content
                }),
                success:function (data) {
                    if(data.code==200){
                        alert(data.message);
                        $(".addbook").removeAttr("disabled");
                        parent.find("td:eq(1)").text(book_isbn);
                        parent.find("td:eq(2)").text(book_name);
                        parent.find("td:eq(3)").text(author);
                        parent.find("td:eq(4)").text(book_type);
                        parent.find("td:eq(5)").text(book_press);
                        parent.find("td:eq(6)").text(book_price);
                        parent.find("td:eq(7)").text(book_img);
                        parent.find("td:eq(8)").text(book_date);
                        parent.find("td:eq(9)").text(book_content);
                        $(that).text("修改");
                        var empty = "";
                        $("#tfoot").html(empty);

                        Feny(1,"");
                        pagi(1);
                    }else {
                        alert(data.message);
                    }
                }
            });
        })

    })
});
