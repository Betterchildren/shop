package shop.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.entity.Shop_CATEGORY;
import shop.service.Shop_CATEGORYDao;

/**
 * Servlet implementation class ToProductAdd
 */
@WebServlet("/manage/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		ArrayList<Shop_CATEGORY> flist =  Shop_CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<Shop_CATEGORY> clist =  Shop_CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);;
		
	}

	

}
