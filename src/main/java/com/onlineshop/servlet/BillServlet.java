package com.onlineshop.servlet;

import com.onlineshop.pojo.Bill;
import com.onlineshop.pojo.BillItem;
import com.onlineshop.pojo.Cart;
import com.onlineshop.pojo.User;
import com.onlineshop.service.IBillService;
import com.onlineshop.service.ICartService;
import com.onlineshop.service.IUserService;
import com.onlineshop.service.impl.BillServiceImpl;
import com.onlineshop.service.impl.CartServiceImpl;
import com.onlineshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BillServlet" ,urlPatterns = "/bill")
public class BillServlet extends BaseServlet {
    private IBillService billService = new BillServiceImpl();
    //用户查自己的订单
    public void findByUid(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求信息
        String status = req.getParameter("status");
        User u =(User) req.getSession().getAttribute("user");
        //处理请求信息
        List<Bill> bills = billService.getBillsByStatus(u.getId(),Integer.parseInt(status));

        if(bills!=null){
            for (Bill b:bills) {
                List<BillItem> items = billService.getItemsByBid(b.getId());
                b.setItems(items);
            }
            req.getSession().removeAttribute("Unpaid");
            req.getSession().removeAttribute("UnShipped");
            req.getSession().removeAttribute("Finished");
            if(status.equals("0"))
                req.getSession().setAttribute("Unpaid",bills);
            else if(status.equals("1"))
                req.getSession().setAttribute("UnShipped",bills);
            else if(status.equals("2"))
                req.getSession().setAttribute("Finished",bills);
            resp.getWriter().write("");
        }else {
            //响应
            resp.sendRedirect("/onlineshop/404.jsp");
        }

    }


    //添加订单
    public void addBill(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        User u = (User)req.getSession().getAttribute("user");
        ICartService cs = new CartServiceImpl();
        List<Cart> carts = cs.getCartsById(u.getId());
        if(carts!=null) {
            Bill bill = new Bill();
            bill.setStatus(0);
            bill.setUser_id(u.getId());
            bill.setTime(new java.sql.Date(new java.util.Date().getTime()));
            int total = 0;
            for (Cart c : carts) {
                total += c.getTotal();
            }
            bill.setTotal(total);

            ///
            int bid = billService.addBill(bill);
            if (bid != -1) {
                List<BillItem> billItems = new ArrayList<>();
                for (Cart c : carts) {
                    BillItem bi = new BillItem();
                    bi.setAmount(c.getAmount());
                    bi.setGood(c.getGood());
                    bi.setBid(bid);
                    bi.setPrice(c.getTotal());
                    billItems.add(bi);
                }
                billService.addItems(billItems);
                resp.sendRedirect("/onlineshop/cart?method=checkout");
            } else
                resp.sendRedirect("/onlineshop/404.jsp");
        }else
            resp.sendRedirect("/onlineshop/404.jsp");
    }



    //用户他妈的付钱（修改订单）
    public void pay(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String bid = req.getParameter("bid");
        String total = req.getParameter("total");
        ////
        User u = (User) req.getSession().getAttribute("user");
        if(u.getMoney() < Integer.parseInt(total))
            resp.getWriter().write("WRONG！");
        else {
            IUserService us = new UserServiceImpl();
            us.payBill(u.getId(),Integer.parseInt(total));
            String msg = billService.payBill(Integer.parseInt(bid));
            resp.getWriter().write(msg);
        }
    }

    //发货
    public void Delivery(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");


        String bid = req.getParameter("bid");

        String msg = billService.shippedBill(Integer.parseInt(bid));
        resp.getWriter().write(msg);

    }
}
