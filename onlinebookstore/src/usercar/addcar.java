package usercar;

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
import dao.dao;

public class addcar extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = (String) request.getParameter("id");
		String pageNow = (String) request.getParameter("pageNow");
		String bookid = (String) request.getParameter("bookid");
		
		HttpSession session = request.getSession();
		user myuser = (user) session.getAttribute("myuser");
		ConcurrentHashMap<String, mybooks> hmap = myuser.getHmap();
		String sql = "select * from book where id = '" + bookid + "'";
		ResultSet rs = null;
		
			if(hmap.get(bookid) == null) {
				mybooks book = new mybooks();
				book.setId(bookid);
				String name = null;
				String price = null;
				
				try {
					rs = dao.query(sql);
					while(rs.next()) {
			    		name = rs.getString(2);
			    		price = rs.getString(6);
			    	}
				} catch (Exception e) {
					e.printStackTrace();
				}
				dao.close(dao.getConn(), dao.getSt(), rs);
				book.setName(name);
				book.setPrice(price);
				book.setTotal(1);
				hmap.put(book.getId(), book);
				float sum = myuser.getSum();
				myuser.setSum(sum + Integer.parseInt(price));
			}else {
				mybooks book = hmap.get(bookid);
				int n = book.getTotal();
				book.setTotal(n+1);
				float sum = myuser.getSum();
				myuser.setSum(sum + Integer.parseInt(book.getPrice()));
			}
		
		String toJSP = "user/car/buybook.jsp?id=" + id + "&pageNow=" + pageNow;
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
