<!DOCTYPE HTML>
<%@page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  <meta charset="utf-8">
  <title>管理员主页</title>
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
<script>
  function show(tid) {
      document.getElementById("extra").style.display = "none";
    document.getElementById("user").style.display = "none";
    document.getElementById("good").style.display = "none";
    document.getElementById("category").style.display = "none";
    document.getElementById("bill").style.display = "none";
    document.getElementById("my").style.display = "none";
    document.getElementById(tid).style.display="block";
  }

  function shipped(bid) {
      var ajax = new XMLHttpRequest();

      ajax.onreadystatechange = function () {
          if(ajax.readyState==4){
              if(ajax.status==200){
                  var res = ajax.responseText;
                  alert(res);
              }else
                  alert("WRONG！");
          }
      }

      ajax.open("get","bill?method=Delivery&bid="+bid);
      ajax.send(null);
  }

  function addCategory() {
      document.getElementById("category").style.display = "none";
      var table = document.getElementById("extra");
      table.style.display = "block";
      table.innerHTML = "";
      var tr = table.insertRow(0);
      tr.insertCell(0).innerHTML = "新商品分类：";
      tr.insertCell(1).innerHTML = "<input type='text' id='new_type'/>";
      tr.insertCell(2).innerHTML = "<button style = 'width: 100px;margin: 0 auto;' onclick = 'ajaxCategory()'>新增</button>"

  }
  function ajaxCategory() {
      var ajax = new XMLHttpRequest();

      var type = document.getElementById("new_type").value;
      ajax.onreadystatechange = function () {
          if(ajax.readyState==4){
              if(ajax.status==200){
                  var res = ajax.responseText;
                  alert(res);

              }
          }
      }

      ajax.open("get","category?method=addType&type="+type);
      ajax.send(null)
  }

  function addGood() {
    document.getElementById("good").style.display = "none";
    var table = document.getElementById("extra");
    table.style.display = "block";
    table.innerHTML = "";
    var tr = table.insertRow(0);
    tr.insertCell(0).innerHTML = "新商品名称：";
    tr.insertCell(1).innerHTML = "<input type='text' id='new_name'/>";
    var tr = table.insertRow(1);
    tr.insertCell(0).innerHTML = "价格：";
    tr.insertCell(1).innerHTML = "<input type='number' id='new_price'/>";
    var tr = table.insertRow(2);
    tr.insertCell(0).innerHTML = "描述：";
    tr.insertCell(1).innerHTML = "<input type='text' id='new_des'/>";
    var tr = table.insertRow(3);
    tr.insertCell(0).innerHTML = "库存：";
    tr.insertCell(1).innerHTML = "<input type='number' id='new_reserve'/>";
    var tr = table.insertRow(4);
    tr.insertCell(0).innerHTML = "类型：";
    tr.insertCell(1).innerHTML = "<input type='number' id='new_type'/>";
    tr.insertCell(2).innerHTML = "<button style = 'width: 100px;margin: 0 auto;' onclick = 'ajaxGood()'>新增</button>"

  }
  function ajaxGood() {
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function (ev) {
      if(ajax.readyState == 4 ){
        if(ajax.status == 200){
          var res = ajax.responseText;
          alert(res);
        }
      }
    }
    ajax.open("get","good?method=addGood");
    ajax.send(null);
  }

</script>
  </head>
  <body>
  <header>
    <div id="top">
      <div class="container_12">
        <div class="grid_9">
          <nav>
            <ul>
              <li><a href="${pageContext.request.contextPath}/user?method=Logout">退出</a></li>
            </ul>
          </nav>
        </div>
        <!-- .grid_9 -->
      </div>
    </div>
    <!-- #top -->
    <div class="">
      <div class="grid_3" style="margin-left: 45%" >
        <hgroup>
          <h1 id="site_logo"><a href="index.jsp" title=""><img src="img/logo.png" alt="Online Store Theme Logo"></a></h1>
          <h2 id="site_description">线上商店</h2>
        </hgroup>
      </div>
      <!-- .grid_3 -->
    </div>
  </header>

