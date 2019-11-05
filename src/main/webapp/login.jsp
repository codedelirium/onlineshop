<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
    <meta charset="utf-8">

    <title>登陆/注册</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="shortcut icon" href="/favicon.ico">

    <link rel="stylesheet" type="text/css" href="css/grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">

    <script src="js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.8.3.min.js"><\/script>')</script>
    <script src="est.contextPath}/js/html5.js"></script>
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
    <section id="main" class="page-login">
        <div class="container_12">
            <div id="content" class="grid_12">
                <header>
                    <h1 class="page_title">登陆或注册</h1>
                </header>
                    
                <article>
                    <div class="grid_6 new_customers">
                        <form class="regist" method="post" action="${pageContext.request.contextPath}/user?method=Register" >
                            <h2>注册</h2>
                            <p>如果您还没有本网站的账号，请注册。</p>
                            <div class="account">
                            <strong>账号：</strong><sup>*</sup><br>
                            <input type="id" name = "id" value="">
                            </div>
                            <div class="name">
                            <strong>姓名：</strong><sup>*</sup><br>
                            <input type="name" name = "name" value="">
                            </div>
                            <div class="password">
                            <strong>密码：</strong><sup>*</sup><br>
                            <input type="pwd" name = "pwd">
                            </div>
                            <div class="submit">
                            <input type="submit" value="注册会员">
                                <font style="color: red;font-size: 16px">${message}</font>
                            </div>
                        </form>
			
                    </div>
                  <!-- .grid_6 -->
		
                    <div class="grid_6 registed_form">
                        <form class="registed" method="post" action="${pageContext.request.contextPath}/user?method=Login" >
                            <h2>登陆</h2>
                            <p>如果您已经拥有一个账号，请登录。</p>
                            <div class="your_email">
                            <strong>账号:</strong><sup>*</sup><br>
                            <input type="text" name ="id">
                            </div><!-- .email -->
                            <div class="password">
                            <strong>密码:</strong><sup>*</sup><br>
                            <input type="text" name="pwd" >
                            </div><!-- .password -->
                            <div class="remember">
                            <input class="niceCheck" type="checkbox" name="Remember_password">
                            <span class="rem">记住密码</span>
                            </div><!-- .remember -->
                            <div class="submit">
                                <input type="submit" value="登陆">
                                <c:if test="${!empty message}">
                                    <font style="color: red;font-size: 16px">${message}</font>
                                </c:if>
                            </div><!-- .submit -->
                        </form><!-- .registed -->
                    </div><!-- .grid_6 -->
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
