package sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.model.PDFContent;
import sql.util.BaseDao;

public class ContentDao extends BaseDao {

	String sql = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//添加摘要
	public int UpdateSummary(PDFContent pdfContent, int i) {
		int n = 0;
		String str = null;
		try {
			if(i == 0) {
				sql = "update pdfcontent set summary = ? where pdfid = ?;";
			}else {
				ResultSet rs1 = pdfidExist(pdfContent);
				while(rs1.next()) {
					str = rs1.getString("summary");
				}
				sql = "update pdfcontent set summary = ? where pdfid = ?;";
			}
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			if(str == null) {
				ps.setString(1, pdfContent.getSummary());
			}else {
				ps.setString(1, str + pdfContent.getSummary());
			}
			ps.setInt(2, pdfContent.getPdfid());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.CloseConn(conn, ps, rs);
		}
		return n;
	}
	
	//添加引言
	public int UpdateIntroduction(PDFContent pdfContent, int i) {
		int n = 0;
		String str = null;
		try {
			if(i == 0) {
				sql = "update pdfcontent set introduction = ? where pdfid = ?;";
			}else {
				ResultSet rs1 = pdfidExist(pdfContent);
				while(rs1.next()) {
					str = rs1.getString("introduction");
				}
				sql = "update pdfcontent set introduction = ? where pdfid = ?;";
			}
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			if(str == null) {
				ps.setString(1, pdfContent.getIntroduction());
			}else {
				ps.setString(1, str + pdfContent.getIntroduction());
			}
			ps.setInt(2, pdfContent.getPdfid());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.CloseConn(conn, ps, rs);
		}
		return n;
	}
	
	//添加内容
	public int UpdateContent(PDFContent pdfContent, int i) {
		int n = 0;
		String str = null;
		try {
			if(i == 0) {
				//更新且覆盖原有内容
				sql = "update pdfcontent set content = ? where pdfid = ?;";
			}else {
				//更新但不覆盖原有内容
				ResultSet rs1 = pdfidExist(pdfContent);
				while(rs1.next()) {
					str = rs1.getString("content");
				}
				sql = "update pdfcontent set content = ? where pdfid = ?;";
			}
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			if(str == null) {
				ps.setString(1, pdfContent.getContent());
			}else {
				ps.setString(1, str + pdfContent.getContent());
			}
			ps.setInt(2, pdfContent.getPdfid());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.CloseConn(conn, ps, rs);
		}
		return n;
	}
	
	//添加参考文献
	public int UpdateReference(PDFContent pdfContent, int i) {
		int n = 0;
		String str = null;
		try {
			if(i == 0) {
				sql = "update pdfcontent set reference = ? where pdfid = ?;";
			}else {
				ResultSet rs1 = pdfidExist(pdfContent);
				while(rs1.next()) {
					str = rs1.getString("reference");
				}
				sql = "update pdfcontent set reference = ? where pdfid = ?;";
			}
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			if(str == null) {
				ps.setString(1, pdfContent.getReference());
			}else {
				ps.setString(1, str + pdfContent.getReference());
			}
			ps.setInt(2, pdfContent.getPdfid());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.CloseConn(conn, ps, rs);
		}
		return n;
	}
	
	//添加相关联的pdfid
	public int InsertPDFID(int pdfid) {
		int n = 0;
		try {
			sql = "insert into pdfcontent(pdfid) values(?);";
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pdfid);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.CloseConn(conn, ps, rs);
		}
		return n;
	}
	
	//判断pdfid是否存在，存在返回结果集
	public ResultSet pdfidExist(PDFContent pdfContent) {
		try {
			sql = "select * from pdfcontent where pdfid = ?;";
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pdfContent.getPdfid());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
