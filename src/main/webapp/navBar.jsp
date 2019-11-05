<%--
  Created by IntelliJ IDEA.
  User: kober
  Date: 2019/9/24
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
    <div class="container_12">
        <div class="grid_3">
            <hgroup>
                <h1 id="site_logo"><a href="index.jsp" title=""><img src="img/logo.png" alt="Online Store Theme Logo"></a></h1>
                <h2 id="site_description">线上商店</h2>
            </hgroup>
        </div><!-- .grid_3 -->

        <div class="grid_9">
            <nav class="primary">
                <ul>
                    <li class="curent"><a href="index.jsp">主页</a></li>
                    <li><a href="${pageContext.request.contextPath}/category?method=findAllTypes">在售商品</a> </li>
                </ul>
            </nav><!-- .primary -->
        </div><!-- .grid_9 -->
    </div>
