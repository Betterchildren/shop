package shop.servlet.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.entity.Shop_CART;
import shop.entity.Shop_PRODUCT;
import shop.service.Shop_CARTDao;
import shop.service.Shop_PRODUCTDao;

@WebServlet("/manage/admin_cartlist")
public class CartList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<Shop_CART>  clist = Shop_CARTDao.selectAll();
		
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("admin_order.jsp").forward(request, response);
	}

}
