package shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.entity.Shop_CART;
import shop.entity.Shop_PRODUCT;

import shop.dao.Basedao;

public class Shop_CARTDao {
	//查询订单
	public static ArrayList<Shop_CART> selectAll(){
		ArrayList<Shop_CART> list = new ArrayList<Shop_CART>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "select * from Shop_CART";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Shop_CART c = new Shop_CART(
						 	rs.getInt("CART_ID"),
						 	rs.getString("cart_p_filename"),
						 	rs.getString("cart_p_name"),
						 	rs.getInt("cart_p_price"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_p_stock"),
						 	rs.getInt("cart_p_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );				 
				 list.add(c);				 
			 }		 			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;	}
	
	
	
	public static int insert(Shop_CART cart){
		String sql = "insert into shop_cart values(null,?,?,?,?,?,?,?,1)";
		
		Object[] params = {
				cart.getCart_p_filename(),
				cart.getCart_p_name(),
				cart.getCart_p_price(),
				cart.getCart_quantity(),
				cart.getCart_p_stock(),
				cart.getCart_p_id(),
				cart.getCart_u_id()
				
		};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static Shop_CART getCartShop(String id) {
		Shop_CART es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from Shop_CART where CART_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
		
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new Shop_CART(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_p_filename"),
						 	rs.getString("cart_p_name"),
						 	rs.getInt("cart_p_price"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_p_stock"),
						 	rs.getInt("cart_p_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );
				 
				 
				
				 
	
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	
	

	public static Shop_CART getCartShop(String uid, String pid) {
		Shop_CART es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from Shop_CART where CART_U_ID=? and CART_P_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(pid));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new Shop_CART(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_p_filename"),
						 	rs.getString("cart_p_name"),
						 	rs.getInt("cart_p_price"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_p_stock"),
						 	rs.getInt("cart_p_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );
	 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	
	
	public static ArrayList<Shop_CART> getCart(String id){
		ArrayList<Shop_CART> list = new ArrayList<Shop_CART>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();	
		PreparedStatement ps = null;
		try {
			String sql = "select * from Shop_CART where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Shop_CART c = new Shop_CART(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_p_filename"),
						 	rs.getString("cart_p_name"),
						 	rs.getInt("cart_p_price"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_p_stock"),
						 	rs.getInt("cart_p_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );				
				 list.add(c);	 
			 }		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	public static int updatenum(int esid, int count){
		
		String sql = "update shop_cart set cart_quantity=? where cart_id=? ";
		
		Object[] params = {count, esid};
		
		return Basedao.exectuIUD(sql, params);
		
	}
	
	public static int getDeleteDD(int id) {
		String sql="delete from shop_cart where cart_id=?";
		
		Object[] params={id};
		
		return Basedao.exectuIUD(sql, params);
	}
	
}