<section id="main">
  <div class="container_12" style="height: 50px">
    <h1 style="margin-left: 45%">管理员主页</h1>
  </div>
  <div class="clear"></div>

  <div class="container_12" style="margin:0 auto;">
    <!--功能列表-->
    <div id="sidebar" class="grid_3" style="float: left">
      <header class="aside_title">
        <h3 style="font-size: 20px; color: #222222">功能</h3>
      </header>
      <nav class="right_menu">
        <ul>
            <button style="width: 150px" onclick="show('my')">我的账号</button>
            <button style="width: 150px" onclick="show('user')">会员管理</button>
            <button style="width: 150px" onclick="show('good')">商品管理</button>
            <button style="width: 150px" onclick="show('category')">商品类型管理</button>
            <button style="width: 150px" onclick="show('bill')">账单管理</button>
        </ul>
      </nav><!-- .right_menu -->
    </div><!-- .sidebar -->

    <!--细则-->
    <div id="content" class="grid_9" >
      <div class="products catalog">
        <table id = "my" style="display: none">
          <tr>
            <th width="189px">我的ID</th>
            <th width="189px">我的姓名</th>
            <th width="189px">我的密码</th>
            <th width="189px">管理</th>
          </tr>
          <tr>
            <td>${sessionScope.user.id}</td>
            <td>${sessionScope.user.name}</td>
            <td>${sessionScope.user.pwd}</td>
            <td><button style="margin:0 auto;width:100px;" onclick=""></button></td>
          </tr>

        </table>
        <table id = "user" style="width: 756px;display: none">
          <tr>
            <th width="151px">用户ID</th>
            <th width="151px">用户姓名</th>
            <th width="151px">用户余额</th>
            <th width="151px">用户密码</th>
            <th width="151px">管理</th>
          </tr>
          <c:forEach var="obj" items="${requestScope.UserList}">
            <tr>
              <td>${obj.id}</td>
              <td>${obj.name}</td>
              <td>${obj.money}</td>
              <td>${obj.pwd}</td>
              <td><button style="margin:0 auto;width:100px;"></button></td>
            </tr>
          </c:forEach>
        </table>
        <table id = "good" style="width: 756px;display: none">
          <tr>
            <th colspan="8"><button style="margin-left: 40%;width: 200px" onclick="addGood()">新增商品</button> </th>
          </tr>
          <tr>
            <th width="10%">商品ID</th>
            <th width="15%">图片</th>
            <th width="10%">商品名称</th>
            <th width="35%">商品描述</th>
            <th width="10%">价格</th>
            <th width="10%">库存</th>
            <th width="15%" >管理</th>
          </tr>
          <c:forEach var="obj" items="${requestScope.GoodList}">
            <tr>
              <td>${obj.id}</td>
              <td><img width="50" height="50" src="${pageContext.request.contextPath}/img/content/${obj.image}"></td>
              <td>${obj.name}</td>
              <td>${obj.description}</td>
              <td>${obj.price}</td>
              <td>${obj.reserve}</td>
              <td><button style="margin:0 auto;width:100px;" onclick="">修改</button></td>
            </tr>
          </c:forEach>
        </table>
        <table id = "bill" style="width: 756px;display: none">
          <c:forEach var="obj" items="${requestScope.BillList}">
            <tr>
              <th colspan="1">订单ID:${obj.id}</th>
              <th colspan="2">时间：${obj.time}</th>
              <th colspan="2">状态：${obj.status==1?"未发货":"已完成"}</th>
            </tr>
            <tr>
              <th width="200px">图片</th>
              <th width="200px">商品</th>
              <th width="200px">价格</th>
              <th width="200px">数量</th>
              <th width="200px">小计</th>
            </tr>
            <c:forEach var="item" items="${obj.items}">
              <tr>
                <td><img src="${pageContext.request.contextPath}/img/content/${item.good.image}" width="50px" height="50px"></td>
                <td>${item.good.name}</td>
                <td>${item.good.price}</td>
                <td>${item.amount}</td>
                <td>${item.price}</td>
              </tr>
            </c:forEach>
            <c:if test="${obj.status==1}">
              <tr>
                <th colspan="5"><button style="width: 200px;margin-left: 40%" onclick="shipped(${obj.id})">发货</button></th>
              </tr>
            </c:if>
            <tr>
              <th colspan="5"></th>
            </tr>
          </c:forEach>
        </table>
        <table id = "category" style="width: 756px;display: none" >
          <tr>
            <th colspan="4"><button style="width:200px;margin-left: 40%;" onclick="addCategory()">新增分类</button></th>
          </tr>
          <tr>
            <th width="250px">商品分类ID</th>
            <th width="250px">名称</th>
            <th width="250px" colspan="2">管理</th>
          </tr>
          <c:forEach var="obj" items="${requestScope.CategoryList}">
            <tr>
              <td>${obj.id}</td>
              <td>${obj.name}</td>
              <td><button style="margin:0 auto;width:100px;" onclick="window.location.href='${pageContext.request.contextPath}/category?method=delType&cid=${obj.id}'">删除</button></td>
              <td><button style="margin:0 auto;width:100px;" onclick="">修改</button></td>
            </tr>
          </c:forEach>
        </table>
          <table id="extra"></table>
      </div>
    </div>

    <div class="clear"></div>
  </div>

</section>
  <footer>
    <jsp:include page="footer.jsp"></jsp:include>
  </footer>
  </body>
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<!-- /Added by HTTrack -->
</html>
