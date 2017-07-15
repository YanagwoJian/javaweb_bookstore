<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
	String admin = (String) request.getParameter("admin"); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'adminiframe.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/adminiframe.css">
	

  </head>
  
  <body style="background-color: #A287C8;">
    <div class="adminiframe">
	    <iframe src="/onlinebookstore/admin/adminall.jsp?admin=<%= admin %>">
	    </iframe>
    </div>
  </body>
</html>
