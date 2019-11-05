package com.onlineshop.servlet;

import com.onlineshop.pojo.Category;
import com.onlineshop.service.ICategoryService;
import com.onlineshop.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet{
    ICategoryService categoryService = new CategoryServiceImpl();
    //查找所有商品类型
    public void findAllTypes(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        List<Category> categories = categoryService.getAllCgs();
        if(categories != null){
            req.getSession().setAttribute("Categories",categories);
            req.getRequestDispatcher("/good?method=findAllgoods").forward(req,resp);
        }else
            resp.sendRedirect("/onlineshop/404.jsp");
    }


    //查找指定类型商品
    public void findGoodByType(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        ///
        String type = req.getParameter("tid");
        ///
        if(type != null){
            req.setAttribute("type",type);
            req.getRequestDispatcher("/good?method=FineGoodByType").forward(req,resp);
        }else
            resp.sendRedirect("/onlineshop/404.jsp");
    }

    //修改商品类型名
    public void altType(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String name = req.getParameter("new_name");
            resp.getWriter().write("WRONG!");

    }

    //删除商品类型
    public void delType(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String cid = req.getParameter("cid");
        if(categoryService.delCateGory(Integer.parseInt(cid))){
            req.getRequestDispatcher("/admin").forward(req,resp);
        }else
            resp.sendRedirect("/onlineshop/404.jsp");
    }

    //添加商品类型
    public void addType(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String type = req.getParameter("type");
        Category c = new Category();
        c.setName(type);
        if(categoryService.addCategory(c))
            resp.getWriter().write("IT WORKED!");
        else
            resp.getWriter().write("WRONG!");
    }

}
