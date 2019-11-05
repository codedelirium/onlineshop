package com.onlineshop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 *
 *
 * */
//@WebServlet(urlPatterns = "/")
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        Class clazz=this.getClass();
        try {
            Method m=clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
            m.invoke(this, req,resp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
