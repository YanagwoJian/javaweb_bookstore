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
	
	

  </head>
  
  <frameset rows="15%,65%,*" framespacing="0" frameborder="no">
  	<frame src="/onlinebookstore/user/home.jsp?id=<%= id %>" name="header" noresize scrolling="no">
  	<frame src="/onlinebookstore/user/car/buybook.jsp?id=<%= id %>" name="content" noresize scrolling="no">
  	<frame src="/onlinebookstore/user/footer.html" name="footer" noresize scrolling="no">
  </frameset>
</html>
