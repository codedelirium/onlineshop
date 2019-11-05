<%--
  Created by IntelliJ IDEA.
  User: kober
  Date: 2019/9/24
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div id="top">
    <div class="container_12">
        <div class="grid_9">
            <nav>
                <ul>
                    <c:if test="${empty sessionScope.user}">
                        <li><a href="login.jsp">登陆/注册</a></li>
                    </c:if>
                    <c:if test="${!empty sessionScope.user}">
                        <li class="current"><a href="myaccount.jsp">我的账号</a></li>
                        <li><a href="${pageContext.request.contextPath}/cart?method=showMyCart">我的购物车</a></li>
                        <li><a href="${pageContext.request.contextPath}/user?method=Logout">退出</a></li>
                        <p style="color: chocolate">欢迎你,${sessionScope.user.getName()}</p>
                    </c:if>
                </ul>
            </nav>
        </div><!-- .grid_9 -->
    </div>
</div><!-- #top -->