package com.jsp.dao;

import java.sql.*;
import java.util.*;

import com.jsp.cafe.ProductVO;

import util.DBManager;

public class ProductDAO {
	private ProductDAO() {

	}

	private static ProductDAO instanec = new ProductDAO();

	public static ProductDAO getInstance() {
		return instanec;
	}

	// C(create)/R(read)/U(update)/D(delete)
	public List<ProductVO> selectAllProducts() {
		// 최근에 등록한 상품 먼저 출력하기
		String sql = "select * from product order by code desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				list.add(pVo);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 상품 등록
	public void insertProduct(ProductVO pVo) {
		String sql = "insert into product values(product_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureurl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.executeUpdate(); // insert 실행
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ProductVO selectProductByCode(String code) {
		String sql = "select * from product where code=?";
		ProductVO pVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					pVo = new ProductVO();
					pVo.setCode(rs.getInt("code"));
					pVo.setName(rs.getString("name"));
					pVo.setPrice(rs.getInt("price"));
					pVo.setPictureurl(rs.getString("pictureurl"));
					pVo.setDescription(rs.getString("description"));
				}

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				DBManager.close(conn, pstmt, rs);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return pVo;
	}
	
	public void updateProduct(ProductVO pVo) {
		String sql = "update product set name=?, price=?, pictureurl=?, description=? where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureurl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setInt(5, pVo.getCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteProduct(String code) {
		String sql = "delete product where code =?";
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
