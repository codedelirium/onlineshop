<%--
  Created by IntelliJ IDEA.
  User: kober
  Date: 2019/9/27
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">

    <title>商品详情</title>
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

<script type="text/javascript">
    function addToCart(gid) {
        var ajax = new XMLHttpRequest();
        var s = document.getElementById("select");
        var index = s.selectedIndex;
        option = s[index].value;
        ajax.onreadystatechange = function(){

            if(ajax.readyState == 4){
                if(ajax.status == 200){
                    var res = ajax.responseText;
                    alert(res);
                }
            }

        }
        ajax.open("get","cart?method=addToCart&gid="+gid+"&amount="+option);
        ajax.send(null);
        <%--location.href ="${pageContext.request.contextPath}/cart?method=addToCart&gid="+gid+"&amount="+option;--%>
    }
</script>
</head>
<body>
<%--<c:out value="${option}"></c:out>--%>
<header>
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="navBar.jsp"></jsp:include>
</header>
<div class="container_12">
    <header>
        <h1 class="page_title">商品详情</h1>
    </header>
    <article class="product_page" style="height: 425px">
        <div class="grid_5 img_slid" id="products">
            <img class="sale" src="${pageContext.request.contextPath}/img/sale.png" alt="Sale">
            <div class="preview slides_container">
                <div class="prev_bg">
                    <a href="${pageContext.request.contextPath}/img/content/${requestScope.good.image}" class="jqzoom" rel='gal1' title="">
                        <img src="${pageContext.request.contextPath}/img/content/${requestScope.good.image}" alt="${requestScope.good.name}">
                    </a>
                </div>
            </div><!-- .preview -->

            <div id="pagination"></div>
        </div><!-- .grid_5 -->

        <div class="grid_7" style="height: 421.5px">
            <div class="entry_content">

                <div class="review">
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                </div>
                <p>${requestScope.good.description}</p>
                <div class="ava_price">
                    <div class="price">
                        <font style="font-size: 30px;color: chocolate" >售价：</font>${requestScope.good.price}
                    </div><!-- .price -->
                    <div class="clear"></div>
                </div><!-- .ava_price -->

                <div class="parameter_selection">
                    <font style="font-size: 30px;color:chocolate;">选择数量：</font>
                    <select id="select">
                        <c:forEach var="amount" begin="1" end="${requestScope.good.reserve}">
                            <option value="${amount}">${amount}</option>
                        </c:forEach>
                    </select>
                </div><!-- .parameter_selection -->
                <div class="cart">
                    <a onclick="addToCart(${good.id})" class="bay">
                        <img src="${pageContext.request.contextPath}/img/bg_cart.png" alt="买它！">加入购物车</a>
                </div><!-- .cart -->

            </div><!-- .entry_content -->
        </div><!-- .grid_7 -->
        <div class="clear"></div>

    </article><!-- .product_page -->
</div>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>
