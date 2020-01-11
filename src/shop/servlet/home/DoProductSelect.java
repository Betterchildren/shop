package shop.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.entity.Shop_PRODUCT;
import shop.entity.Shop_USER;
import shop.service.Shop_PRODUCTDao;
import shop.service.Shop_USERDao;

/**
 * Servlet implementation class DoProductSelect
 */
@WebServlet("/doproductselect")
public class DoProductSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String keyword = request.getParameter("keywords");
		
		ArrayList<Shop_PRODUCT>	list= Shop_PRODUCTDao.selectAll1(keyword);
		request.setAttribute("list", list);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
		
	}

	

}
