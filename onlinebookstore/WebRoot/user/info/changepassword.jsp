<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
	String id = request.getParameter("id");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>
    

	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/changepwd.css">
	
	<script type="text/javascript" src="js/book.js" charset="UTF-8"></script>

  </head>
  
  <body>
    <form action="/onlinebookstore/changepwd?id=<%= id %>" method="post" name="form">
    	<div class="pwd">
    		<h1>修改密码</h1>
	    	<div>
	    		账号：&nbsp;&nbsp;&nbsp;<input type="text" name="id" value="<%= id %>" disabled="disabled">
	    	</div>
	    	<div>
	    		旧密码：&nbsp;&nbsp;<input type="password" name="pwd1">
	    	</div>
	    	<div>
	    		新密码：&nbsp;&nbsp;<input type="password" name="pwd2">
	    	</div>
	    	<div>
	    		确认新密码：<input type="password" name="pwd3">
	    	</div>
	    	<input type="submit" value="保存" onclick="return changePassword()" id="save">
    	</div>
    </form>
  </body>
</html>
