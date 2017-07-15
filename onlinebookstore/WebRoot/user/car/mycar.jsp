<%@ page language="java" import="java.util.*,java.util.concurrent.*,user.*,usercar.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/mycar.css">
	

  </head>
  
  <body>
  	<div class="mycar">
  	<h2>你的购物车有以下书籍：</h2>
  	<table>
  		<tr><th>书名</th><th>单价</th><th>数量</th></tr>
    <%
    	String id = (String) request.getParameter("id");
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
    		<td><%= book.getTotal() %></td>
    	</tr>
    <%
    	}
    %>
    </table>
    <h3>合计：¥&nbsp;<%= myuser.getSum() %></h3>
    <a href="/onlinebookstore/user/car/buybook.jsp?id=<%= id %>&pageNow=1"><input type="button" name="continue" value="继续购买"></a>
    <a href="/onlinebookstore/user/car/modify.jsp?id=<%= id %>"><input type="button" name="modify" value="修改购物车"></a>
    <a href="/onlinebookstore/clear?id=<%= id %>"><input type="button" name="clear" value="清空购物车"></a>
    <a href="#"><input type="button" name="pay" value="支付"></a>
    </div>
  </body>
</html>
