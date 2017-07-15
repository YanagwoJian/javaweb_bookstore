package change;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;

public class changepwd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		boolean b = false;
		String toJSP = "";
		String id = request.getParameter("id");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String sql1 = "select * from user where id = '" + id + "' and pwd1 = '" + pwd1 + "'";
		try {
			ResultSet rs = dao.query(sql1);
			if(rs.next()) {
				b = true;
			}
			dao.close(dao.getConn(), dao.getSt(), dao.getRs());
		}catch(Exception e) {
			
		}
		if(b) {
			String sql2 = "update user set pwd1 = '" + pwd2 + "' where id = '" + id + " '";
			try {
				dao.update(sql2);
			} catch (Exception e) {
			}
			toJSP = "user/info/changepwdsuccess.jsp";
		}
		else {
			toJSP = "user/info/changepwderror.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
