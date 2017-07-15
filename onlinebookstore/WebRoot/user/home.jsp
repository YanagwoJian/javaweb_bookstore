<%@ page language="java" import="java.util.*,user.user,java.text.SimpleDateFormat" pageEncoding="UTF-8"%>

<%
	String id = (String)request.getParameter("id");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎来到简易书城</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/home.css">

  </head>
  
<body>
  	<div class="header">
	    <div class="nav">
	    	<a href="/onlinebookstore/user/car/buybook.jsp?id=<%= id %>" target="content">购书商城</a>&nbsp;
	    	<a href="/onlinebookstore/user/info/userinfo.jsp?id=<%= id %>" target="content">我的账号</a>&nbsp;
	    	<a href="/onlinebookstore/user/info/changeinfo.jsp?id=<%= id %>" target="content">修改信息</a>&nbsp;
	    	<a href="/onlinebookstore/user/info/changepassword.jsp?id=<%= id %>" target="content">修改密码</a>&nbsp;
	    	<a href="/onlinebookstore/user/car/mycar.jsp?id=<%= id %>" target="content">购物车</a>&nbsp;
	    	<a href="/onlinebookstore/remove" target="_top">安全退出</a>
	    </div>
    </div>
 </body>
</html>
