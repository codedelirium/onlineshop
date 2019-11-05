<%--
  Created by IntelliJ IDEA.
  User: kober
  Date: 2019/9/21
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>我的主页</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <script src="js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.8.3.min.js"><\/script>')</script>
    <script src="js/html5.js"></script>
    <script src="js/main.js"></script>
    <script src="js/radio.js"></script>
    <script src="js/checkbox.js"></script>
    <script src="js/selectBox.js"></script>
    <script src="js/jquery.carouFredSel-5.2.2-packed.js"></script>
    <script src="js/jquery.jqzoom-core.js"></script>
    <script src="js/jquery.transit.js"></script>
    <script src="js/jquery.easing.1.2.js"></script>
    <script src="js/jquery.anythingslider.js"></script>
    <script src="js/jquery.anythingslider.fx.js"></script>

<script type="text/javascript">

    function showBills(status) {
        var ajax = new XMLHttpRequest();

        ajax.onreadystatechange = function () {
            if(ajax.readyState==4){
                if(ajax.status==200){
                    window.location.reload();

                }
            }
        }
        ajax.open("get","bill?method=findByUid&status="+status);
        ajax.send(null);
    }
    //获取个人信息
    function getDate() {

        document.getElementById("bill").style.display = "none";
        var b = document.getElementById("bt");
        b.innerHTML = "";

        var table = document.getElementById("table");
        table.style.display = "block";
        table.innerHTML = "";
        table.innerHTML = "<tr><td width='201px'>账号</td><th width='201px'>姓名</th><th width='201px'>密码</th><th width='201px'>余额</th><th width='201px'>修改信息</th></tr>";
        var tr = table.insertRow(1);
        tr.insertCell(0).innerHTML = "${user.getId()}";
        tr.insertCell(1).innerHTML = "${user.getName()}";
        tr.insertCell(2).innerHTML = "${user.getPwd()}";
        tr.insertCell(3).innerHTML = "${user.getMoney()}";
        tr.insertCell(4).innerHTML = "<button style='margin:0 auto; width: 100px;' onclick='altDate()'>修改</botton>";
    }
    //修改个人信息
    function altDate() {

        var table = document.getElementById("table");
        table.innerHTML ="";
        var tr = table.insertRow(0);
        tr.insertCell(0).innerHTML = "原密码：";
        tr.insertCell(1).innerHTML = "${user.getPwd()}";
        var tr1 = table.insertRow(1);
        tr1.insertCell(0).innerHTML = "新密码：";
        // tr1.insertCell(1).id = "new_pwd";
        tr1.insertCell(1).innerHTML = "<input type='text' id='new_pwd'/>";

        var b = document.getElementById("bt");
        b.innerHTML = "";
        b.innerHTML = "<button style = 'width: 100px;margin: 0 auto;' onclick = 'ajax()'>提交</button>";

    }

    function ajax() {
        //创建ajax引擎对象
        var ajax = new XMLHttpRequest();
        //根据id获取form表单提交的内容。
        var val = document.getElementById("new_pwd").value;
        //判断ajax
        ajax.onreadystatechange = function () {
            if(ajax.readyState == 4){
                if(ajax.status == 200){
                    var res = ajax.responseText;
                    alert(res);
                }
            }
        }
        //get方法
        ajax.open("get","user?method=altInfo&&new_pwd="+val);
        ajax.send(null);
    }

    function pay(bid,total) {
        var ajax = new XMLHttpRequest();

        ajax.onreadystatechange = function () {
            if(ajax.readyState==4){
              if(ajax.status == 200){
                  var res = ajax.responseText;
                  alert(res);
              }else
                  alert("WRONG!");
            }
        }

        ajax.open("get","bill?method=pay&bid="+bid+"&total="+total);
        ajax.send(null);
    }

