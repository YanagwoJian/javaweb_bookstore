<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改失败</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/mycar.css">
	

  </head>
  
  <body>
     <% 
    	String id = (String) request.getParameter("id");
    	response.setHeader("Refresh","2;URL=/onlinebookstore/user/car/mycar.jsp?id=" + id); 
    %>
    <div class="error">
    	<h3>修改失败，2秒后返回购物车页面</h3>
    </div>
  </body>
</html>
