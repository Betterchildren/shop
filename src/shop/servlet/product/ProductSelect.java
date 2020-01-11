package shop.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.entity.Shop_CATEGORY;
import shop.entity.Shop_PRODUCT;
import shop.service.Shop_CATEGORYDao;
import shop.service.Shop_PRODUCTDao;


@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		ArrayList<Shop_PRODUCT>  plist = Shop_PRODUCTDao.selectAll();
		
		request.setAttribute("plist", plist);
		
		
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
	}



}
