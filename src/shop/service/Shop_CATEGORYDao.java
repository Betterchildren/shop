package shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.dao.Basedao;
import shop.entity.Shop_CATEGORY;
import shop.entity.Shop_USER;

/**
 * 获取所有分类
 * @author Administrator
 *
 */
public class Shop_CATEGORYDao {
	public static ArrayList<Shop_CATEGORY> selectAll() {
		ArrayList<Shop_CATEGORY> list = new ArrayList<Shop_CATEGORY>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from Shop_CATEGORY";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Shop_CATEGORY cate = new Shop_CATEGORY(
						 	rs.getInt("CATE_ID"),
						 	rs.getString("CATE_NAME"),
						 	rs.getInt("CATE_PARENT_ID")
						 
						 );
				 
				 
				 list.add(cate);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	/**
	 * 查询分类，子分类和父级分类
	 * @param flag  flag="father" flag="child"
	 * @return
	 */
	
	public static ArrayList<Shop_CATEGORY> selectCat(String flag) {
		ArrayList<Shop_CATEGORY> list = new ArrayList<Shop_CATEGORY>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			
			String sql = null;
			
			if(flag!=null && flag.equals("father")){
			
				sql = "select * from Shop_CATEGORY where CATE_PARENT_ID=0";
			}else{
				sql = "select * from Shop_CATEGORY where CATE_PARENT_ID!=0";
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Shop_CATEGORY cate = new Shop_CATEGORY(
						 	rs.getInt("CATE_ID"),
						 	rs.getString("CATE_NAME"),
						 	rs.getInt("CATE_PARENT_ID")
						 
						 );
				 
				 
				 list.add(cate);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	
	public static Shop_CATEGORY selectById(int id) {

		Shop_CATEGORY cate = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select *  from Shop_CATEGORY  where CATE_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 cate = new Shop_CATEGORY(
						 	rs.getInt("CATE_ID"),
						 	rs.getString("CATE_NAME"),
						 	rs.getInt("CATE_PARENT_ID")
			
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return cate;
	}
	
	
	
	/**
	 * 添加分类
	 * @param cate
	 * @return
	 */
	
	public static int insert(Shop_CATEGORY cate) {
		String sql = "insert into Shop_category values(null, ?, ?)";
		
		Object[] params = {
					cate.getCATE_NAME(), 
					cate.getCATE_PARENT_ID()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	

	public static int update(Shop_CATEGORY cate) {
		String sql = "update Shop_CATEGORY set CATE_NAME=?, CATE_PARENT_ID=?  where CATE_ID = ?";
		
		Object[] params = {
					cate.getCATE_NAME(),
					cate.getCATE_PARENT_ID(),
					cate.getCATE_ID()
					};
		
		return Basedao.exectuIUD(sql, params);
}

	
	public static int del(int id) {
		String sql = "delete from Shop_CATEGORY where CATE_ID=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
		
	}
	
	
	

}
