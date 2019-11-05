package com.onlineshop.servlet;

import com.onlineshop.pojo.Good;
import com.onlineshop.service.IGoodService;
import com.onlineshop.service.impl.GoodServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodServlet",urlPatterns = "/good")
public class GoodServlet extends BaseServlet {
    private IGoodService goodService = new GoodServiceImpl();

    //查找所有的产品
    public void findAllgoods(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //////
        List<Good> goods = goodService.getAllGoods();
        req.setAttribute("GoodList",goods);
        req.getRequestDispatcher("/catalog.jsp").forward(req,resp);

    }

    //按照类型查找产品
    public void findGoodByType(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //////
        String type = req.getParameter("tid");
        List<Good> goods = goodService.getGoodsByType(Integer.parseInt(type));
        if(goods != null){
            req.setAttribute("GoodList",goods);
            req.getRequestDispatcher("/catalog.jsp").forward(req,resp);
        }else
            resp.sendRedirect("/onlineshop/404.jsp");


    }

    //查找产品
    public void findGoodById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //////
        String id = req.getParameter("gid");
        Good good = goodService.getGoodById(Integer.parseInt(id));
        if(good != null){
            req.setAttribute("good",good);
            req.getRequestDispatcher("/good.jsp").forward(req,resp);
        }else
            resp.sendRedirect("/onlineshop/404.jsp");


    }

    //添加产品
    public void addGood(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String name = req.getParameter("new_name");
        String des = req.getParameter("new_des");
        String price = req.getParameter("new_price");
        String type = req.getParameter("new_type");
        String reserve = req.getParameter("new_reserve");

        Good g = new Good();
        g.setName(name);
        g.setType(Integer.parseInt(type));
        g.setReserve(Integer.parseInt(reserve));
        g.setPrice(Integer.parseInt(price));
        g.setDescription(des);
        if(goodService.addGood(g))
            resp.getWriter().write("IT WORKED");
        else
            resp.getWriter().write("WRONG");

    }
    //删除产品
    public void delGood(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        resp.sendRedirect("/onlineshop/404.jsp");
    }
    //修改产品
    public void altGood(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        resp.sendRedirect("/onlineshop/404.jsp");
    }
}
