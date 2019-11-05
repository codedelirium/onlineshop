package com.onlineshop.servlet;

import com.onlineshop.pojo.User;
import com.onlineshop.service.IUserService;
import com.onlineshop.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "UserServlet" ,urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private IUserService userService = new UserServiceImpl();

    //用户登陆
    public void Login(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        //获取用户请求
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        boolean remember = false;
        if(req.getParameter("Remember_password") != null)
            remember = true;

        //处理请求
        User user = userService.login(Integer.parseInt(id) ,pwd);
        if(user!=null){
            //搞cookie
            if(remember){
                Cookie cookie = new Cookie("user_id",user.getId()+"");
                cookie.setMaxAge(3*24*3600);//三天
                resp.addCookie(cookie);
            }
            //搞session
            HttpSession hs = req.getSession();
            hs.setAttribute("user",user);

            //响应结果
            if(user.getType()==0)//普通用户
                resp.sendRedirect("/onlineshop/index.jsp");
            else{
                req.getRequestDispatcher("/admin").forward(req,resp);
            }
            return;
        }else {
            //响应结果
            req.setAttribute("message","ID或密码错误!");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }


    }

    //用户登出
    public void Logout(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //销毁session
        req.getSession().invalidate();
        Cookie[] cookies =req.getCookies();
        for (Cookie c:cookies) {
            c.setMaxAge(0);//销毁cookie
            resp.addCookie(c);//放回浏览器
        }
        //重定向
        resp.sendRedirect("/onlineshop/index.jsp");
    }

    //用户注册
    public void Register(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求数据
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        //处理响应数据
        if(userService.register(Integer.parseInt(id),name,pwd)){
            //响应请求
            req.setAttribute("message","注册成功！请登录！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }else {
            req.setAttribute("message","该ID已存在，注册失败！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }


    }

    //修改密码
    public void altInfo(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String new_pwd = req.getParameter("new_pwd");
        User u = (User)req.getSession().getAttribute("user");
        //处理请求
        if(userService.altUser(u.getId(),new_pwd)){
            resp.getWriter().write("IT WORKED");
        }
        else
            resp.getWriter().write("FAILED");

    }



}
