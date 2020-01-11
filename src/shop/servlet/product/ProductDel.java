package shop.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.Shop_PRODUCTDao;
import shop.service.Shop_USERDao;

/**
 * Servlet implementation class ProductDel
 */
@WebServlet("/manage/admin_del")
public class ProductDel extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	
		String id= request.getParameter("id");
		
		int count = Shop_PRODUCTDao.del(id);
		if(count >0 ) {
			
			response.sendRedirect("admin_productselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('产品删除失败')");
			out.write("location.href='manage/admin_productselect");
			out.write("</script>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
