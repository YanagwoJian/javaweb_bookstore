package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;

public class adminlogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String toJSP = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String admin = request.getParameter("admin");
		String pwd = request.getParameter("pwd");
		
		String sql = "select * from admin where admin = '" + admin + "' and pwd = '" + pwd + "'";
		
		try {
			ResultSet rs = dao.query(sql);
			if(rs.next()) {
				toJSP = "admin/adminiframe.jsp?admin=" + admin;
			}
			else {
				toJSP="user/login/loginerror.jsp?admin=" + admin;
			}
			dao.close(dao.getConn(), dao.getSt(), dao.getRs());
		}catch(Exception e) {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
