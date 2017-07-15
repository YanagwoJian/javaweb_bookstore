package sql.util;

import java.sql.*;

public class BaseDao {

	//数据库驱动
	private static final String DRIVAER = "com.mysql.jdbc.Driver";
	//地址
	private static final String URL = "jdbc:mysql://localhost:3306/ocr?characterEncoding=UTF-8";
	//用户名
	private static final String USER = "root";
	//密码
	private static final String PWD ="root";
	
	
	//打开连接
	public Connection getConn() {
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(DRIVAER);
			//获取连接
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	//释放资源
	public void CloseConn(Connection conn, PreparedStatement ps, ResultSet rs) {
			try {
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
