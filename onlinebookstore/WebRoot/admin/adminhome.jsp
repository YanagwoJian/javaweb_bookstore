<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String admin = (String) request.getParameter("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员管理页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/adminhome.css">
	

  </head>
  
  <body>
  	<div class="head">
	    <div class="nav">
	    	<h2><a href="/onlinebookstore/admin/deluser/usermanage.jsp?admin=<%= admin %>" target="content">用户管理&nbsp;&nbsp;</a></h2>
	    	<h2><a href="/onlinebookstore/admin/addbook/addbook.jsp?admin=<%= admin %>" target="content">添加书籍&nbsp;&nbsp;</a></h2>
	    	<h2><a href="/onlinebookstore/admin/addbook/bookmanage.jsp?admin=<%= admin %>" target="content">删除书籍&nbsp;&nbsp;</a></h2>
	    	<h2><a href="/onlinebookstore/admin/adminlogin.jsp" target="_top">退出</a></h2>
	    </div>
	   </div>
  </body>
</html>
