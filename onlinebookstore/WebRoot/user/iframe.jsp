<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
	String id = (String) request.getParameter("id"); 
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
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/iframe.css">
	

  </head>
  
  <body>
  	<div>
	    <iframe src="/onlinebookstore/user/all.jsp?id=<%= id %>">
	    </iframe>
    </div>
  </body>
</html>
