<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'deleteerror2.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body style="background-color: #A287C8;">
    <% 
 		String admin = (String) request.getParameter("admin");
 		response.setHeader("Refresh","3;URL=/onlinebookstore/admin/addbook/bookmanage.jsp?admin=" + admin); 
 	%>
 	<div style="margin-left: 400px;">
    	<h3>删除失败</h3>
    </div>
  </body>
</html>
