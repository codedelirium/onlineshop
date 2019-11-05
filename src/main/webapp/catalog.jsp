<%--
  Created by IntelliJ IDEA.
  User: kober
  Date: 2019/9/21
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">

    <title>在售商品</title>
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
            ajax.onreadystatechange = function(){
                if(ajax.readyState == 4){
                    if(ajax.status == 200){
                        var res = ajax.responseText;
                        alert(res);
                    }
                }
            }
            ajax.open("get","cart?method=addToCart&gid="+gid+"&amount=1");
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
        <div class="container_12" style=" margin: 0 auto;">
            <h1 class="page_title">所有商品</h1>

            <!--分类列表-->
            <div id="sidebar" class="grid_3" style="float: left">
                <aside id="categories_nav">
                    <header class="aside_title">
                        <h3 style="font-size: 20px; color: #222222">商品目录</h3>
                    </header>
                    <nav class="right_menu">
                        <ul>
                            <c:forEach var="type" items="${sessionScope.Categories}">
                                <li ><a href="${pageContext.request.contextPath}/good?method=findGoodByType&tid=${type.id}" style="font-size: 16px;">${type.name}</a> </li>
                            </c:forEach>
                        </ul>
                    </nav><!-- .right_menu -->
                </aside><!-- #categories_nav -->
            </div><!-- .sidebar -->

            <!--商品列表-->
            <div id="content" class="grid_9" >
                <div class="products catalog">
                    <c:forEach var="good" items="${requestScope.GoodList}">
                        <article class="grid_3 article">
                            <div class="prev">
                                <a href="${pageContext.request.contextPath}/good?method=findGoodById&gid=${good.id}">
                                    <img src="img/content/${good.image}"
                                         width="170" height="170" style="display: inline-block;">
                                </a>
                            </div>
                            <h3 class="title">
                                <a href="${pageContext.request.contextPath}/good?method=findGoodById&gid=${good.id}" style='color: green'>${good.name}</a>
                            </h3>
                            <div class="cart">
                                <div class="price">
                                    &yen;${good.price}
                                </div>
                                <c:if test="${!empty sessionScope.user}">
                                    <a onclick="addToCart(${good.id})"  class="bay"><img src="img/bg_cart.png" alt="Buy" title=""></a>
                                </c:if>
                                <c:if test="${empty sessionScope.user}">
                                    <a href="login.jsp" class="bay"><img src="img/bg_cart.png" alt="Buy" title=""></a>
                                </c:if>
                            </div>
                        </article>
                    </c:forEach>
                </div>
            </div>

            <div class="clear"></div>
        </div>
    </section>


    <!--分页 -->
<%--    <div style="width: 380px; margin: 0 auto; margin-top: 50px;">--%>
<%--        <ul class="pagination" style="text-align: center; margin-top: 10px;">--%>

<%--            <c:if test="${currentPage eq 1 }">--%>
<%--                <li class="disabled"><a href="#" aria-label="Previous"><span--%>
<%--                        aria-hidden="true">&laquo;</span></a></li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${currentPage ne 1 }">--%>
<%--                <li ><a href="${pageContext.request.contextPath }/product?method=findProductByCategory&cid=${cid }&currentPage=${currentPage-1}" aria-label="Previous"><span--%>
<%--                        aria-hidden="true">&laquo;</span></a></li>--%>
<%--            </c:if>--%>

<%--            <c:forEach var="p"  begin="1" end="${totalPage }">--%>

<%--                <c:if test="${p eq currentPage }">--%>
<%--                    <li class="active"><a href="javascript:void(0);">${p}</a></li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${p ne currentPage }">--%>
<%--                    <li><a href="${pageContext.request.contextPath }/product?method=findProductByCategory&cid=${cid }&currentPage=${p}">${p }</a></li>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>

<%--            <c:if test="${currentPage eq totalPage }">--%>
<%--                <li class="disabled"><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>--%>
<%--                </a></li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${currentPage ne totalPage }">--%>
<%--                <li><a href="${pageContext.request.contextPath }/product?method=findProductByCategory&cid=${cid }&currentPage=${currentPage+1}"  aria-label="Next"> <span aria-hidden="true">&raquo;</span>--%>
<%--                </a></li>--%>
<%--            </c:if>--%>
<%--        </ul>--%>
<%--    </div>--%>
    <!-- 分页结束 -->
<div class="clear"></div>
    <footer>
        <jsp:include page="footer.jsp"></jsp:include>
    </footer>
</body>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>
