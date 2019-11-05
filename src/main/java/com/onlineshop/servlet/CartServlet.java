package com.onlineshop.servlet;

import com.onlineshop.pojo.Cart;
import com.onlineshop.pojo.Good;
import com.onlineshop.pojo.User;
import com.onlineshop.service.ICartService;
import com.onlineshop.service.IGoodService;
import com.onlineshop.service.impl.CartServiceImpl;
import com.onlineshop.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet" ,urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private static ICartService cartService = new CartServiceImpl();

    //加入购物车
    public void addToCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        ///
        String gid = req.getParameter("gid");
        String amount = req.getParameter("amount");
        ///
        User u = (User) req.getSession().getAttribute("user");
        if (u == null) {
            resp.sendRedirect("/onlineshop/login.jsp");
            return;
        }
        IGoodService gs = new GoodServiceImpl();
        Good g = gs.getGoodById(Integer.parseInt(gid));
        Cart cart = new Cart();
        cart.setGood(g);
        cart.setUser_id(u.getId());
        cart.setAmount(Integer.parseInt(amount));
        cart.setPrice(g.getPrice());
        cart.setTotal(Integer.parseInt(amount) * g.getPrice());

        if (cartService.addCart(cart)) {
            resp.getWriter().write("IT WORKED!");
        }else{
            resp.getWriter().write("FAILED!");
        }


    }

    //查看我的购物车
    public void showMyCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ///
        User u = (User) req.getSession().getAttribute("user");
        ///
        List<Cart> carts = cartService.getCartsById(u.getId());
        if(carts!=null){
            int total = 0;
            for (Cart cart : carts)
                total += cart.getTotal();
            req.setAttribute("MyCart", carts);
            req.setAttribute("total", total);
        }
        req.getRequestDispatcher("/mycart.jsp").forward(req, resp);
    }

    //从购物车中删除
    public void delFromCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ///
        String cid = req.getParameter("cid");
        ///
        if(cartService.delCart(Integer.parseInt(cid))){
            showMyCart(req,resp);
        }else{
            resp.sendRedirect("/onlineshop/404.jsp");
        }


    }

    //结算购物车
    public void checkout(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        User u = (User) req.getSession().getAttribute("user");
        ///
        List<Cart> carts = cartService.getCartsById(u.getId());
        if (carts != null) {
            for (Cart c:carts) {
                cartService.delCart(c.getId());
            }
            req.getRequestDispatcher("/mycart.jsp").forward(req,resp);
        } else
            resp.sendRedirect("/onlineshop/404.jsp");
    }

}