<%@ page language="java" import="java.util.*,dao.dao,java.sql.*" pageEncoding="UTF-8"%>

<%
	String id = (String) request.getParameter("id");
	String sql = "select * from user where id = " + id;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人信息</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/userinfo.css">
	

  </head>
  
  <body>
    <%
    try {
		ResultSet rs = dao.query(sql);
		rs.beforeFirst();
		while(rs.next()) {
	%>
	<div class="info">
		<h1>账号信息</h1>
  		<div>&nbsp;&nbsp;<h3>账号：</h3><%= rs.getString("id") %></div>
  		<div>&nbsp;&nbsp;<h3>密码：</h3>*********</div>		
  		<div>&nbsp;&nbsp;<h3>姓名：</h3><%= rs.getString("name") %></div>		
  		<div>&nbsp;&nbsp;<h3>性别：</h3><%= rs.getString("sex") %></div>
  		<div>&nbsp;&nbsp;<h3>电话：</h3><%= rs.getString("phone") %></div>
  	</div>		
	<% 
		}
		}catch(Exception e) {
			
		}
	%>		
  </body>
</html>
