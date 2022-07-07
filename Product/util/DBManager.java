package util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context  envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	// select 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// insert, delete, update 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
