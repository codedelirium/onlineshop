<!DOCTYPE HTML>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
    <meta charset="utf-8">

    <title>Home</title>
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

<div id="slider_body">
    <ul id="slider">
        <li>
            <div class="slid_content">
                <h2 style="color:#6f566f;">订婚戒指</h2>
                <p style="color:#6f566f;">经历万难 你已找到今生挚爱。<br>
                    现在是时候寻找那颗最完美的钻石<br>
                    定下永恒的约定.</p>
                <a class="buy_now" href="#">查看详情</a>
            </div><!-- .slid_content -->
            <img src="img/content/slid-1.png" alt="Slid 1" title="">
        </li>

        <li>
            <div class="slid_content">
                <h2 style="color:#744747;">宝石项链</h2>
                <p style="color:#744747;">还有什么比宝石项链.</p>
                <a class="buy_now" href="#">查看详情</a>
            </div><!-- .slid_content -->
            <img src="img/content/slid-2.png" alt="Slid 2" title="">
        </li>

        <li>
            <div class="slid_content">
                <h2 style="color:#6d5956;">精美饰品</h2>
                <p style="color:#6d5956;">我们当然还有更多精品手作饰品</p>
                <a class="buy_now" href="#">查看详情</a>
            </div><!-- .slid_content -->
            <img src="img/content/slid-3.png" alt="Slid 3" title="">
        </li>
    </ul>
</div><!-- #slider_body -->

<section id="main" class="home">
    <div class="container_12">

        <div class="clear"></div>

        <div id="content_bottom">
            <div class="grid_6">
                <div class="bottom_block about_as">
                    <h3>About Us</h3>
                    <p>Lorem ipsum, libero et luctus molestie, turpis mi sagittis nisl, a scelerisque leo nulla et lectus pendisse dictum posuere elit, in congue nisl varius lentesque a tellus eget quam varius aliquet.</p>
                    <p>Pellentesque tristique, libero et luctus molestie, turpis a scelerisque leo nulla et lectus pendisse dictum posuere elit. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
                    <p>In congue nisl varius quis lentesque a tellus eget quam varius aliquet. Vel lobortis gravida.  Many desktop publishing packages and web page .</p>
                </div><!-- .about_as -->
            </div><!-- .grid_6 -->

            <div class="grid_6">
                <div class="bottom_block news">
                    <h3>News</h3>
                    <ul>
                        <li>
                            <time datetime="2012-03-03">3 january 2012</time>
                            <a href="#">Fermentum parturient lacus tristique habitant nullam morbi et odio nibh mus dictum tellus erat.</a>
                        </li>

                        <li>
                            <time datetime="2012-02-03">2 january 2012</time>
                            <a href="#">Cras ac hendrerit dui. Duis lacus ligula, luctus ac tristique eget, posuere id erat. Many desktop publishing packages and web page editors now use.</a>
                        </li>

                        <li>
                            <time datetime="2012-01-03">1 january 2012</time>
                            <a href="#">Lorem ipsum, libero et luctus molestie, turpis mi sagittis nisl, a scelerisque leo nulla et lectus.</a>
                        </li>
                    </ul>
                </div><!-- .news -->
            </div><!-- .grid_6 -->
            <div class="clear"></div>
        </div><!-- #content_bottom -->
    </div><!-- .container_12 -->
</section><!-- #main.home -->

<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>
