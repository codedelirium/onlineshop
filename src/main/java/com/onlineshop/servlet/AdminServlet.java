package com.onlineshop.servlet;

import com.onlineshop.pojo.Bill;
import com.onlineshop.service.IBillService;
import com.onlineshop.service.ICategoryService;
import com.onlineshop.service.IGoodService;
import com.onlineshop.service.IUserService;
import com.onlineshop.service.impl.BillServiceImpl;
import com.onlineshop.service.impl.CategoryServiceImpl;
import com.onlineshop.service.impl.GoodServiceImpl;
import com.onlineshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ///编码格式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        IUserService us = new UserServiceImpl();
        IBillService bs = new BillServiceImpl();
        ICategoryService cs = new CategoryServiceImpl();
        IGoodService gs = new GoodServiceImpl();

        List<Bill> bills =  bs.getAllBills();
        if(bills!= null){
            for (Bill b:bills)
                b.setItems(bs.getItemsByBid(b.getId()));
        }
        req.setAttribute("UserList",us.getAllUsers());
        req.setAttribute("BillList",bills);
        req.setAttribute("GoodList",gs.getAllGoods());
        req.setAttribute("CategoryList",cs.getAllCgs());
        req.getRequestDispatcher("/adminpage.jsp").forward(req,resp);

    }
}
