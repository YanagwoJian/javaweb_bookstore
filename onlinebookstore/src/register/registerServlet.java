package register;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;

public class registerServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String toJSP = "";
		String id = request.getParameter("id");
		String pwd1 = request.getParameter("pwd1");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		
		String sql = "insert into user(id,pwd1,name,sex,phone) values('" + id + "','" + pwd1+
				"','" + name + "','" + sex + "','" + phone + "')";
		
		if(isExist(id)) {
			toJSP = "user/register/iderror.jsp";
		}
		else {
			try {
				dao.update(sql);
			} catch (Exception e) {
				
			}
			toJSP = "user/register/registersuccess.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}
	
	public boolean isExist(String id) {
		boolean b = false;
		String sql = "select * from user where id = '" + id + "'";
		try {
			ResultSet rs = dao.query(sql);
			if(rs.next()) {
				b = true;
			}
			dao.close(dao.getConn(), dao.getSt(), rs);
		}catch(Exception e) {
		}
		return b;
	}

}
