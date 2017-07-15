package userlogin;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.user;
import usercar.mybooks;
import dao.dao;

public class login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String toJSP = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String pwd1 = request.getParameter("pwd1");
		
		HttpSession session = request.getSession();
		user myuser = null;
		
		String sql = "select * from user where id = '" + id + "' and pwd1 = '" + pwd1 + "'";
		
		try {
			ResultSet rs = dao.query(sql);
			if(rs.next()) {
				toJSP = "user/iframe.jsp?id=" + id;
			}
			else {
				toJSP="user/login/loginerror.jsp";
			}
			dao.close(dao.getConn(), dao.getSt(), dao.getRs());
		}catch(Exception e) {
			
		}
		
		ConcurrentHashMap<String, mybooks> hmap = new ConcurrentHashMap<String, mybooks>();
		float sum = 0;
		myuser = new user(id, hmap, sum);
		session.setAttribute("myuser", myuser);
		
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}
}
