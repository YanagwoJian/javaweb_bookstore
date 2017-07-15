package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;

public class bookmanage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String toJSP="";
		String id = (String) request.getParameter("id");
		String admin = (String) request.getParameter("admin");
		
		String sql = "delete from book where id = '" + id + "'";
		
		try {
			dao.update(sql);
			toJSP = "admin/addbook/deletesuccess2.jsp?admin=" + admin;
		}catch(Exception e) {
			toJSP="admin/addbook/deleteerror2.jsp?admin=" + admin;
		}
		dao.close(dao.getConn(), dao.getSt(), dao.getRs());
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