</script>
</head>
<body>
    <header>
        <jsp:include page="header.jsp"></jsp:include>

        <jsp:include page="navBar.jsp"></jsp:include>
    </header>
    <section id="main">
    <div class="container_12" style="height: 50px">
        <h1 >我的账号</h1>
    </div>
    <div class="clear"></div>
    <div class="container_12" style="height: 60px;border-bottom: 1px solid #bdd1e9;">
        <div style="height: 50px;width: 25%;float: left">
            <button style="width:200px;margin: 0 auto" onclick="getDate()">个人信息</button>
        </div>
        <div style="height: 50px;width:25%;float: left">
            <button  style="width:200px;margin: 0 auto" onclick="showBills('0')">未付款订单</button>
        </div>
        <div style="height: 50px;width:25%;float: left">
            <button style="width:200px;margin:0 auto" onclick="showBills('1')">未发货订单</button>
        </div>
        <div style="height: 50px;width:25%;float: left">
            <button style="width:200px;margin:0 auto" onclick="showBills('2')">已完成订单</button>
        </div>
    </div>
    <div class="clear"></div>
    <div class="container_12"  >
        <table border="1px" id ="table"></table>
        <div id = "bt"></div>
        <table border="1px" id="bill" >
            <!--未付款-->
            <c:forEach var="obj0" items="${sessionScope.Unpaid}">
                <tr>
                    <th colspan="5">订单ID:${obj0.id}</th>
                </tr>
                <tr>
                    <th width="108px">图片</th>
                    <th width="108px">商品</th>
                    <th width="108px">价格</th>
                    <th width="108px">数量</th>
                    <th width="108px">小计</th>
                </tr>
                <c:forEach var="item" items="${obj0.items}">
                    <tr>
                        <td><img src="${pageContext.request.contextPath}/img/content/${item.good.image}" width="50px" height="50px"></td>
                        <td>${item.good.name}</td>
                        <td>${item.good.price}</td>
                        <td>${item.amount}</td>
                        <td>${item.price}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="5"><button style="width: 200px;margin-left: 40%" onclick="pay(${obj0.id},${obj0.total})">付款</button></th>
                </tr>
            </c:forEach>
            <!--未发货-->
            <c:forEach var="obj1" items="${sessionScope.UnShipped}">
                <tr>
                    <th colspan="5">订单ID:${obj1.id}</th>
                </tr>
                <tr>
                    <th width="108px">图片</th>
                    <th width="108px">商品</th>
                    <th width="108px">价格</th>
                    <th width="108px">数量</th>
                    <th width="108px">小计</th>
                </tr>
                <c:forEach var="item" items="${obj1.items}">
                    <tr>
                        <td><img src="${pageContext.request.contextPath}/img/content/${item.good.image}" width="50px" height="50px"></td>
                        <td>${item.good.name}</td>
                        <td>${item.good.price}</td>
                        <td>${item.amount}</td>
                        <td>${item.price}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
            <!--已完成-->
            <c:forEach var="obj2" items="${sessionScope.Finished}">
                <tr>
                    <th colspan="5">订单ID:${obj2.id}</th>
                </tr>
                <tr>
                    <th width="108px">图片</th>
                    <th width="108px">商品</th>
                    <th width="108px">价格</th>
                    <th width="108px">数量</th>
                    <th width="108px">小计</th>
                </tr>
                <c:forEach var="item" items="${obj2.items}">
                    <tr>
                        <td><img src="${pageContext.request.contextPath}/img/content/${item.good.image}" width="50px" height="50px"></td>
                        <td>${item.good.name}</td>
                        <td>${item.good.price}</td>
                        <td>${item.amount}</td>
                        <td>${item.price}</td>
                </tr>
            </c:forEach>

            </c:forEach>
        </table>
    </div>
    <div class="clear"></div>
</section>


    <footer>
        <jsp:include page="footer.jsp"></jsp:include>
    </footer>
</body>

<!-- Added by HTTrack -->

<meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>