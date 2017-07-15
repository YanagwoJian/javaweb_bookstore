<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
	String admin = (String) request.getParameter("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <frameset rows="15%,65%,*" framespacing="0" frameborder="no">
  	<frame src="/onlinebookstore/admin/adminhome.jsp?admin=<%= admin %>" name="header" noresize scrolling="no">
  	<frame src="/onlinebookstore/admin/deluser/usermanage.jsp?admin=<%= admin %>" name="content" noresize scrolling="no">
  	<frame src="/onlinebookstore/admin/adminfooter.html" name="footer" noresize scrolling="no">
  </frameset>
</html>
