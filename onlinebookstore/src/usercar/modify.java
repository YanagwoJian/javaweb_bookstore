package usercar;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.user;

public class modify extends HttpServlet {

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
				mybooks book = hmap.get(key);
				String remove = (String) request.getParameter("id"+book.getId());
				String total = (String) request.getParameter("total"+book.getId());
				if(remove != null) {
					int oldtotal = book.getTotal();
					String price = book.getPrice();
					float oldsum = Float.parseFloat(price)*oldtotal;
					float sum = myuser.getSum()-oldsum;
					myuser.setSum(sum);
					hmap.remove(key);
				}else {
					if(Integer.parseInt(total) != book.getTotal()) {
						int oldtotal = book.getTotal();
						String price = book.getPrice();
						float oldsum = Float.parseFloat(price)*oldtotal;
						float sum = myuser.getSum()-oldsum;
						book.setTotal(Integer.parseInt(total));
						sum = sum+book.getTotal()*Float.parseFloat(price);
						myuser.setSum(sum);
					}
				}
			}
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
