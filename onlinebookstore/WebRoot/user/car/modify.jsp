<%@ page language="java" import="java.util.*,java.util.concurrent.*,user.*,usercar.*" pageEncoding="UTF-8"%>

<%
	String id = (String) request.getParameter("id");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改购物车</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/mycar.css">
	

  </head>
  
  <body>
  	<div class="modify">
	    <h2>你的购物车有以下书籍：</h2>
	    <form action="/onlinebookstore/modify?id=<%= id %>" name="modifyform" method="post">
	  	<table>
	  		<tr><th>书名</th><th>单价</th><th>数量</th><th>删除</th></tr>
	    <%
	    	HttpSession session1 = request.getSession(); 
	    	user myuser = (user) session1.getAttribute("myuser");
	    	ConcurrentHashMap<String, mybooks> hmap = myuser.getHmap();
	    	Iterator iterator = hmap.keySet().iterator();
	    	while(iterator.hasNext()) {
	    		String key = (String) iterator.next();
	    		mybooks book = hmap.get(key);
	    %>
	    	<tr>
	    		<td><%= book.getName() %></td>
	    		<td><%= book.getPrice() %></td>
	    		<td><input type="text" name="total<%= book.getId() %>" value=<%= book.getTotal() %>></td>
	    		<td><input type="checkbox" name="id<%= book.getId() %>" value="remove"></td>
	    	</tr>
	    <%
	    	}
	    %>
	    </table>
	    <div class="sure">
	    <input type="submit" name="sure" value="确定">
	    <a href="/onlinebookstore/user/car/mycar.jsp?id=<%= id %>"><input type="button" name="back" value="取消"></a>
	   	</div>
	    </form>
    </div>
  </body>
</html>
