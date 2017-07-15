package sql.dao;

import java.sql.*;

import sql.model.PDF;
import sql.util.BaseDao;

public class PDFDao extends BaseDao {

	String sql = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//判断表中是否有此记录并获取
	public ResultSet hasID(int id) {
		try {
			sql = "select * from pdf where id = ?;";
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//通过id获取pdf信息
	public ResultSet pdfMess(int id) {
		try {
			sql = "select * from pdf where id = ?;";
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//获取最后一条记录
	public ResultSet lastPDF() {
		try {
			sql = "select * from pdf order by id desc limit 1;";
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//获取所有pdf书籍
	public ResultSet ShowPDF() {
		try {
			//sql语句
			sql = "select * from pdf;";
			//创建Connection
			conn = this.getConn();
			//执行sql语句
			ps = conn.prepareStatement(sql);
			//得到结果集
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//添加新的pdf
	public int Insert(PDF pdf) {
		int n = 0;
		try {
			sql = "insert into pdf(title, author) values(?, ?);";
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdf.getTitle());
			ps.setString(2, pdf.getAuthor());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.CloseConn(conn, ps, rs);
		}
		return n;
	}
}
