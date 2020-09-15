package web_study_11.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_study_11.dao.ProductDao;
import web_study_11.ds.JdbcUtil;
import web_study_11.dto.Product;

public class ProductDaoImpl implements ProductDao {
	
	private static final ProductDaoImpl instance = new ProductDaoImpl();
	
	public ProductDaoImpl() {}
	
	public static ProductDaoImpl getInstance() {
		return instance;
	}
	
	private Product getProduct(ResultSet rs) throws SQLException {
		int code = rs.getInt("CODE");
		String name = rs.getString("NAME");
		int price = rs.getInt("PRICE");
		String description = rs.getString("DESCRIPTION");
		String picUrl = rs.getString("PICTUREURL");
		
		return new Product(code, name, price, description, picUrl);
	}
	
	@Override
	public List<Product> selectProductByAll() {
		String sql = "SELECT CODE,NAME,PRICE,PICTUREURL,DESCRIPTION FROM PRODUCT ORDER BY CODE ";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<Product> list = new ArrayList<>();
					do {
						list.add(getProduct(rs));
					}while(rs.next());
					return list;
				}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
		
	}

	

	@Override
	public int insertProduct(Product pdt) {
		String sql = "INSERT INTO PRODUCT VALUES(NULL, ?, ?, ?, ?)";
		 try(Connection con = JdbcUtil.getConnection();
	                PreparedStatement pstmt = con.prepareStatement(sql)){
	            pstmt.setString(1, pdt.getName());
	            pstmt.setInt(2, pdt.getPrice());
	            pstmt.setString(3, pdt.getPicUrl());
	            pstmt.setString(4, pdt.getDescription());
	           
	            return pstmt.executeUpdate();
	        } catch (SQLException e) {
	            throw new CustomSQLException(e);
	        }
	}


	@Override
	public int updateProduct(Product pdt) {
		String sql = "UPDATE PRODUCT SET NAME = ?, PRICE = ?, PICTUREURL = ?, DESCRIPTION = ? WHERE CODE = ?";
		 try(Connection con = JdbcUtil.getConnection();
	                PreparedStatement pstmt = con.prepareStatement(sql)){
	            pstmt.setString(1, pdt.getName());
	            pstmt.setInt(2, pdt.getPrice());
	            pstmt.setString(3, pdt.getPicUrl());
	            pstmt.setString(4, pdt.getDescription());
	            pstmt.setInt(5, pdt.getCode());
	           
	            return pstmt.executeUpdate();
	        } catch (SQLException e) {
	            throw new CustomSQLException(e);
	        }
	}

	@Override
	public int deleteProduct(int code) {
		String sql = "DELETE FROM PRODUCT WHERE CODE = ?";
		try(Connection con = JdbcUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, code);
           
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
	}
	
	
	@Override
	public Product selectProductByCode(int code) {
		String sql = "SELECT CODE,NAME,PRICE,PICTUREURL,DESCRIPTION FROM PRODUCT WHERE CODE = ?";
		try(Connection con = JdbcUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
           // Product p = new Product(code);
			pstmt.setInt(1, code);
			try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                    return getProduct(rs);
                }
            }
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
		return null;
	}

	

}
