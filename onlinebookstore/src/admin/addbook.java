package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;

public class addbook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String toJSP="";
		String admin = (String) request.getParameter("admin");
		String name = (String) request.getParameter("name");
		String author = (String) request.getParameter("author");
		String press = (String) request.getParameter("press");
		String date = (String) request.getParameter("date");
		String price = (String) request.getParameter("price");
		
		String sql = "insert into book(name,author,press,date,price) values('" + name +
				"','" + author + "','" + press + "','" + date + "','" + price + "')";
	
		try {
			dao.update(sql);
		} catch (Exception e) {
			toJSP = "admin/addbook/adderror.jsp?admin=" + admin;	
		}
		toJSP = "admin/addbook/addsuccess.jsp?admin=" + admin;
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
