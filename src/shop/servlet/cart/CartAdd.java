package shop.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.entity.Shop_CART;
import shop.entity.Shop_PRODUCT;
import shop.entity.Shop_USER;
import shop.service.Shop_CARTDao;
import shop.service.Shop_PRODUCTDao;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Shop_PRODUCT p = null;
		
		String pid = request.getParameter("id");
		String count = request.getParameter("count");
		String url = request.getParameter("url");
		
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		Shop_USER user=(Shop_USER)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			
			String uid = (String)user.getUSER_ID();
			
			
			//通过用户ID和购物车中的商品ID 查看有没有这条记录
			
			Shop_CART srcsp = Shop_CARTDao.getCartShop(uid, pid);
			
			if(srcsp != null) {
				int srccount = srcsp.getCart_quantity();
				
				int newcount = srccount + Integer.parseInt(count);
				
				if(newcount >=5) {
					newcount =5;
				}
				
				Shop_CARTDao.updatenum(srcsp.getCart_id(), newcount);
				
			}else{
			
			
				if(pid !=null) {
					p  = Shop_PRODUCTDao.selectById(Integer.parseInt(pid));
				}
				
				Shop_CART cart = new Shop_CART(
							0,
							p.getPRODUCT_FILENAME(),
							p.getPRODUCT_NAME(),
							p.getPRODUCT_PRICE(),
							Integer.parseInt(count),
							p.getPRODUCT_STOCK(),
							p.getPRODUCT_ID(),
							uid,
							1
							
						);
				
				Shop_CARTDao.insert(cart);
			}
			
		}else{
			
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('登录后，再购买')");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(url.equals("z")) {
			response.sendRedirect("showcart");
		}else{
			response.sendRedirect("selectproductview?id="+pid);
		}
		
	}

	

}
