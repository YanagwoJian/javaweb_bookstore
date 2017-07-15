package usercar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.user;

public class clear extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String toJSP = "";
		String id = (String) request.getParameter("id");
		HttpSession session = request.getSession();
		user myuser = (user) session.getAttribute("myuser");
		ConcurrentHashMap<String, mybooks> hmap = myuser.getHmap();
		Iterator iterator = hmap.keySet().iterator();
		try {
			while(iterator.hasNext()) {
				String key = (String) iterator.next();
				hmap.remove(key);
			}
			myuser.setSum(0);
		} catch (Exception e) {
			toJSP = "user/car/modifyerror.jsp?id=" + id;
			RequestDispatcher rd = request.getRequestDispatcher(toJSP);
			rd.forward(request, response);
		}
		toJSP = "user/car/modifysuccess.jsp?id=" + id;
		RequestDispatcher rd = request.getRequestDispatcher(toJSP);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
