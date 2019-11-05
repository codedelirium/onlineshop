<%--
  Created by IntelliJ IDEA.
  User: kober
  Date: 2019/9/21
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">

    <title>我的购物车</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="shortcut icon" href="/favicon.ico">

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

</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>

    <jsp:include page="navBar.jsp"></jsp:include>
</header>

<section id="main">
    <div class="container_12">
        <div id="content" class="grid_12">
            <header>
                <h1 class="page_title">我的购物车</h1>
            </header>

            <article>
                <table class="cart_product">
                    <tr class="bg">
                        <th class="images"></th>
                        <th class="name">产品名称</th>
                        <th class="price">单价</th>
                        <th class="qty">数量</th>
                        <th class="subtotal">总价</th>
                        <th class="close">删除</th>
                    </tr>
                    <c:forEach var="cart" items="${requestScope.MyCart}">
                        <tr>
                            <td class="images"><a href="${pageContext.request.contextPath}/good?method=findGoodById&gid=${cart.good.id}">
                                <img src="img/content/${cart.good.image}" alt="${cart.good.name}" title=""></a></td>
                            <td class="name">${cart.good.name}</td>
                            <td class="price">${cart.price}</td>
                            <td class="qty">${cart.amount}</td>
                            <td class="subtotal">${cart.total}</td>
                            <td class="close"><a title="close" class="close" href="${pageContext.request.contextPath}/cart?method=delFromCart&cid=${cart.id}"></a></td>
                        </tr>
                    </c:forEach>
                </table>
                <c:if test="${!empty requestScope.MyCart}">
                    <div id="cart_forms">
                        <div class="grid_4"style="float: left">
                            <div class="bottom_block total">
                                <table class="subtotal">
                                    <tr class="grand_total">
                                        <td>总价：</td><td class="price">${requestScope.total}</td>
                                    </tr>
                                </table>
                                <button class="checkout" onclick="window.location.href='${pageContext.request.contextPath}/bill?method=addBill'">下订单<img src="img/checkout.png" alt="" title=""></button>
                            </div><!-- .total -->
                        </div><!-- .grid_4 -->
                    <div class="clear"></div>
                </div><!-- #cart_forms -->
                </c:if>
                <c:if test="${empty requestScope.MyCart}">
                    <div id="cart_forms">
                        <div class="grid_4" style="float: right">
                            <button style="width: 200px;background: chocolate" onclick="window.location.href='${pageContext.request.contextPath}/good?method=findAllgoods'">购物车里没有商品，去逛逛吧</button>
                        </div><!-- .grid_4 -->
                        <div class="clear"></div>
                    </div><!-- #cart_forms -->
                </c:if>
                <div class="clear"></div>
            </article>

            <div class="clear"></div>
        </div><!-- #content -->

        <div class="clear"></div>
    </div><!-- .container_12 -->
</section><!-- #main -->
<div class="clear"></div>

<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>

</body>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>