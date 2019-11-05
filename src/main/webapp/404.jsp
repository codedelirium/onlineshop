<%--
  Created by IntelliJ IDEA.
  User: kober
  Date: 2019/9/28
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">

    <title>404 not found</title>
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


<section id="main" class="page-404">
    <div class="container_12">
        <div id="content">
            <div class="grid_4 left_404">
                <h1 class="text_404">404</h1>
                <h6>Page not found...</h6>
                <img src="img/smille.png" alt=":)" title="">
            </div><!-- .left_404 -->

            <div class="grid_8">
                <h2>Whoops, our bad...</h2>
                <p>he page you requested was not found, and we have a fine guess why.</p>
                <ul>
                    <li>If you typed the URL directly, please make sure the spelling is correct.</li>
                    <li>If you clicked on a link to get here, the link is outdated.</li>
                </ul>
                <p>What can you do?<br>
                    Have no fear, help is near! There are many ways you can get back on track with Magento Store.</p>
                <ul>
                    <li><a href="#">Go back</a> to the previous page.</li>
                    <li>Use the search bar at the top of the page to search for your products.<br>
                        Follow these links to get you back on track!</li>
                    <li><a href="#">Store Home</a> | <a href="#">My Account</a></li>
                </ul>
            </div><!-- .grid_8 -->

            <div class="clear"></div>
        </div><!-- #content -->

        <div class="clear"></div>
    </div><!-- .container_12 -->
</section><!-- #main -->
<div class="clear"></div>

<footer>
    <div class="footer_navigation">
        <div class="container_12">
            <div class="grid_3">
                <h3>Contact Us</h3>
                <ul class="f_contact">
                    <li>49 Archdale, 2B Charlestone</li>
                    <li>+777 (100) 1234</li>
                    <li>mail@example.com</li>
                </ul><!-- .f_contact -->
            </div><!-- .grid_3 -->

            <div class="grid_3">
                <h3>Information</h3>
                <nav class="f_menu">
                    <ul>
                        <li><a href="#">About As</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms & Conditions</a></li>
                        <li><a href="#">Secure payment</a></li>
                    </ul>
                </nav><!-- .private -->
            </div><!-- .grid_3 -->

            <div class="grid_3">
                <h3>Costumer Servise</h3>
                <nav class="f_menu">
                    <ul>
                        <li><a href="#">Contact As</a></li>
                        <li><a href="#">Return</a></li>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Site Map</a></li>
                    </ul>
                </nav><!-- .private -->
            </div><!-- .grid_3 -->

            <div class="grid_3">
                <h3>My Account</h3>
                <nav class="f_menu">
                    <ul>
                        <li><a href="#">My Account</a></li>
                        <li><a href="#">Order History</a></li>
                        <li><a href="#">Wish List</a></li>
                        <li><a href="#">Newsletter</a></li>
                    </ul>
                </nav><!-- .private -->
            </div><!-- .grid_3 -->

            <div class="grid_12 newsletter-payments">
                <div class="newsletter">
                    <div class="icon-mail">Newsletter</div>
                    <p>Subscribe to notifications about discounts from our store</p>
                    <form>
                        <input type="submit" value="">
                        <input type="email" name="newsletter" value="" placeholder="Enter your email address...">
                    </form>
                </div><!-- .newsletter -->

                <div class="payments">
                    <img src="img/payments.png" alt="Payments">
                </div><!-- .payments -->
            </div><!-- .grid_12.newsletter-payments -->

            <div class="clear"></div>
        </div><!-- .container_12 -->
    </div><!-- .footer_navigation -->

    <div class="footer_info">
        <div class="container_12">
            <div class="grid_6">
                <p class="copyright">© Diamond Store Theme, 2013.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
            </div><!-- .grid_6 -->

            <div class="grid_6">
                <div class="soc">
                    <a class="google" href="#"></a>
                    <a class="twitter" href="#"></a>
                    <a class="facebook" href="#"></a>
                </div><!-- .soc -->
            </div><!-- .grid_6 -->

            <div class="clear"></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
