package dao;

import java.sql.*;

public final class dao {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test?user=root&password=&characterEncoding=gb2312";
	private static String user = "root";
	private static String password = "";
	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		return conn;
	}

	public static ResultSet getRs() {
		return rs;
	}

	public static Statement getSt() {
		return st;
	}

	public static Connection getConnection() {
		try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
 
        return conn;
 
	}
	public static ResultSet query(String sql) throws Exception {
		if(conn == null || conn.isClosed()) { 
			conn = getConnection();
		}
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public static void update(String sql) throws Exception {
		if(conn == null || conn.isClosed()) { 
			conn = getConnection();
		}
		st = conn.createStatement();
		st.executeUpdate(sql);
		close(conn,st,rs);
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				st = null;
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
}

