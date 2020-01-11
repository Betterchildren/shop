package shop.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.entity.Shop_CATEGORY;
import shop.entity.Shop_PRODUCT;
import shop.service.Shop_CATEGORYDao;
import shop.service.Shop_PRODUCTDao;

/**
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Shop_CATEGORY> flist =  Shop_CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<Shop_CATEGORY> clist =  Shop_CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		String id = request.getParameter("id");
	
		//获取最近访问
		
		HttpSession session = request.getSession();
		
		//从SSESSIOn获取一下 ids
		
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
		
		if(ids == null){
			ids = new ArrayList<Integer>();
		}
			
		//最多放5， 如果多出5个将第一个删除
		if(ids.size() >= 5) {
			ids.remove(0);
		}
		
		// 添加列表里， 但只要一份
		if(id!=null && (!ids.contains(Integer.parseInt(id)))) {
			ids.add(Integer.parseInt(id));
		
		}
		
		session.setAttribute("ids", ids);
		
		ids= (ArrayList<Integer>)session.getAttribute("ids");
		
		if(ids!=null) {
				
			ArrayList<Shop_PRODUCT> lastlylist = Shop_PRODUCTDao.selectAllById(ids);
			request.setAttribute("lastlylist", lastlylist);
		}
		
		
		Shop_PRODUCT p = null;
		
		if(id !=null) {
			p = Shop_PRODUCTDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		
		
		if(p!=null) {
			int cid = p.getPRODUCT_CID();
			ArrayList<Shop_PRODUCT> classlist = Shop_PRODUCTDao.selectAllByCid(cid);
			request.setAttribute("classlist", classlist);
			
			Shop_CATEGORY cate = Shop_CATEGORYDao.selectById(cid);
			
			request.setAttribute("cate", cate);
		}
		
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}

	
}
